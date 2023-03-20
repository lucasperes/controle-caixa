package br.com.w2s.api.controlecaixa.domain.exception;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe Exception para erros de validacao em metodos </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
public class ControleCaixaValidationException extends ControleCaixaCoreBaseException {

	private static final long serialVersionUID = -537656193750001533L;

	public ControleCaixaValidationException(String msg) {
		super(msg);
	}
	
	public ControleCaixaValidationException(Throwable cause) {
		super(cause);
	}
	
	public ControleCaixaValidationException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
