package br.com.w2s.api.controlecaixa.utils.sql;

import br.com.w2s.api.controlecaixa.utils.java.ValidationUtils;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe Utilitaria para consutas SQL </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
public class SQLUtils {

	/**
	 * Construtor privado para evitar instanciacao externa
	 */
	private SQLUtils() {
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Recebe uma Query e concatena com os curinga SQL para a clausula LIKE no inicio da palavra </p>
	 *
	 * @param query {@link String}
	 * @return {@link String}
	 */
	public static String likeStartsWith(String query) {
		return ValidationUtils.isNotEmpty(query) ? query + "%" : null;
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Recebe uma Query e concatena com os curinga SQL para a clausula LIKE no final da palavra </p>
	 *
	 * @param query {@link String}
	 * @return {@link String}
	 */
	public static String likeEndsWith(String query) {
		return ValidationUtils.isNotEmpty(query) ? "%" + query : null;
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Recebe uma Query e concatena com os curinga SQL para a clausula LIKE em qualquer lugar da palavra </p>
	 *
	 * @param query {@link String}
	 * @return {@link String}
	 */
	public static String likeAnyWhere(String query) {
		return ValidationUtils.isNotEmpty(query) ? "%" + query + "%" : null;
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Recebe uma Query e concatena com os curinga SQL para a clausula LIKE em qualquer lugar da palavra com a palavra em minusculo (caixa baixa) </p>
	 *
	 * @param query {@link String}
	 * @return {@link String}
	 */
	public static String likeAnyWhereLowerCase(String query) {
		return ValidationUtils.isNotEmpty(query) ? "%" + query.toLowerCase() + "%" : null;
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Recebe uma Query e concatena com os curinga SQL para a clausula LIKE em qualquer lugar da palavra com a palavra em maiusculo (caixa alta) </p>
	 *
	 * @param query {@link String}
	 * @return {@link String}
	 */
	public static String likeAnyWhereUpperCase(String query) {
		return ValidationUtils.isNotEmpty(query) ? "%" + query.toUpperCase() + "%" : null;
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Retorna o texto tudo em caixa baixa </p>
	 *
	 * @param query {@link String}
	 * @return {@link String}
	 */
	public static String toLowerCase(String query) {
		return ValidationUtils.isNotEmpty(query) ? query.toLowerCase() : null;
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Retorna o texto tudo em caixa alta </p>
	 *
	 * @param query {@link String}
	 * @return {@link String}
	 */
	public static String toUpperCase(String query) {
		return ValidationUtils.isNotEmpty(query) ? query.toUpperCase() : null;
	}
	
}
