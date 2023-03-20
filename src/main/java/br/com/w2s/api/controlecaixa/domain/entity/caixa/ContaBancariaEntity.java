package br.com.w2s.api.controlecaixa.domain.entity.caixa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe Model para representar uma conta bancaria </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
@Embeddable
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaBancariaEntity implements Serializable {

	private static final long serialVersionUID = 2666072309337898157L;
	
	// NAMES COLUMNS/TABLE DATABASE
	public static final String COLUMN_CODIGO = "BANCO_CODIGO";
	public static final String COLUMN_BANCO = "BANCO_NOME";
	public static final String COLUMN_AGENCIA = "BANCO_AGENCIA";
	public static final String COLUMN_AGENCIA_DV = "BANCO_AGENCIA_DV";
	public static final String COLUMN_CONTA = "BANCO_CONTA";
	public static final String COLUMN_CONTA_DV = "BANCO_CONTA_DV";
	public static final String COLUMN_RESPONSAVEL_NOME = "RESPONSAVEL_NOME";
	public static final String COLUMN_RESPONSAVEL_DOCUMENTO = "RESPONSAVEL_DOCUMENTO";
	
	@Column(name = COLUMN_CODIGO, length = 3)
	private String codigo;
	
	@Column(name = COLUMN_BANCO, length = 60)
	private String banco;
	
	@Column(name = COLUMN_AGENCIA, length = 11)
	private String agencia;
	
	@Column(name = COLUMN_AGENCIA_DV, length = 1)
	private String agenciaDV;
	
	@Column(name = COLUMN_CONTA, length = 20)
	private String conta;
	
	@Column(name = COLUMN_CONTA_DV, length = 1)
	private String contaDV;
	
	@Column(name = COLUMN_RESPONSAVEL_NOME, length = 60)
	private String responsavelNome;
	
	@Column(name = COLUMN_RESPONSAVEL_DOCUMENTO, length = 30)
	private String responsavelDocumento;
	
}
