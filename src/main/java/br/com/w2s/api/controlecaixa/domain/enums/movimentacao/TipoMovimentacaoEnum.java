package br.com.w2s.api.controlecaixa.domain.enums.movimentacao;

import br.com.w2s.api.controlecaixa.domain.entity.caixa.CaixaContaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Enum utilizado para guardar os possiveis tipos de movimentacao de {@link CaixaContaEntity} </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
@Getter
@AllArgsConstructor
public enum TipoMovimentacaoEnum {
	
	CREDITO(0, "Crédito"), DEBITO(1, "Débito");
	
	private int codigo;
	private String descricao;

}
