package br.com.w2s.api.controlecaixa.resources.caixa;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.w2s.api.controlecaixa.domain.dto.caixa.CaixaContaDTO;
import br.com.w2s.api.controlecaixa.domain.entity.caixa.CaixaContaEntity;
import br.com.w2s.api.controlecaixa.domain.enums.caixa.StatusCaixaContaEnum;
import br.com.w2s.api.controlecaixa.domain.enums.caixa.TipoCaixaContaEnum;
import br.com.w2s.api.controlecaixa.domain.model.http.HttpResponseModel;
import br.com.w2s.api.controlecaixa.facade.caixa.CaixaContaFacade;
import br.com.w2s.api.controlecaixa.resources.AbstractResourceApiBase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe API Rest para servicos relacionados a {@link CaixaContaEntity} </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
@RestController
@RequestMapping("/caixas-contas")
public class CaixasContasResource extends AbstractResourceApiBase {
	
	@Autowired
	private CaixaContaFacade facade;
	
	@GetMapping
	@Operation(operationId = "listAll", tags = "Caixas/Contas", summary = "Listar Caixas/Contas", description = "Lista todos os Caixas/Contas filtrados e paginados")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Ok"),
		@ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema(implementation = Void.class))),
		@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = HttpResponseModel.class))),
		@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = HttpResponseModel.class)))
	})
	public ResponseEntity<HttpResponseModel<Page<CaixaContaDTO>>> list(
			@RequestParam(value = "nome", required = false) String nome,
			@RequestParam(value = "tipo", required = false) TipoCaixaContaEnum tipo,
			@RequestParam(value = "status", required = false) StatusCaixaContaEnum status,
			Pageable pageable) {
		return executeAction(() -> facade.list(nome, tipo, status, pageable));
	}
	
	@GetMapping("/{id}")
	@Operation(operationId = "findById", tags = "Caixas/Contas", summary = "Buscar Caixa/Conta", description = "Busca um Caixa/Conta pelo seu ID")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Ok"),
		@ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema(implementation = Void.class))),
		@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = HttpResponseModel.class))),
		@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = HttpResponseModel.class)))
	})
	public ResponseEntity<HttpResponseModel<CaixaContaDTO>> find(@PathVariable("id") Integer id) {
		return executeAction(() -> facade.findById(id));
	}
	
	@PostMapping
	@Operation(operationId = "save", tags = "Caixas/Contas", summary = "Salvar Caixa/Conta", description = "Persiste ou Atualiza um Caixa/Conta")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Ok"),
		@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = HttpResponseModel.class))),
		@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = HttpResponseModel.class)))
	})
	public ResponseEntity<HttpResponseModel<CaixaContaDTO>> save(@RequestBody @Valid CaixaContaDTO dto) {
		return executeAction(() -> facade.save(dto));
	}

	@PatchMapping("/{id}/close")
	@Operation(operationId = "close", tags = "Caixas/Contas", summary = "Fechar Caixa/Conta", description = "Fecha um Caixa/Conta pelo seu ID")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema(implementation = Void.class))),
		@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = HttpResponseModel.class))),
		@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = HttpResponseModel.class)))
	})
	public ResponseEntity<HttpResponseModel<Void>> close(@PathVariable("id") Integer id) {
		return executeAction(() -> facade.close(id));
	}
	
	@DeleteMapping("/{id}")
	@Operation(operationId = "delete", tags = "Caixas/Contas", summary = "Encerrar Caixa/Conta", description = "Encerra um Caixa/Conta pelo seu ID")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema(implementation = Void.class))),
		@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = HttpResponseModel.class))),
		@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = HttpResponseModel.class)))
	})
	public ResponseEntity<HttpResponseModel<Void>> delete(@PathVariable("id") Integer id) {
		return executeAction(() -> facade.delete(id));
	}

}
