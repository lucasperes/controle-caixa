package br.com.w2s.api.controlecaixa.domain.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Lucas P. Soares
 * @contact lucas.lps@ecxus.com.br
 * @date 20 de mar. de 2023
 * @version 1.0.0
 * @description <p> Classe Entity Base para ser herdada por todas classes JPA </p>
 *
 * @revisions_history
 * - Version   -   Author    -    Description
 *  1.0.0       Lucas Peres   Criação da classe
 *
 * @param <ID>
 */
public abstract class AbstractEntityBase<ID extends Serializable> {

	// NAMES COLUMNS TABLE DATABASE
	public static final String COLUMN_ID = "ID";
	// NAME COLUMN COUNT LIST
	public static final String COLUMN_COUNT_PAGE_SQL = "e.id";
	// NAMES ATTRS
	public static final String ATTR_ID = "id";

	public abstract ID getId();

	public abstract void setId(ID id);

	// OVERRIDES

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntityBase<?> other = (AbstractEntityBase<?>) obj;
		return Objects.equals(getId(), other.getId());
	}

}
