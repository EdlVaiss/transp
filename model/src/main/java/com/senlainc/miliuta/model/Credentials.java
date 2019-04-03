package com.senlainc.miliuta.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "credentials", catalog = "auto")
public class Credentials implements Serializable {

	private static final long serialVersionUID = 4815401203131984889L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "token", unique = true, nullable = false, length = 100)
	private String token;

	@Column(name = "login", unique = true, nullable = false, length = 100)
	private String login;

	@Transient
	private String password;

	@Column(name = "is_admin", nullable = false, columnDefinition = "BIT")
	private Boolean isAdmin;
	
	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "position", nullable = true, length = 100)
	private String position;


	public Credentials() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
