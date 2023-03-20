package br.com.w2s.api.controlecaixa.domain.enums.caixa;

import br.com.w2s.api.controlecaixa.domain.entity.caixa.CaixaContaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Enum Utilizado para guardar os tipos de {@link CaixaContaEntity} </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
@Getter
@AllArgsConstructor
public enum TipoCaixaContaEnum {

	CAIXA("Caixa"), COFRE("Cofre"), TESOURARIA("Tesouraria"), CONTA_BANCARIA("Conta Bancária");
	
	private String descricao;
	
}
