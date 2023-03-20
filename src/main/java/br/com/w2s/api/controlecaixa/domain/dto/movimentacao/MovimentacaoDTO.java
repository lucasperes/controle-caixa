package br.com.w2s.api.controlecaixa.domain.dto.movimentacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.com.w2s.api.controlecaixa.domain.dto.AbstractDTOBase;
import br.com.w2s.api.controlecaixa.domain.entity.movimentacao.MovimentacaoEntity;
import br.com.w2s.api.controlecaixa.domain.enums.caixa.TipoCaixaContaEnum;
import br.com.w2s.api.controlecaixa.domain.enums.movimentacao.TipoMovimentacaoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe ModelMapper para {@link MovimentacaoEntity} </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovimentacaoDTO extends AbstractDTOBase {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	
	@NotNull
	private Integer caixaContaId;
	@JsonProperty(access = Access.READ_ONLY)
	private String caixaContaNome;
	@JsonProperty(access = Access.READ_ONLY)
	private TipoCaixaContaEnum caixaContaTipo;
	@JsonProperty(access = Access.READ_ONLY)
	private BigDecimal caixaContaValorSaldo;
	
	@JsonProperty(access = Access.READ_ONLY)
	private String numeroTransacao;
	
	@NotNull
	private TipoMovimentacaoEnum tipo;
	@NotBlank
	private String historico;
	@NotNull
	private BigDecimal valor;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime data;
	
	@JsonProperty(access = Access.READ_ONLY)
	private Boolean isConsolidado;
	
}
