package com.ww3carla.coding_events.controllers;

import com.ww3carla.coding_events.models.dto.RoleDto;
import com.ww3carla.coding_events.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/roles")
    public String getRoles(Model model) {
        List<RoleDto> roleDtos = roleService.getAllRoles();
        model.addAttribute("title", "Roles");
        model.addAttribute("roles", roleDtos);

        return "roles";
    }

    @GetMapping("/roles/{id}")
    public RoleDto getRoleById(@PathVariable Integer id) {
        return roleService.getRoleById(id);
    }
}
