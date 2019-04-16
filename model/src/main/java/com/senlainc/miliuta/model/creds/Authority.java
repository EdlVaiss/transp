package com.senlainc.miliuta.model.creds;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "authorities", catalog = "auto")
public class Authority {
	@Column(name = "authority", nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "username", nullable = false)
	private User user;

	public Authority() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
