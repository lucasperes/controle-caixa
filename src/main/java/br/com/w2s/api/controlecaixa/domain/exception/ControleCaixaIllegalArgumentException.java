package br.com.w2s.api.controlecaixa.domain.exception;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe Exception para Parametros de metodos invalidos </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
public class ControleCaixaIllegalArgumentException extends ControleCaixaCoreBaseException {

	private static final long serialVersionUID = -537656193750001533L;

	public ControleCaixaIllegalArgumentException(String msg) {
		super(msg);
	}
	
	public ControleCaixaIllegalArgumentException(Throwable cause) {
		super(cause);
	}
	
	public ControleCaixaIllegalArgumentException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
