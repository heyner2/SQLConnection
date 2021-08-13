package net.main.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.main.demo.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
