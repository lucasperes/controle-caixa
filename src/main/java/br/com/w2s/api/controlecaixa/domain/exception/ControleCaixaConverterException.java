package br.com.w2s.api.controlecaixa.domain.exception;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe Exception para Conversoes de Dados </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
public class ControleCaixaConverterException extends ControleCaixaCoreBaseException {

	private static final long serialVersionUID = -537656193750001533L;

	public ControleCaixaConverterException(String msg) {
		super(msg);
	}
	
	public ControleCaixaConverterException(Throwable cause) {
		super(cause);
	}
	
	public ControleCaixaConverterException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
