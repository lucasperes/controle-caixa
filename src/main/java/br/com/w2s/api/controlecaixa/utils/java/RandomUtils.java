package br.com.w2s.api.controlecaixa.utils.java;

import java.util.Random;
import java.util.UUID;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe Utilitaria para geracao de numeros aleatorios </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
public class RandomUtils {
	
	public static final int[] NUMBERS = {0,1,2,3,4,5,6,7,8,9};

	/**
	 * Construtor privado para evitar instanciacao externa
	 */
	private RandomUtils() {
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Retorna um token numerico de numeros </p>
	 *
	 * @param length {@link Integer}
	 * @return {@link String}
	 */
	public static String generateRandomNumber(int length) {
		StringBuilder numbers = new StringBuilder();
		for(int i = 0; i < length; i++) {
			numbers.append(nextInt(9));
		}
		return numbers.toString();
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Gera um numero aleatorio </p>
	 *
	 * @param bound {@link Integer}
	 * @return {@link Integer}
	 */
	public static Integer nextInt(int bound) {
		Random random = new Random();
		return random.nextInt(bound);
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Gera uma Serial UUID Aleatoria </p>
	 *
	 * @return {@link String}
	 */
	public static String generateUUID() {
		return UUID.randomUUID().toString();
	}
	
}
