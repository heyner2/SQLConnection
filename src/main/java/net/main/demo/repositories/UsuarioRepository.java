package net.main.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.main.demo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
Usuario findByUsername(String username);
}
