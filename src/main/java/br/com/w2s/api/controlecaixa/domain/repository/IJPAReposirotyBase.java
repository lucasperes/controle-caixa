package br.com.w2s.api.controlecaixa.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Interface Repository Base para ser herdada por todas as classes e interfaces repositories do sistema </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 * @param <T> Tipo
 * @param <ID> Chave Primaria
 */
@NoRepositoryBean
public interface IJPAReposirotyBase<T, ID> extends JpaRepository<T, ID> {

}
