package br.com.w2s.api.controlecaixa.service.caixa;

import org.springframework.data.domain.Page;

import br.com.w2s.api.controlecaixa.domain.dto.caixa.filter.CaixasContasFilterDTO;
import br.com.w2s.api.controlecaixa.domain.entity.caixa.CaixaContaEntity;
import br.com.w2s.api.controlecaixa.service.IServiceBase;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Interface Service para {@link CaixaContaEntity} </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
public interface ICaixaContaService extends IServiceBase {

	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Lista os {@link CaixaContaEntity} filtrados e paginados </p>
	 *
	 * @param filter {@link CaixasContasFilterDTO}
	 * @return {@link Page} de {@link CaixaContaEntity}
	 */
	Page<CaixaContaEntity> list(CaixasContasFilterDTO filter);
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Busca um {@link CaixaContaEntity} pelo seu ID </p>
	 *
	 * @param id {@link Integer}
	 * @return {@link CaixaContaEntity}
	 */
	CaixaContaEntity findById(Integer id);
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Persite ou Atualiza um {@link CaixaContaEntity} </p>
	 *
	 * @param entity {@link CaixaContaEntity}
	 * @return {@link CaixaContaEntity}
	 */
	CaixaContaEntity save(CaixaContaEntity entity);
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Fecha um {@link CaixaContaEntity} pelo seu ID </p>
	 *
	 * @param id {@link Integer}
	 * @return {@link Void} null
	 */
	Void close(Integer id);
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Encerra um {@link CaixaContaEntity} </p>
	 *
	 * @param id {@link Integer}
	 * @return {@link Void} null
	 */
	Void delete(Integer id);
	
}
