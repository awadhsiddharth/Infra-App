package com.infra.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.infra.entity.Role;

public interface RoleService {

	Role saveRoel(Role r);
	Optional<Role> getRole(String name);
	void deleteRole(Role r);
	//List<Role> saveAllRole(List<Role> roles);
}
