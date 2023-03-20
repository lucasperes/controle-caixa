package br.com.w2s.api.controlecaixa.utils.java;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.domain.Page;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe Utilitaria para validacoes da aplicacao </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
public class ValidationUtils {

	/**
	 * Construtor privado para evitar instaciacoes externa
	 */
	private ValidationUtils() {
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Verifica se um Objeto e nulo </p>
	 *
	 * @param obj {@link Object} objeto de comparacao
	 * @return {@link Boolean}
	 */
	public static boolean isNull(Object obj) {
		return obj == null;
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Verifica se um Objeto nao e nulo </p>
	 *
	 * @param obj {@link Object} objeto de comparacao
	 * @return {@link Boolean}
	 */
	public static boolean isNotNull(Object obj) {
		return !isNull(obj);
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Verifica se um Objeto ou Collection e nulo </p>
	 *
	 * @param obj {@link Object} objeto de comparacao
	 * @return {@link Boolean}
	 */
	public static boolean isEmpty(Object obj) {
		return isNull(obj) || obj.toString().isEmpty() || obj.toString().isBlank() 
				|| (obj instanceof Collection<?> && ((Collection<?>) obj).isEmpty())
				|| (obj instanceof Map<?, ?> && ((Map<?, ?>) obj).isEmpty())
				|| (obj instanceof Page<?> && ((Page<?>) obj).getContent().isEmpty())
				|| (obj instanceof Object[] && ((Object[]) obj).length <= 0);
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Verifica se um Objeto ou Collection nao e nulo </p>
	 *
	 * @param obj {@link Object} objeto de comparacao
	 * @return {@link Boolean}
	 */
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}
	
}
