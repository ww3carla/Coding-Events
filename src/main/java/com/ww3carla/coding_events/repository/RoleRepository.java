package com.ww3carla.coding_events.repository;

import com.ww3carla.coding_events.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
