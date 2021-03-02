package edu.utec.horus.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.openxava.annotations.Hidden;

/**
 * Base class for defining entities with a UUID id.
 * <p>
 * 
 * @author Javier Paniza
 */

@MappedSuperclass
public class Identifiable {

	@Id
	@Hidden
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length = 32)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
