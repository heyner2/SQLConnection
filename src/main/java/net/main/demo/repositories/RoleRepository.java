package net.main.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.main.demo.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
Role findById(int id);
}
