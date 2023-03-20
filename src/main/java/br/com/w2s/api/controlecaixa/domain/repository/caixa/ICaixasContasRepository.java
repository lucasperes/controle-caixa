package br.com.w2s.api.controlecaixa.domain.repository.caixa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.w2s.api.controlecaixa.domain.entity.AbstractEntityBase;
import br.com.w2s.api.controlecaixa.domain.entity.caixa.CaixaContaEntity;
import br.com.w2s.api.controlecaixa.domain.enums.caixa.StatusCaixaContaEnum;
import br.com.w2s.api.controlecaixa.domain.enums.caixa.TipoCaixaContaEnum;
import br.com.w2s.api.controlecaixa.domain.repository.IJPAReposirotyBase;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Interface Repository para {@link CaixaContaEntity} </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
public interface ICaixasContasRepository extends IJPAReposirotyBase<CaixaContaEntity, Integer> {

	static final String NAMED_QUERY_LIST = "CaixaContaEntity.list";
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Lista os {@link CaixaContaEntity} filtardos e paginados do banco de dados do sistema </p>
	 *
	 * @param nome {@link String}
	 * @param tipo {@link TipoCaixaContaEnum}
	 * @param status {@link StatusCaixaContaEnum}
	 * @param pageable {@link Pageable}
	 * @return {@link Page} de {@link CaixaContaEntity}
	 */
	@Query(name = NAMED_QUERY_LIST, countProjection = AbstractEntityBase.COLUMN_COUNT_PAGE_SQL)
	Page<CaixaContaEntity> list(
			@Param("nome") String nome,
			@Param("tipo") TipoCaixaContaEnum tipo,
			@Param("status") StatusCaixaContaEnum status,
			Pageable pageable);
	
}
