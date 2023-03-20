package br.com.w2s.api.controlecaixa.utils.java;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import br.com.w2s.api.controlecaixa.domain.annotations.NotCopyAttr;

/**
 * @author Lucas P. Soares
 * @date 20 de mar. de 2023
 * @contact lucasperes20@gmail.com
 * @description <b>
 *	Classe Utilitaria para manipulacao de Object
 * </b>
 *
 */
public class ObjectUtils {
	
	/**
	 * Construtor privado
	 */
	private ObjectUtils() {
	}

	/**
	 * @author Lucas P. Soares
	 * @date 20 de mar. de 2023
	 * @contact lucasperes20@gmail.com
	 * @description <b>
	 *	Retorna um {@link List} com os nomes dos atributos marcados como {@link NotCopyAttr}
	 * </b>
	 *
	 * @param type {@link Class}
	 * @return {@link List} de {@link String}
	 */
	public static List<String> getListNamesPropertiesNotCopy(Class<?> type) {
		List<String> attributes = new ArrayList<>();
		if(ValidationUtils.isNotNull(type)) {
			for(Field field : type.getDeclaredFields()) {
				field.setAccessible(true);
				if(field.isAnnotationPresent(NotCopyAttr.class)) {
					attributes.add(field.getName());
					continue;
				}
			}
		}
		if(ValidationUtils.isNotNull(type.getSuperclass()) 
				&& !type.getSuperclass().getTypeName().equals(Object.class.getTypeName())) {
			// Adicona recursivamente a lista da superclass a lista original de retorno
			attributes.addAll(getListNamesPropertiesNotCopy(type.getSuperclass()));
		}
		return attributes;
	}
	
	/**
	 * @author Lucas P. Soares
	 * @date 20 de mar. de 2023
	 * @contact lucasperes20@gmail.com
	 * @description <b>
	 *	Retorna um Array com os nomes dos atributos marcados como {@link NotCopyAttr}
	 * </b>
	 *
	 * @param type {@link Class}
	 * @return Array de {@link String}
	 */
	public static String[] getArrayNamesPropertiesNotCopy(Class<?> type) {
		List<String> listNames = getListNamesPropertiesNotCopy(type);
		String[] arrayNames = new String[listNames.size()];
		return listNames.toArray(arrayNames);
	}
	
}
