package br.com.w2s.api.controlecaixa.facade.caixa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.w2s.api.controlecaixa.domain.dto.caixa.CaixaContaDTO;
import br.com.w2s.api.controlecaixa.domain.dto.caixa.filter.CaixasContasFilterDTO;
import br.com.w2s.api.controlecaixa.domain.entity.caixa.CaixaContaEntity;
import br.com.w2s.api.controlecaixa.domain.enums.caixa.StatusCaixaContaEnum;
import br.com.w2s.api.controlecaixa.domain.enums.caixa.TipoCaixaContaEnum;
import br.com.w2s.api.controlecaixa.facade.AbstractFacadeBase;
import br.com.w2s.api.controlecaixa.service.caixa.ICaixaContaService;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe Facade para {@link CaixaContaEntity} </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
@Component
public class CaixaContaFacade extends AbstractFacadeBase {
	
	private static final long serialVersionUID = 8923020110615016157L;
	
	@Autowired
	private ICaixaContaService service;
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Lista os {@link CaixaContaEntity} filtrados e paginados </p>
	 *
	 * @param nome {@link String}
	 * @param tipo {@link TipoCaixaContaEnum}
	 * @param status {@link StatusCaixaContaEnum}
	 * @param pageable {@link Pageable}
	 * @return {@link Page} de {@link CaixaContaDTO}
	 */
	public Page<CaixaContaDTO> list(String nome, TipoCaixaContaEnum tipo, StatusCaixaContaEnum status, Pageable pageable) {
		CaixasContasFilterDTO filter = new CaixasContasFilterDTO(nome, tipo, status, pageable);
		return mapperSafeNull(service.list(filter), CaixaContaDTO.class);
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Busca um {@link CaixaContaEntity} pelo seu ID </p>
	 *
	 * @param id {@link Integer}
	 * @return {@link CaixaContaDTO}
	 */
	public CaixaContaDTO findById(Integer id) {
		return mapperSafeNull(service.findById(id), CaixaContaDTO.class);
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Persite ou Atualiza um {@link CaixaContaEntity} </p>
	 *
	 * @param dto {@link CaixaContaDTO}
	 * @return {@link CaixaContaDTO}
	 */
	public CaixaContaDTO save(CaixaContaDTO dto) {
		CaixaContaEntity entity = mapper(dto, CaixaContaEntity.class);
		return mapperSafeNull(service.save(entity), CaixaContaDTO.class);
	}
	
	/**
	 * @author Lucas P. Soares
	 * @contact lucas.lps@ecxus.com.br
	 * @date 20 de mar. de 2023
	 * @version 1.0.0
	 * @description <p> Fecha um {@link CaixaContaEntity} </p>
	 *
	 * @param id {@link Integer}
	 * @return {@link Void} null
	 */
	public Void close(Integer id) {
		return service.close(id);
	}
	
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
	public Void delete(Integer id) {
		return service.delete(id);
	}

}
