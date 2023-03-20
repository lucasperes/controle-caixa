package br.com.w2s.api.controlecaixa.facade.movimentacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.w2s.api.controlecaixa.domain.dto.movimentacao.MovimentacaoDTO;
import br.com.w2s.api.controlecaixa.domain.dto.movimentacao.filter.MovimentacoesFilterDTO;
import br.com.w2s.api.controlecaixa.domain.entity.movimentacao.MovimentacaoEntity;
import br.com.w2s.api.controlecaixa.domain.enums.caixa.StatusCaixaContaEnum;
import br.com.w2s.api.controlecaixa.domain.enums.caixa.TipoCaixaContaEnum;
import br.com.w2s.api.controlecaixa.domain.enums.movimentacao.TipoMovimentacaoEnum;
import br.com.w2s.api.controlecaixa.facade.AbstractFacadeBase;
import br.com.w2s.api.controlecaixa.service.movimentacao.IMovimentacaoService;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe Facade para {@link MovimentacaoEntity} </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
@Component
public class MovimentacaoFacade extends AbstractFacadeBase {
	
	private static final long serialVersionUID = 8923020110615016157L;
	
	@Autowired
	private IMovimentacaoService service;
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Lista os {@link MovimentacaoEntity} filtrados e paginados </p>
	 *
	 * @param nome {@link String}
	 * @param tipo {@link TipoCaixaContaEnum}
	 * @param status {@link StatusCaixaContaEnum}
	 * @param pageable {@link Pageable}
	 * @return {@link Page} de {@link MovimentacaoDTO}
	 */
	public Page<MovimentacaoDTO> list(Integer caixaContaId, String numeroTransacao, TipoMovimentacaoEnum tipo,
			String historico, Boolean isConsolidado, Pageable pageable) {
		MovimentacoesFilterDTO filter = new MovimentacoesFilterDTO(caixaContaId, numeroTransacao, tipo, historico,
				isConsolidado, pageable);
		return mapperSafeNull(service.list(filter), MovimentacaoDTO.class);
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Busca um {@link MovimentacaoEntity} pelo seu ID </p>
	 *
	 * @param id {@link Long}
	 * @return {@link MovimentacaoDTO}
	 */
	public MovimentacaoDTO findById(Long id) {
		return mapperSafeNull(service.findById(id), MovimentacaoDTO.class);
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Persite ou Atualiza um {@link MovimentacaoEntity} </p>
	 *
	 * @param dto {@link MovimentacaoDTO}
	 * @return {@link MovimentacaoDTO}
	 */
	public MovimentacaoDTO save(MovimentacaoDTO dto) {
		MovimentacaoEntity entity = mapper(dto, MovimentacaoEntity.class);
		return mapperSafeNull(service.save(entity), MovimentacaoDTO.class);
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Consolida as {@link MovimentacaoEntity} </p>
	 *
	 * @param dtos {@link List} de {@link MovimentacaoDTO}
	 * @return {@link Void} null
	 */
	public Void consolidate(List<MovimentacaoDTO> dtos) {
		return service.consolidate(mapper(dtos, MovimentacaoEntity.class));
	}

}
