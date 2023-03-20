package br.com.w2s.api.controlecaixa.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import br.com.w2s.api.controlecaixa.domain.model.http.HttpResponseModel;
import br.com.w2s.api.controlecaixa.service.IExecuteService;
import br.com.w2s.api.controlecaixa.utils.java.ValidationUtils;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe Abstract para ser extendida pelas classes Resources API REST do sistema </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
@Controller
public abstract class AbstractResourceApiBase {
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractResourceApiBase.class);
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Executa uma acao e retorna uma instancia de {@link ResponseEntity} do tipo {@link HttpResponseDTO} </p>
	 *
	 * @param <T>
	 * @param service {@link IExecuteService}
	 * @return {@link ResponseEntity} de {@link HttpResponseDTO}
	 */
	protected <T> ResponseEntity<HttpResponseModel<T>> executeAction(IExecuteService<T> service) {
		try {
			T result = service.execute();
			if(ValidationUtils.isEmpty(result)) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(HttpResponseModel.hasNoContent());
			} else {
				return ResponseEntity.ok(HttpResponseModel.hasSuccess(result));
			}
		} catch(Exception err) {
			LOGGER.error("Error on execute action: " + service.getClass().getClassLoader().getName(), err);
			throw err;
		}
	}

}
