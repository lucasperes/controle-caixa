package br.com.w2s.api.controlecaixa.domain.model.http.error;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;

import br.com.w2s.api.controlecaixa.utils.java.ValidationUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 25 de mai. de 2022
 * @version 1.0.0
 * @description <p> Classe Error DTO que mapeia os retornos de erros 400 HTTP </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorBadRequestDTO implements Serializable {

	private static final long serialVersionUID = -3677124903105150717L;

	private int code;
	private String description;
	private List<FieldErrorDto> fields;
	
	public void addFieldError(FieldError field) {
		addFieldError(field.getField(), field.getDefaultMessage());
	}
	
	public void addFieldError(String name, String message) {
		if(ValidationUtils.isNull(fields)) {
			fields = new ArrayList<>();
		}
		FieldErrorDto dto = new FieldErrorDto(name, message);
		fields.add(dto);
	}
	
	@Getter @Setter
	@NoArgsConstructor
	@AllArgsConstructor
	static class FieldErrorDto {
		private String name;
		private String message;
	}
	
	public static class Builder {
		@Getter
		private ErrorBadRequestDTO instance;
		
		public Builder() {
			this.instance = new ErrorBadRequestDTO();
		}
		
		public Builder(ErrorBadRequestDTO instance) {
			this.instance = instance;
		}
		
		public Builder codeDescriptionDefault() {
			this.instance.code = 400;
			this.instance.description = "Existem informações inválidas enviado pelo cliente na requisição, por favor corrigir e tentar novamente!";
			return this;
		}
		
		public Builder fieldError(FieldError field) {
			this.instance.addFieldError(field);
			return this;
		}
		
		public Builder fieldsErrors(List<FieldError> fields) {
			for(FieldError field : fields) {
				this.fieldError(field);
			}
			return this;
		}
		
		public Builder requestParamError(String name, String message) {
			this.instance.addFieldError(name, message);
			return this;
		}
		
	}
	
}
