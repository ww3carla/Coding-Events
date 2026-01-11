package com.ww3carla.coding_events.service;

import com.ww3carla.coding_events.mapper.RoleMapper;
import com.ww3carla.coding_events.models.Role;
import com.ww3carla.coding_events.models.dto.RoleDto;
import com.ww3carla.coding_events.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    public RoleDto getRoleById(Integer id) {
        return roleMapper.roleEntityToDto(roleRepository.findById(id).orElse(null));
    }

    public RoleDto findByRole(String role) {
        return roleMapper.roleEntityToDto(roleRepository.findByRole(role));
    }

    public List<RoleDto> getAllRoles() {
        return roleMapper.roleListEntityToDto(roleRepository.findAll());
    }

    public RoleDto createRole(Role role) {
        return roleMapper.roleEntityToDto(roleRepository.save(role));
    }

    public RoleDto updateRole(Role role) {
        return roleMapper.roleEntityToDto(roleRepository.save(role));
    }

    public void deleteRole(Role role) {
        roleRepository.delete(role);
    }
}
