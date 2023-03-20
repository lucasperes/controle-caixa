package br.com.w2s.api.controlecaixa.domain.model.http;

import br.com.w2s.api.controlecaixa.domain.enums.http.HttpStatusEnum;
import br.com.w2s.api.controlecaixa.domain.exception.ControleCaixaEntityNotFoundException;
import br.com.w2s.api.controlecaixa.utils.ApplicationHelper;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 * @param <T>
 */
@Getter @Setter
public class HttpResponseModel<T> {

	private int codeStatus;
	private String description;
	private String message;
	private String detail;
	private String trace;
	private T body;
	
	/**
	 * Construtor privado para evitar instanciacao externa
	 */
	private HttpResponseModel() {
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Retorna uma instancia de {@link HttpResponseModel} com status 200 Ok </p>
	 *
	 * @param <T>
	 * @param body <T>
	 * @return {@link HttpResponseDto<T>}
	 */
	public static <T> HttpResponseModel<T> hasSuccess(T body) {
		HttpResponseModel<T> response = new HttpResponseModel<>();
		response.codeStatus = HttpStatusEnum.OK.getCode();
		response.description = HttpStatusEnum.OK.getDescription();
		response.body = body;
		
		return response;
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Retorna uma instancia de {@link HttpResponseModel} com status 201 Created </p>
	 *
	 * @param <T>
	 * @param body <T>
	 * @return {@link HttpResponseDto<T>}
	 */
	public static <T> HttpResponseModel<T> hasCreated(T body) {
		HttpResponseModel<T> response = new HttpResponseModel<>();
		response.codeStatus = HttpStatusEnum.CREATED.getCode();
		response.description = HttpStatusEnum.CREATED.getDescription();
		response.body = body;
		
		return response;
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Retorna uma instancia de {@link HttpResponseModel} com status 204 No Content </p>
	 *
	 * @return {@link HttpResponseDto<T>}
	 */
	public static <T> HttpResponseModel<T> hasNoContent() {
		HttpResponseModel<T> response = new HttpResponseModel<>();
		response.codeStatus = HttpStatusEnum.NO_CONTENT.getCode();
		response.description = HttpStatusEnum.NO_CONTENT.getDescription();
		
		return response;
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Retorna uma instancia de {@link HttpResponseModel} com status 500 Internal Server Error </p>
	 *
	 * @param <T>
	 * @param err {@link Exception}
	 * @return {@link HttpResponseDto<T>}
	 */
	public static <T> HttpResponseModel<T> hasError(Exception err) {
		HttpResponseModel<T> response = new HttpResponseModel<>();
		response.codeStatus = HttpStatusEnum.INTERNAL_SERVER_ERROR.getCode();
		response.description = HttpStatusEnum.INTERNAL_SERVER_ERROR.getDescription();
		response.message = "Error 500 Internal Server Error. Houve um erro interno no servidor ao processar sua requisicao. Contact o administrador do sistema para informando a natureza do erro.";
		response.detail = err.getMessage();
		response.trace = ApplicationHelper.extractStackTrace(err);
		
		return response;
	}
	
	public static <T> HttpResponseModel<T> hasBadRequest(Exception err, T body) {
		HttpResponseModel<T> response = new HttpResponseModel<>();
		response.codeStatus = HttpStatusEnum.BAD_REQUEST.getCode();
		response.description = HttpStatusEnum.BAD_REQUEST.getDescription();
		response.message = "Error 400 Bad Request: Existem informacoes invalidas enviado pelo cliente, por favor corrigir e tentar novamente!";
		response.detail = err.getMessage();
		response.trace = ApplicationHelper.extractStackTrace(err);
		response.body = body;
		
		return response;
	}
	
	public static <T> HttpResponseModel<T> hasUnauthorized(Exception err, T body) {
		HttpResponseModel<T> response = new HttpResponseModel<>();
		response.codeStatus = HttpStatusEnum.UNAUTHORIZED.getCode();
		response.description = HttpStatusEnum.UNAUTHORIZED.getDescription();
		response.message = "Error 401 Unauthorized: Nao foi possivel validar as informaÃ§Ãµes de seguranca para autenticacao no sistema.";
		response.detail = err.getMessage();
		response.trace = ApplicationHelper.extractStackTrace(err);
		response.body = body;
		
		return response;
	}
	
	public static <T> HttpResponseModel<T> hasNotFound(ControleCaixaEntityNotFoundException err, T body) {
		HttpResponseModel<T> response = new HttpResponseModel<>();
		response.codeStatus = HttpStatusEnum.NOT_FOUND.getCode();
		response.description = HttpStatusEnum.NOT_FOUND.getDescription();
		response.message = "Error 404 Not Found: Nao foi possivel encontrar o recurso solicitado com ID = " + err.getId();
		response.detail = err.getMessage();
		response.trace = ApplicationHelper.extractStackTrace(err);
		response.body = body;
		
		return response;
	}
	
	public static <T> HttpResponseModel<T> hasServiceUnavailable(Exception err, T service) {
		HttpResponseModel<T> response = new HttpResponseModel<>();
		response.codeStatus = HttpStatusEnum.SERVICE_UNAVAILABLE.getCode();
		response.description = HttpStatusEnum.SERVICE_UNAVAILABLE.getDescription();
		response.detail = err.getMessage();
		response.trace = ApplicationHelper.extractStackTrace(err);
		response.body = service;
		
		return response;
	}
}
