package br.com.w2s.api.controlecaixa.resources.movimentacao;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.w2s.api.controlecaixa.domain.dto.movimentacao.MovimentacaoDTO;
import br.com.w2s.api.controlecaixa.domain.entity.movimentacao.MovimentacaoEntity;
import br.com.w2s.api.controlecaixa.domain.enums.movimentacao.TipoMovimentacaoEnum;
import br.com.w2s.api.controlecaixa.domain.model.http.HttpResponseModel;
import br.com.w2s.api.controlecaixa.facade.movimentacao.MovimentacaoFacade;
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
 * @description <p> Classe API Rest para servicos relacionados a {@link MovimentacaoEntity} </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
@RestController
@RequestMapping("/movimentacoes")
public class MovimentacoesResource extends AbstractResourceApiBase {
	
	@Autowired
	private MovimentacaoFacade facade;
	
	@GetMapping
	@Operation(operationId = "listAll", tags = "Caixas/Contas", summary = "Listar Caixas/Contas", description = "Lista todos os Caixas/Contas filtrados e paginados")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Ok"),
		@ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema(implementation = Void.class))),
		@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = HttpResponseModel.class))),
		@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = HttpResponseModel.class)))
	})
	public ResponseEntity<HttpResponseModel<Page<MovimentacaoDTO>>> list(
			@RequestParam(value = "caixaContaId", required = false) Integer caixaContaId,
			@RequestParam(value = "numeroTransacao", required = false) String numeroTransacao,
			@RequestParam(value = "tipo", required = false) TipoMovimentacaoEnum tipo,
			@RequestParam(value = "historico", required = false) String historico,
			@RequestParam(value = "isConsolidado", required = false) Boolean isConsolidado,
			Pageable pageable) {
		return executeAction(() -> facade.list(caixaContaId, numeroTransacao, tipo, historico, isConsolidado, pageable));
	}
	
	@GetMapping("/{id}")
	@Operation(operationId = "findById", tags = "Caixas/Contas", summary = "Buscar Caixa/Conta", description = "Busca um Caixa/Conta pelo seu ID")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Ok"),
		@ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema(implementation = Void.class))),
		@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = HttpResponseModel.class))),
		@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = HttpResponseModel.class)))
	})
	public ResponseEntity<HttpResponseModel<MovimentacaoDTO>> find(@PathVariable("id") Long id) {
		return executeAction(() -> facade.findById(id));
	}
	
	@PostMapping
	@Operation(operationId = "save", tags = "Caixas/Contas", summary = "Salvar Caixa/Conta", description = "Persiste ou Atualiza um Caixa/Conta")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Ok"),
		@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = HttpResponseModel.class))),
		@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = HttpResponseModel.class)))
	})
	public ResponseEntity<HttpResponseModel<MovimentacaoDTO>> save(@RequestBody @Valid MovimentacaoDTO dto) {
		return executeAction(() -> facade.save(dto));
	}

	@PostMapping("/consolidate")
	@Operation(operationId = "consolidate", tags = "Caixas/Contas", summary = "Fechar Caixa/Conta", description = "Fecha um Caixa/Conta pelo seu ID")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema(implementation = Void.class))),
		@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = HttpResponseModel.class))),
		@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = HttpResponseModel.class)))
	})
	public ResponseEntity<HttpResponseModel<Void>> consolidate(@RequestBody @NotEmpty List<MovimentacaoDTO> dtos) {
		return executeAction(() -> facade.consolidate(dtos));
	}

}
