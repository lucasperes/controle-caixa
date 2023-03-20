package br.com.w2s.api.controlecaixa.domain.exception;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe Exception Core Base </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
public class ControleCaixaCoreBaseException extends RuntimeException {

	private static final long serialVersionUID = 3038406264418322072L;

	public ControleCaixaCoreBaseException(String msg) {
		super(msg);
	}
	
	public ControleCaixaCoreBaseException(Throwable cause) {
		super(cause);
	}
	
	public ControleCaixaCoreBaseException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
