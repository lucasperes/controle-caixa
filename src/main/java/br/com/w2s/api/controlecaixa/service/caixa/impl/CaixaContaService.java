package br.com.w2s.api.controlecaixa.service.caixa.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.w2s.api.controlecaixa.domain.dto.caixa.filter.CaixasContasFilterDTO;
import br.com.w2s.api.controlecaixa.domain.entity.caixa.CaixaContaEntity;
import br.com.w2s.api.controlecaixa.domain.enums.caixa.StatusCaixaContaEnum;
import br.com.w2s.api.controlecaixa.domain.exception.ControleCaixaEntityNotFoundException;
import br.com.w2s.api.controlecaixa.domain.exception.ControleCaixaValidationException;
import br.com.w2s.api.controlecaixa.domain.repository.caixa.ICaixasContasRepository;
import br.com.w2s.api.controlecaixa.service.caixa.ICaixaContaService;
import br.com.w2s.api.controlecaixa.service.impl.AbstractServiceBase;
import br.com.w2s.api.controlecaixa.utils.java.ObjectUtils;
import br.com.w2s.api.controlecaixa.utils.java.ValidationUtils;
import br.com.w2s.api.controlecaixa.utils.sql.SQLUtils;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe Service para {@link CaixaContaEntity} </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
@Service
public class CaixaContaService extends AbstractServiceBase implements ICaixaContaService {

	private static final long serialVersionUID = -2426225222630328364L;
	
	@Autowired
	private ICaixasContasRepository repository;

	@Override
	@Transactional(readOnly = true)
	public Page<CaixaContaEntity> list(CaixasContasFilterDTO filter) {
		return repository.list(
				SQLUtils.likeAnyWhereLowerCase(filter.getNome()),
				filter.getTipo(),
				filter.getStatus(),
				filter.getPageable());
	}

	@Override
	@Transactional(readOnly = true)
	public CaixaContaEntity findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public CaixaContaEntity save(CaixaContaEntity entity) {
		if(ValidationUtils.isNull(entity.getId())) {
			entity = new CaixaContaEntity.Builder(entity)
					.withDefault()
					.getInstance();
			entity = repository.save(entity);
		} else {
			CaixaContaEntity entityDB = findByIdOrElseThrow(entity.getId());
			BeanUtils.copyProperties(entity, entityDB, ObjectUtils.getArrayNamesPropertiesNotCopy(entity.getClass()));
			entity = repository.save(entityDB);
		}
		return entity;
	}

	@Override
	@Transactional
	public Void close(Integer id) {
		CaixaContaEntity entity = findByIdOrElseThrow(id);
		validateClose(entity);
		entity.setStatus(StatusCaixaContaEnum.FECHADO);
		repository.save(entity);
		return null;
	}

	@Override
	@Transactional
	public Void delete(Integer id) {
		CaixaContaEntity entity = findByIdOrElseThrow(id);
		validateDelete(entity);
		entity.setStatus(StatusCaixaContaEnum.ENCERRADO);
		repository.save(entity);
		return null;
	}
	
	// Metodos Auxiliares
	
	private CaixaContaEntity findByIdOrElseThrow(Integer id) {
		CaixaContaEntity entity = findById(id);
		if(ValidationUtils.isNull(entity)) {
			StringBuilder msg = new StringBuilder("Caixa/Conta não foi encontrado com ID = ")
					.append(id);
			throw new ControleCaixaEntityNotFoundException(msg.toString(), id);
		}
		return entity;
	}
	
	private void validateClose(CaixaContaEntity entity) {
		if(!StatusCaixaContaEnum.ABERTO.equals(entity.getStatus())) {
			throw new ControleCaixaValidationException("Não é possível fechar um Caixa/Conta com status = " + entity.getStatus());
		}
	}
	
	private void validateDelete(CaixaContaEntity entity) {
		if(StatusCaixaContaEnum.ENCERRADO.equals(entity.getStatus())) {
			throw new ControleCaixaValidationException("Não é possível encerrar um Caixa/Conta com status = " + entity.getStatus());
		}
	}

}
