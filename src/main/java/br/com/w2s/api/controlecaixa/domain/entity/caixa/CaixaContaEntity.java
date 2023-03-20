package br.com.w2s.api.controlecaixa.domain.entity.caixa;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.w2s.api.controlecaixa.domain.annotations.NotCopyAttr;
import br.com.w2s.api.controlecaixa.domain.entity.AbstractEntityBase;
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
 * @description <p> Classe Entity que mapeia a tabela: CAIXA_CONTA no banco de dados do sistema </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = CaixaContaEntity.NAME_TABLE)
public class CaixaContaEntity extends AbstractEntityBase<Integer> {

	// NAMES COLUMNS/TABLE DATABASE
	public static final String NAME_TABLE = "CAIXA_CONTA";
	public static final String COLUMN_NOME = "NOME";
	public static final String COLUMN_TIPO = "TIPO";
	public static final String COLUMN_STATUS = "STATUS";
	public static final String COLUMN_VALOR_SALDO = "VALOR_SALDO";
	public static final String COLUMN_VALOR_SALDO_CONSOLIDADO = "VALOR_SALDO_CONSOLIDADO";
	
	@Id
	@Column(name = COLUMN_ID, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Column(name = COLUMN_NOME, length = 60, nullable = false)
	private String nome;
	
	@NotNull
	@Column(name = COLUMN_TIPO, length = 30, nullable = false)
	private TipoCaixaContaEnum tipo;
	
	@NotNull
	@NotCopyAttr
	@Column(name = COLUMN_STATUS, length = 30, nullable = false)
	private StatusCaixaContaEnum status;
	
	@Embedded
	private ContaBancariaEntity contaBancaria;
	
	@NotNull
	@NotCopyAttr
	@Column(name = COLUMN_VALOR_SALDO, precision = 20, scale = 2, nullable = false)
	private BigDecimal valorSaldo;
	
	@NotNull
	@NotCopyAttr
	@Column(name = COLUMN_VALOR_SALDO_CONSOLIDADO, precision = 20, scale = 2, nullable = false)
	private BigDecimal valorSaldoConsolidado;
	
	// PatterDesign Builder
	public static class Builder {
		@Getter
		private CaixaContaEntity instance;
		
		public Builder() {
			instance = new CaixaContaEntity();
		}
		
		public Builder(CaixaContaEntity instance) {
			this.instance = instance;
		}
		
		public Builder withDefault() {
			this.instance.valorSaldo = BigDecimal.ZERO;
			this.instance.valorSaldoConsolidado = BigDecimal.ZERO;
			this.instance.status = StatusCaixaContaEnum.ABERTO;
			return this;
		}
		
		public Builder withTipo(TipoCaixaContaEnum tipo) {
			this.instance.tipo = tipo;
			return this;
		}
		
		public Builder withTipo(ContaBancariaEntity contaBancaria) {
			this.instance.contaBancaria = contaBancaria;
			return this;
		}
		
	}
	
}
