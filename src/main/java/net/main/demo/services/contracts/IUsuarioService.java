package net.main.demo.services.contracts;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import net.main.demo.DTOs.UsuarioRegistrationDTO;

public interface IUsuarioService extends UserDetailsService {

	public boolean save(UsuarioRegistrationDTO usuario);

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
