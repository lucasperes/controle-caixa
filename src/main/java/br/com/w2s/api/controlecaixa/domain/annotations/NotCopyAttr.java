package br.com.w2s.api.controlecaixa.domain.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Lucas P. Soares
 * @date 20 de mar. de 2023
 * @contact lucasperes20@gmail.com
 * @description <b>
 *	Annotation Utilizada para marcar um campo como ignorado em copias de atributos
 * </b>
 *
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotCopyAttr {

}
