package br.com.w2s.api.controlecaixa.domain.dto.caixa.filter;

import org.springframework.data.domain.Pageable;

import br.com.w2s.api.controlecaixa.domain.dto.filter.FilterSQLBaseDTO;
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
 * @description <p> Classe Filter SQL DTO para {@link CaixaContaEntity} </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CaixasContasFilterDTO extends FilterSQLBaseDTO {

	/**
	 * @param nome {@link String}
	 * @param tipo {@link TipoCaixaContaEnum}
	 * @param status {@link StatusCaixaContaEnum}
	 * @param pageable {@link Pageable}
	 */
	public CaixasContasFilterDTO(String nome, TipoCaixaContaEnum tipo, StatusCaixaContaEnum status, Pageable pageable) {
		this.nome = nome;
		this.tipo = tipo;
		this.status = status;
		super.setPageable(pageable);
	}
	
	private String nome;
	private TipoCaixaContaEnum tipo;
	private StatusCaixaContaEnum status;
	
}
