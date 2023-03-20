package br.com.w2s.api.controlecaixa.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import br.com.w2s.api.controlecaixa.domain.exception.ControleCaixaConverterException;
import br.com.w2s.api.controlecaixa.domain.exception.ControleCaixaIllegalArgumentException;
import br.com.w2s.api.controlecaixa.utils.java.ValidationUtils;
import lombok.Getter;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe Model Mapper Base utilizada para realizar mappres entre Entity e DTO </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
public abstract class ModelMapperBase implements Serializable {
	
	private static final long serialVersionUID = 6243062174461823271L;

	public static final Logger LOGGER = LoggerFactory.getLogger(ModelMapperBase.class);
	
	@Getter(value = lombok.AccessLevel.PROTECTED)
	private static final ModelMapper MODEL_MAPPER = new ModelMapper();
	
	@Getter(value = lombok.AccessLevel.PROTECTED)
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	static {
		MODEL_MAPPER.getConfiguration()
			.setAmbiguityIgnored(true)
			.setFieldMatchingEnabled(true)
			.setFieldAccessLevel(AccessLevel.PRIVATE);
		OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		OBJECT_MAPPER.findAndRegisterModules();
	}
	
	public static <T> T mapper(Object source, Class<T> typeTarget) {
		try {			
			return MODEL_MAPPER.map(source, typeTarget);
		} catch(Exception err) {
			final String msg = "Erro ao tentar mapear o Object Source = " + source.getClass().getName() + " para o Object Type = " + typeTarget.getName();
			LOGGER.error(msg, err);
			throw new ControleCaixaConverterException(msg, err);
		}
	}
	
	public static <S, T> List<T> mapper(List<S> source, Class<T> typeTarget) {
		if(ValidationUtils.isEmpty(source)) {
			throw new ControleCaixaIllegalArgumentException("List source está nulo");
		}
		return source.stream()
				.map(s -> mapper(s, typeTarget))
				.collect(Collectors.toList());
	}
	
	public static <T> T readValue(String source, Class<T> typeTarget) {
		try {			
			return OBJECT_MAPPER.readValue(source, typeTarget);
		} catch(Exception err) {
			final String msg = "Erro ao tentar converter o source = [" + source + "] para o tipo Object Target = " + typeTarget.getName();
			LOGGER.error(msg, err);
			throw new ControleCaixaConverterException(msg, err);
		}
	}
	
	public static <T> List<T> readListValue(String source, Class<T> typeTarget) {
		try {
			CollectionType listType = OBJECT_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, typeTarget);
			return OBJECT_MAPPER.readValue(source, listType);
		} catch(Exception err) {
			final String msg = "Erro ao tentar converter o source = [" + source + "] para o tipo de List Target = " + typeTarget.getName();
			LOGGER.error(msg, err);
			throw new ControleCaixaConverterException(msg, err);
		}
	}
	
	public static String writeValue(Object source) {
		try {			
			return OBJECT_MAPPER.writeValueAsString(source);
		} catch(Exception err) {
			final String msg = "Erro ao tentar converter o Object Source = " + source.getClass().getName() + " para o tipo String";
			LOGGER.error(msg, err);
			throw new ControleCaixaConverterException(msg, err);
		}
	}
	
}
