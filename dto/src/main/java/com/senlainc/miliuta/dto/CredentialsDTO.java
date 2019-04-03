package com.senlainc.miliuta.dto;

import java.io.Serializable;

import com.senlainc.miliuta.dto.api.GenericDTO;
import com.senlainc.miliuta.model.Credentials;

public class CredentialsDTO implements Serializable, GenericDTO<Credentials> {

	private static final long serialVersionUID = -402589399441965452L;

	private Integer id;
	private String token;
	private String login;
	private String password;
	private Boolean isAdmin;
	private String name;
	private String position;

	public CredentialsDTO() {
	}

	public CredentialsDTO(Integer id, String token, String login, String password, Boolean isAdmin, String name,
			String position) {
		this.id = id;
		this.token = token;
		this.login = login;
		this.password = password;
		this.isAdmin = isAdmin;
		this.name = name;
		this.position = position;
	}
	
	public CredentialsDTO(String login, String password, Boolean isAdmin, String name,
			String position) {
		this.login = login;
		this.password = password;
		this.isAdmin = isAdmin;
		this.name = name;
		this.position = position;
	}

	public CredentialsDTO(Credentials item) {
		this.id = item.getId();
		this.token = item.getToken();
		this.login = item.getLogin();
		this.isAdmin = item.getIsAdmin();
		this.name = item.getName();
		this.position = item.getPosition();
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

	@Override
	public Credentials toModel() {
		Credentials credentials = new Credentials();
		credentials.setId(id);
		credentials.setToken(token);
		credentials.setLogin(login);
		credentials.setIsAdmin(isAdmin);
		credentials.setName(name);
		credentials.setPosition(position);
		return credentials;
	}

}
