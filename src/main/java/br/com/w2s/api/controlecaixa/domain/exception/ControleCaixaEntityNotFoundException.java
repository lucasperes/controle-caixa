package br.com.w2s.api.controlecaixa.domain.exception;

import java.io.Serializable;

import lombok.Getter;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe Exception para Operacoes com Entidades nao encontradas </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
public class ControleCaixaEntityNotFoundException extends ControleCaixaCoreBaseException {

	private static final long serialVersionUID = -537656193750001533L;
	
	@Getter
	private Serializable id;

	public ControleCaixaEntityNotFoundException(String msg) {
		super(msg);
	}
	
	public ControleCaixaEntityNotFoundException(Throwable cause) {
		super(cause);
	}
	
	public ControleCaixaEntityNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public ControleCaixaEntityNotFoundException(String msg, Serializable id) {
		super(msg);
		this.id = id;
	}
	
}
