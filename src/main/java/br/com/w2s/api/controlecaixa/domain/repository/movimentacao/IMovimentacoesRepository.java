package br.com.w2s.api.controlecaixa.domain.repository.movimentacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.w2s.api.controlecaixa.domain.entity.AbstractEntityBase;
import br.com.w2s.api.controlecaixa.domain.entity.movimentacao.MovimentacaoEntity;
import br.com.w2s.api.controlecaixa.domain.enums.movimentacao.TipoMovimentacaoEnum;
import br.com.w2s.api.controlecaixa.domain.repository.IJPAReposirotyBase;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Interface Repository para {@link MovimentacaoEntity} </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
public interface IMovimentacoesRepository extends IJPAReposirotyBase<MovimentacaoEntity, Long> {

static final String NAMED_QUERY_LIST = "MovimentacaoEntity.list";
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Lista os {@link MovimentacaoEntity} filtardos e paginados do banco de dados do sistema </p>
	 *
	 * @param caixaContaId {@link Integer}
	 * @param numeroTransacao {@link String}
	 * @param tipo {@link TipoMovimentacaoEnum}
	 * @param historico {@link String}
	 * @param isConsolidado {@link Boolean}
	 * @param pageable {@link Pageable}
	 * @return {@link Page} de {@link MovimentacaoEntity}
	 */
	@Query(name = NAMED_QUERY_LIST, countProjection = AbstractEntityBase.COLUMN_COUNT_PAGE_SQL)
	Page<MovimentacaoEntity> list(
			@Param("caixaContaId") Integer caixaContaId,
			@Param("numeroTransacao") String numeroTransacao,
			@Param("tipo") TipoMovimentacaoEnum tipo,
			@Param("historico") String historico,
			@Param("isConsolidado") Boolean isConsolidado,
			Pageable pageable);
	
}
