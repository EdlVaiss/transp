package com.senlainc.miliuta.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.senlainc.miliuta.model.creds.MyUserDetails;

@Service
public class CustomUserDetailsService extends AbstractService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return new MyUserDetails(userDAO.getByName(username));
	}

}
