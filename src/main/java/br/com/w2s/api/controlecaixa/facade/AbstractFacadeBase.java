package br.com.w2s.api.controlecaixa.facade;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.w2s.api.controlecaixa.domain.model.ModelMapperBase;
import br.com.w2s.api.controlecaixa.utils.java.ValidationUtils;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe Abstract Base para ser herdada por todas classes da camada de facades </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
public abstract class AbstractFacadeBase extends ModelMapperBase {

	private static final long serialVersionUID = -841120793872706961L;

	protected <S, T> T mapperSafeNull(S source, Class<T> typeTarget) {
		return ValidationUtils.isNotNull(source) ? mapper(source, typeTarget) : null;
	}
	
	protected <S, T> List<T> mapperSafeNull(List<S> sources, Class<T> typeTarget) {
		return ValidationUtils.isNotNull(sources) ? mapper(sources, typeTarget) : null;
	}
	
	protected <S, T> Page<T> mapperSafeNull(Page<S> sources, Class<T> typeTarget) {
		return ValidationUtils.isNotNull(sources) ? sources.map((source) ->  mapper(source, typeTarget)) : null;
	}
	
}
