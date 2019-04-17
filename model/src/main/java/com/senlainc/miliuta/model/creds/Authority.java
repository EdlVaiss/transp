package com.senlainc.miliuta.model.creds;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities", catalog = "auto")
public class Authority implements Serializable {
 
	private static final long serialVersionUID = 7789085595959513885L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
	@Column(name = "name", nullable = false)
	private String name;

	public Authority() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
