package com.sanika.curewell_backend.services.impl;

import com.sanika.curewell_backend.dto.LoginDto;
import com.sanika.curewell_backend.dto.RegisterDto;
import com.sanika.curewell_backend.entity.Role;
import com.sanika.curewell_backend.entity.User;
import com.sanika.curewell_backend.exception.CurewellException;
import com.sanika.curewell_backend.repository.RoleRepository;
import com.sanika.curewell_backend.repository.UserRepository;
import com.sanika.curewell_backend.security.JwtTokenProvider;
import com.sanika.curewell_backend.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AuthServiceImpl implements AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtTokenProvider.generateToken(authentication);
    }

    @Override
    @Transactional
    public String register(RegisterDto registerDto) {
        logger.info("Starting registration for user: {}", registerDto.getUsername());

        try {
            logger.info("Checking if username exists: {}", registerDto.getUsername());
            if (userRepository.existsByUsername(registerDto.getUsername())) {
                logger.error("Username already exists: {}", registerDto.getUsername());
                throw new CurewellException(HttpStatus.BAD_REQUEST, "Username is already taken!");
            }

            logger.info("Checking if email exists: {}", registerDto.getEmail());
            if (userRepository.existsByEmail(registerDto.getEmail())) {
                logger.error("Email already exists: {}", registerDto.getEmail());
                throw new CurewellException(HttpStatus.BAD_REQUEST, "Email is already taken!");
            }

            User user = new User();
            user.setName(registerDto.getName());
            user.setUsername(registerDto.getUsername());
            user.setEmail(registerDto.getEmail());
            user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

            Set<Role> roles = new HashSet<>();
            Role role = roleRepository.findByName(registerDto.getRole())
                    .orElseThrow(() -> {
                        logger.error("Role not found: {}", registerDto.getRole());
                        return new CurewellException(HttpStatus.BAD_REQUEST, "Role not found");
                    });
            roles.add(role);
            user.setRoles(roles);

            logger.info("Saving user to database: {}", user.getUsername());
            userRepository.save(user);
            logger.info("User registered successfully: {}", user.getUsername());

            return "User registered successfully!";

        } catch (Exception e) {
            logger.error("Error during registration: {}", e.getMessage(), e);
            throw new RuntimeException("Registration failed", e);
        }
    }

    @Override
    public String createRole(String name) {
        Role role = new Role();
        role.setName(name);
        roleRepository.save(role);
        return "Role created successfully!";
    }

    @Override
    public String deleteRole(String name) {
        roleRepository.deleteByName(name);
        return "Role deleted successfully!";
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public String getRoleByName(String name) {
        return roleRepository.findByName(name)
                .orElseThrow(() -> new CurewellException(HttpStatus.BAD_REQUEST, "Role not found")).getName();
    }
}