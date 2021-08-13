package net.main.demo.services.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.main.demo.DTOs.UsuarioRegistrationDTO;
import net.main.demo.model.Role;
import net.main.demo.model.Usuario;
import net.main.demo.repositories.RoleRepository;
import net.main.demo.repositories.UsuarioRepository;
import net.main.demo.services.contracts.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	UsuarioRepository repo;
	
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired 
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public boolean save(UsuarioRegistrationDTO usuarioDto) {		
		try {
			Role rol= roleRepo.findById(2);
			Usuario usuario=new Usuario(usuarioDto.username,passwordEncoder.encode(usuarioDto.pass),rol);
			repo.save(usuario);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}

	//this method is added UserDetailsService added on the Iusuarioservice interface
	//this is link to the configuration file for spring security
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user =repo.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		Collection<Role> rol=new ArrayList<>();
		rol.add(user.role);
		return new org.springframework.security.core.userdetails
				.User(user.getUsername(), user.getPass(), mapRolAuthorities(rol));
	}
	
	private Collection<? extends GrantedAuthority> mapRolAuthorities(Collection<Role> roles){
	return	roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());		
	}

}
