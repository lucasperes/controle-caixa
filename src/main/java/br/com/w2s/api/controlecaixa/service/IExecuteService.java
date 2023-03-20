package br.com.w2s.api.controlecaixa.service;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Interface Funcional para executar acoes dos services na camada de resources </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 * @param <T> Tipo de Retorno
 */
@FunctionalInterface
public interface IExecuteService<T> {
	
	T execute();

}
