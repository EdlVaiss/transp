package com.senlainc.miliuta.model.creds;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users", catalog = "auto")
public class User implements Serializable{

	private static final long serialVersionUID = -4289145143369613562L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
	@Column(name = "username", nullable = false)
	private String userName;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "enabled", nullable = false, columnDefinition = "TINYINT")
	private Boolean enabled;

	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
	@JoinTable(name = "users_authorities", joinColumns = {
			@JoinColumn(name = "user_id") }, inverseJoinColumns = {
					@JoinColumn(name = "authority_id") })
	private Set<Authority> authorities = new HashSet<>(0);;

	public User() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
}
