package br.com.w2s.api.controlecaixa.domain.dto.caixa;

import java.math.BigDecimal;

import javax.persistence.Embedded;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.com.w2s.api.controlecaixa.domain.dto.AbstractDTOBase;
import br.com.w2s.api.controlecaixa.domain.entity.caixa.CaixaContaEntity;
import br.com.w2s.api.controlecaixa.domain.enums.caixa.StatusCaixaContaEnum;
import br.com.w2s.api.controlecaixa.domain.enums.caixa.TipoCaixaContaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe DTO ModelMapper para {@link CaixaContaEntity} </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CaixaContaDTO extends AbstractDTOBase {

	private Integer id;
	
	@NotBlank
	private String nome;
	
	@NotNull
	private TipoCaixaContaEnum tipo;
	
	@JsonProperty(access = Access.READ_ONLY)
	private StatusCaixaContaEnum status;
	
	@Embedded
	private ContaBancariaDTO contaBancaria;
	
	@JsonProperty(access = Access.READ_ONLY)
	private BigDecimal valorSaldo;
	
}
