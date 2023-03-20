package br.com.w2s.api.controlecaixa.domain.enums.http;

import lombok.Getter;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Enum utilizada para guardar os Status HTTP </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
@Getter
public enum HttpStatusEnum {

	OK(200, "Ok"), CREATED(201, "Created"), NO_CONTENT(204, "No Content"),
	BAD_REQUEST(400, "Bad Request"), UNAUTHORIZED(401, "Unauthorized"), FORBIDDEN(403, "Forbidden"),
	NOT_FOUND(404, "Not Found"), NOT_ACCEPTABLE(406, "Not Acceptable"), UNPROCCESSABLE_ENTITY(422, "Unproccessable Entity"),
	INTERNAL_SERVER_ERROR(500, "Internal Server Error"), NOT_IMPLEMENTED(501, "Not Implemented"), SERVICE_UNAVAILABLE(503, "Service Unavailable");
	
	private int code;
	private String description;
	
	private HttpStatusEnum(int code, String description) {
		this.code = code;
		this.description = description; 
	}
	
}
