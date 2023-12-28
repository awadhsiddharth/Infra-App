package com.infra.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infra.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Optional<Role> findByAuthority(String name);


}
