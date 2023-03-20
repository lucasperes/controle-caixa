package br.com.w2s.api.controlecaixa.domain.dto.caixa;

import br.com.w2s.api.controlecaixa.domain.dto.AbstractDTOBase;
import br.com.w2s.api.controlecaixa.domain.entity.caixa.ContaBancariaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe DTO ModelMapper para {@link ContaBancariaEntity} </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaBancariaDTO extends AbstractDTOBase {

	private String codigo;
	private String banco;
	private String agencia;
	private String agenciaDV;
	private String conta;
	private String contaDV;
	private String responsavelNome;
	private String responsavelDocumento;
	
}
