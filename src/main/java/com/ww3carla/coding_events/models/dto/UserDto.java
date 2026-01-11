package com.ww3carla.coding_events.models.dto;

import lombok.Builder;

import java.util.List;

//immutable class, to protect user data, what it is shown in the UI
@Builder
public record UserDto (
        String username,
        List<RoleDto> roles,
        String firstName,
        String lastName,
        String emailAddress) {}
