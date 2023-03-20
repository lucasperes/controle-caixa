package br.com.w2s.api.controlecaixa.domain.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.w2s.api.controlecaixa.domain.exception.ControleCaixaCoreBaseException;
import br.com.w2s.api.controlecaixa.domain.exception.ControleCaixaEntityNotFoundException;
import br.com.w2s.api.controlecaixa.domain.model.http.HttpResponseModel;
import br.com.w2s.api.controlecaixa.domain.model.http.error.ErrorBadRequestDTO;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe de Handler Exception Global </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ControleCaixaGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ControleCaixaGlobalExceptionHandler.class);
	
	@ExceptionHandler({RuntimeException.class, Exception.class})
	public ResponseEntity<HttpResponseModel<?>> handlerDefaultError(Exception err, WebRequest request) {
		LOGGER.error("Error 500 Internal Server Error. Houve um erro interno no servidor ao processar sua requisição!", err);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(HttpResponseModel.hasError(err));
	}
	
	@ExceptionHandler({ControleCaixaCoreBaseException.class})
	public ResponseEntity<HttpResponseModel<?>> handlerSmartParkCoreError(ControleCaixaCoreBaseException err, WebRequest request) {
		LOGGER.error("Error 400 BadRequest: Existem informacoes invalidas enviado pelo cliente, por favor corrigir e tentar novamente!", err);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(HttpResponseModel.hasBadRequest(err, null));
	}
	
	@ExceptionHandler({ControleCaixaEntityNotFoundException.class})
	public ResponseEntity<HttpResponseModel<?>> handlerSmartParkEntityNotFoundError(ControleCaixaEntityNotFoundException err, WebRequest request) {
		LOGGER.error("Error 404 Not Found: Não foi possível encontrar o recurso solicitado com ID = " + err.getId(), err);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpResponseModel.hasNotFound(err, null));
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException err,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		loggerError400(err);
		ErrorBadRequestDTO errorDto = new ErrorBadRequestDTO.Builder()
				.codeDescriptionDefault()
				.fieldsErrors(err.getFieldErrors())
				.getInstance();
		return handleExceptionInternal(err, HttpResponseModel.hasBadRequest(err, errorDto), headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException err,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		loggerError400(err);
		ErrorBadRequestDTO errorDto = new ErrorBadRequestDTO.Builder()
				.codeDescriptionDefault()
				.requestParamError(err.getParameterName(), err.getMessage())
				.getInstance();
		return handleExceptionInternal(err, HttpResponseModel.hasBadRequest(err, errorDto), headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException err,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		loggerError400(err);
		ErrorBadRequestDTO errorDto = new ErrorBadRequestDTO.Builder()
				.codeDescriptionDefault()
				.requestParamError("mensagem HTTP não legível", err.getMessage())
				.getInstance();
		return handleExceptionInternal(err, HttpResponseModel.hasBadRequest(err, errorDto), headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException err, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		loggerError400(err);
		ErrorBadRequestDTO errorDto = new ErrorBadRequestDTO.Builder()
				.codeDescriptionDefault()
				.requestParamError(err.getPropertyName(), err.getMessage())
				.getInstance();
		return handleExceptionInternal(err, HttpResponseModel.hasBadRequest(err, errorDto), headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException err,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		loggerError400(err);
		ErrorBadRequestDTO errorDto = new ErrorBadRequestDTO.Builder()
				.codeDescriptionDefault()
				.requestParamError(err.getRequestPartName(), err.getMessage())
				.getInstance();
		return handleExceptionInternal(err, HttpResponseModel.hasBadRequest(err, errorDto), headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException err,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		loggerError400(err);
		ErrorBadRequestDTO errorDto = new ErrorBadRequestDTO.Builder()
				.codeDescriptionDefault()
				.requestParamError("No converter", err.getMessage())
				.getInstance();
		return handleExceptionInternal(err, HttpResponseModel.hasBadRequest(err, errorDto), headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException err,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		loggerError400(err);
		ErrorBadRequestDTO errorDto = new ErrorBadRequestDTO.Builder()
				.codeDescriptionDefault()
				.requestParamError("Method Not Supported", err.getMessage())
				.getInstance();
		return handleExceptionInternal(err, HttpResponseModel.hasBadRequest(err, errorDto), headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException err,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		loggerError400(err);
		ErrorBadRequestDTO errorDto = new ErrorBadRequestDTO.Builder()
				.codeDescriptionDefault()
				.requestParamError("Http Media Type Not Supported = " + err.getContentType(), err.getMessage())
				.getInstance();
		return handleExceptionInternal(err, HttpResponseModel.hasBadRequest(err, errorDto), headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException err,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		loggerError400(err);
		ErrorBadRequestDTO errorDto = new ErrorBadRequestDTO.Builder()
				.codeDescriptionDefault()
				.requestParamError("Servlet Request Binding Exception", err.getMessage())
				.getInstance();
		return handleExceptionInternal(err, HttpResponseModel.hasBadRequest(err, errorDto), headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException err,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		loggerError400(err);
		ErrorBadRequestDTO errorDto = new ErrorBadRequestDTO.Builder()
				.codeDescriptionDefault()
				.requestParamError("Http Media Type Not Acceptable", err.getMessage())
				.getInstance();
		return handleExceptionInternal(err, HttpResponseModel.hasBadRequest(err, errorDto), headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleBindException(BindException err, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		loggerError400(err);
		ErrorBadRequestDTO errorDto = new ErrorBadRequestDTO.Builder()
				.codeDescriptionDefault()
				.fieldsErrors(err.getFieldErrors())
				.getInstance();
		return handleExceptionInternal(err, HttpResponseModel.hasBadRequest(err, errorDto), headers, status, request);
	}
	
	private void loggerError400(Exception err) {
		LOGGER.error("Error 400 BadRequest: Existem informacoes invalidas enviado pelo cliente, por favor corrigir e tentar novamente!", err);
	}
	
}
