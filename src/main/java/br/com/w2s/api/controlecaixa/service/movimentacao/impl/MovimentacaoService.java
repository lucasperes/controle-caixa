package br.com.w2s.api.controlecaixa.service.movimentacao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.w2s.api.controlecaixa.domain.dto.movimentacao.filter.MovimentacoesFilterDTO;
import br.com.w2s.api.controlecaixa.domain.entity.caixa.CaixaContaEntity;
import br.com.w2s.api.controlecaixa.domain.entity.movimentacao.MovimentacaoEntity;
import br.com.w2s.api.controlecaixa.domain.enums.movimentacao.TipoMovimentacaoEnum;
import br.com.w2s.api.controlecaixa.domain.exception.ControleCaixaEntityNotFoundException;
import br.com.w2s.api.controlecaixa.domain.repository.caixa.ICaixasContasRepository;
import br.com.w2s.api.controlecaixa.domain.repository.movimentacao.IMovimentacoesRepository;
import br.com.w2s.api.controlecaixa.service.impl.AbstractServiceBase;
import br.com.w2s.api.controlecaixa.service.movimentacao.IMovimentacaoService;
import br.com.w2s.api.controlecaixa.utils.sql.SQLUtils;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe Service Para {@link MovimentacaoEntity} </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
@Service
public class MovimentacaoService extends AbstractServiceBase implements IMovimentacaoService {

	private static final long serialVersionUID = -2426225222630328364L;
	
	@Autowired
	private IMovimentacoesRepository repository;
	@Autowired
	private ICaixasContasRepository caixasContasRepository;

	@Override
	@Transactional(readOnly = true)
	public Page<MovimentacaoEntity> list(MovimentacoesFilterDTO filter) {
		return repository.list(
				filter.getCaixaContaId(),
				filter.getNumeroTransacao(),
				filter.getTipo(),
				SQLUtils.likeAnyWhereLowerCase(filter.getHistorico()),
				filter.getIsConsolidado(),
				filter.getPageable());
	}

	@Override
	@Transactional(readOnly = true)
	public MovimentacaoEntity findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public MovimentacaoEntity save(MovimentacaoEntity entity) {
		entity = new MovimentacaoEntity.Builder(entity)
				.withIdIsNull()
				.withNumeroTransacao()
				.withIsConsolidado(false)
				.withDataAtual()
				.getInstance();
		// Atualiza o valor de saldo do caixa
		updateValorSaldo(entity);
		return repository.save(entity);
	}
	
	@Override
	@Transactional
	public Void consolidate(List<MovimentacaoEntity> entities) {
		entities.forEach(e -> {
			e = findById(e.getId()); // Busca do banco para pegar as informacoes atualizada
			e.setIsConsolidado(true);
			updateValorSaldo(e);
			repository.save(e);
		});
		return null;
	}
	
	// Metodos Auxiliares
	
	private void updateValorSaldo(MovimentacaoEntity entity) {
		// Atualiza o valor de saldo do Caixa/Conta
		CaixaContaEntity caixaConta = findByIdCaixaContaOrElseThrow(entity.getCaixaConta().getId());
		// Credito
		if(TipoMovimentacaoEnum.CREDITO.equals(entity.getTipo())) {
			if(Boolean.TRUE.equals(entity.getIsConsolidado())) {
				caixaConta.setValorSaldoConsolidado(caixaConta.getValorSaldoConsolidado().add(entity.getValor()));				
			} else {				
				caixaConta.setValorSaldo(caixaConta.getValorSaldo().add(entity.getValor()));
			}
		} else if(TipoMovimentacaoEnum.DEBITO.equals(entity.getTipo())) {			
			if(Boolean.TRUE.equals(entity.getIsConsolidado())) {				
				caixaConta.setValorSaldoConsolidado(caixaConta.getValorSaldoConsolidado().subtract(entity.getValor()));
			} else {				
				caixaConta.setValorSaldo(caixaConta.getValorSaldo().subtract(entity.getValor()));
			}
		}
		caixasContasRepository.save(caixaConta);
	}
	
	private CaixaContaEntity findByIdCaixaContaOrElseThrow(Integer id) {
		StringBuilder msgError = new StringBuilder("Caixa/Conta não foi encontrado com ID = ")
				.append(id);
		CaixaContaEntity caixaConta = caixasContasRepository.findById(id)
				.orElseThrow(() -> new ControleCaixaEntityNotFoundException(msgError.toString(), id));
		
		return caixaConta;
	}
	
}
