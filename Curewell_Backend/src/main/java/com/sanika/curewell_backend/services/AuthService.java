package com.sanika.curewell_backend.services;

import com.sanika.curewell_backend.dto.LoginDto;
import com.sanika.curewell_backend.dto.RegisterDto;
import com.sanika.curewell_backend.entity.Role;

import java.util.List;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    String createRole(String name);
    String deleteRole(String name);
    List<Role> getAllRoles();
    String getRoleByName(String name);
}