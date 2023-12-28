package com.infra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infra.entity.Role;
import com.infra.repo.RoleRepository;
import com.infra.serviceInterface.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleRepository rr;
	@Override
	public Role saveRoel(Role r) {
		return rr.save(r);
	}

	/*
	 * @Override public List<Role> saveAllRole(List<Role> roles){ List<Role>
	 * addedRole=new ArrayList<>(); for(Role r:roles) addedRole.add(saveRoel(r));
	 * return addedRole; }
	 */
	@Override
	public void deleteRole(Role r) {
		rr.delete(r);
	}
	@Override
	public Optional<Role> getRole(String name) {
		
		return rr.findByAuthority(name);
	}

}
