package br.com.w2s.api.controlecaixa.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe Utilitaria para a aplicacao </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
public class ApplicationHelper {

	/**
	 * Construtor privado para evitar instanciacoes externas
	 */
	private ApplicationHelper() {
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Extrai o stackTrace de uma {@link Exception} e retorna seu texto </p>
	 *
	 * @param err {@link Exception}
	 * @return {@link String}
	 */
	public static String extractStackTrace(Exception err) {
		String trace = null;
		if(err != null) {
			StringWriter writer = new StringWriter();
			PrintWriter print = new PrintWriter(writer);
			err.printStackTrace(print);
			
			trace = writer.toString();
		}
		return trace;
	}
	
}
