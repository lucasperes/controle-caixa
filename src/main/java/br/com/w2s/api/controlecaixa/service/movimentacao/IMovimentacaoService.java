package br.com.w2s.api.controlecaixa.service.movimentacao;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.w2s.api.controlecaixa.domain.dto.movimentacao.filter.MovimentacoesFilterDTO;
import br.com.w2s.api.controlecaixa.domain.entity.movimentacao.MovimentacaoEntity;
import br.com.w2s.api.controlecaixa.service.IServiceBase;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Interface Service para {@link MovimentacaoEntity} </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
public interface IMovimentacaoService extends IServiceBase {

	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Lista as {@link MovimentacaoEntity} filtrados e paginados </p>
	 *
	 * @param filter {@link MovimentacoesFilterDTO}
	 * @return {@link Page} de {@link MovimentacaoEntity}
	 */
	Page<MovimentacaoEntity> list(MovimentacoesFilterDTO filter);
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Busca uma {@link MovimentacaoEntity} pelo seu ID </p>
	 *
	 * @param id {@link Long}
	 * @return {@link MovimentacaoEntity}
	 */
	MovimentacaoEntity findById(Long id);
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Persite uma Atualiza um {@link MovimentacaoEntity} </p>
	 *
	 * @param entity {@link MovimentacaoEntity}
	 * @return {@link MovimentacaoEntity}
	 */
	MovimentacaoEntity save(MovimentacaoEntity entity);
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Consolida as {@link MovimentacaoEntity} </p>
	 *
	 * @param entities {@link List} de {@link MovimentacaoEntity}
	 * @return {@link Void} null
	 */
	Void consolidate(List<MovimentacaoEntity> entities);
	
}
