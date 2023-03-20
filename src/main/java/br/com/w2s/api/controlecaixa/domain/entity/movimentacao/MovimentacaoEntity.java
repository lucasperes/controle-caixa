package br.com.w2s.api.controlecaixa.domain.entity.movimentacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.w2s.api.controlecaixa.domain.entity.AbstractEntityBase;
import br.com.w2s.api.controlecaixa.domain.entity.caixa.CaixaContaEntity;
import br.com.w2s.api.controlecaixa.domain.enums.movimentacao.TipoMovimentacaoEnum;
import br.com.w2s.api.controlecaixa.utils.java.RandomUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe Entity que mapeia a tabela: MOVIMENTACAO no banco de dados do sistema </p>
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
@Table(name = MovimentacaoEntity.NAME_TABLE)
public class MovimentacaoEntity extends AbstractEntityBase<Long> {

	// NAMES COLUMNS/TABLE DATABASE
	public static final String NAME_TABLE = "MOVIMENTACAO";
	public static final String COLUMN_CAIXA_CONTA = "CAIXA_CONTA_ID";
	public static final String COLUMN_NUMERO_TRANSACAO = "NUMERO_TRANSACAO";
	public static final String COLUMN_TIPO = "TIPO";
	public static final String COLUMN_HISTORICO = "HISTORICO";
	public static final String COLUMN_VALOR = "VALOR";
	public static final String COLUMN_DATA = "DATA";
	public static final String COLUMN_IS_CONSOLIDADO = "IS_CONSOLIDADO";
	
	@Id
	@Column(name = COLUMN_ID, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = COLUMN_CAIXA_CONTA, nullable = false)
	private CaixaContaEntity caixaConta;
	
	@NotNull
	@Column(name = COLUMN_NUMERO_TRANSACAO, length = 11, nullable = false, unique = true)
	private String numeroTransacao;
	
	@NotNull
	@Column(name = COLUMN_TIPO, length = 30, nullable = false)
	private TipoMovimentacaoEnum tipo;
	
	@NotBlank
	@Column(name = COLUMN_HISTORICO, length = 255, nullable = false)
	private String historico;
	
	@NotNull
	@Column(name = COLUMN_VALOR, precision = 20, scale = 2, nullable = false)
	private BigDecimal valor;
	
	@NotNull
	@Column(name = COLUMN_DATA, nullable = false)
	private LocalDateTime data;
	
	@NotNull
	@Column(name = COLUMN_IS_CONSOLIDADO, nullable = false)
	private Boolean isConsolidado;
	
	// PatternDesign Builder
	public static class Builder {
		@Getter
		private MovimentacaoEntity instance;
		
		public Builder() {
			instance = new MovimentacaoEntity();
		}
		
		public Builder(MovimentacaoEntity instance) {
			this.instance = instance;
		}
		
		public Builder withDefault() {
			this.instance.numeroTransacao = RandomUtils.generateRandomNumber(11);
			this.instance.valor = BigDecimal.ZERO;
			this.instance.isConsolidado = false;
			
			return this;
		}
		
		public Builder withNumeroTransacao() {
			this.instance.numeroTransacao = RandomUtils.generateRandomNumber(11);
			return this;
		}
		
		public Builder withIsConsolidado(Boolean isConsolidado) {
			this.instance.isConsolidado = isConsolidado;
			return this;
		}
		
		public Builder withHistorico(String historico) {
			this.instance.historico = historico;
			return this;
		}
		
		public Builder withDataAtual() {
			this.instance.data = LocalDateTime.now();
			return this;
		}
		
		public Builder withCaixaConta(CaixaContaEntity caixa) {
			this.instance.caixaConta = caixa;
			return this;
		}
		
		public Builder withCredito(BigDecimal valor) {
			this.instance.tipo = TipoMovimentacaoEnum.CREDITO;
			this.instance.valor = valor;			
			return this;
		}
		
		public Builder withDebito(BigDecimal valor) {
			this.instance.tipo = TipoMovimentacaoEnum.DEBITO;
			this.instance.valor = valor;			
			return this;
		}
		
		
	}
	
}
