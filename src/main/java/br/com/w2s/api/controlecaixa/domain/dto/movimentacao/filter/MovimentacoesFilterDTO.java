package br.com.w2s.api.controlecaixa.domain.dto.movimentacao.filter;

import org.springframework.data.domain.Pageable;

import br.com.w2s.api.controlecaixa.domain.dto.filter.FilterSQLBaseDTO;
import br.com.w2s.api.controlecaixa.domain.entity.movimentacao.MovimentacaoEntity;
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
 * @description <p> Classe Filter SQL DTO para {@link MovimentacaoEntity} </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovimentacoesFilterDTO extends FilterSQLBaseDTO {

	/**
	 * @param caixaContaId {@link Integer}
	 * @param numeroTransacao {@link String}
	 * @param tipo {@link TipoMovimentacaoEnum}
	 * @param historico {@link String}
	 * @param isConsolidado {@link Boolean}
	 * @param pageable {@link Pageable}
	 */
	public MovimentacoesFilterDTO(Integer caixaContaId, String numeroTransacao, TipoMovimentacaoEnum tipo,
			String historico, Boolean isConsolidado, Pageable pageable) {
		this.caixaContaId = caixaContaId;
		this.numeroTransacao = numeroTransacao;
		this.tipo = tipo;
		this.historico = historico;
		this.isConsolidado = isConsolidado;
		super.setPageable(pageable);
	}
	
	private Integer caixaContaId;
	private String numeroTransacao;
	private TipoMovimentacaoEnum tipo;
	private String historico;
	private Boolean isConsolidado;
	
}
