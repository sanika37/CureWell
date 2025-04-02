package com.sanika.curewell_backend.controller;

import com.sanika.curewell_backend.dto.LoginDto;
import com.sanika.curewell_backend.dto.RegisterDto;
import com.sanika.curewell_backend.services.AuthService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginDto loginDto) {
        String token = authService.login(loginDto);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterDto registerDto) {
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/role")
    public ResponseEntity<String> createRole(@RequestBody Map<String, String> requestBody) {
    String name = requestBody.get("name");
    String response = authService.createRole(name);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
}

    @DeleteMapping("/roles/{name}")
    public ResponseEntity<String> deleteRole(@PathVariable String name) {
        String response = authService.deleteRole(name);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/roles")
    public ResponseEntity<?> getAllRoles() {
        return ResponseEntity.ok(authService.getAllRoles());
    }

    @GetMapping("/roles/{name}")
    public ResponseEntity<String> getRoleByName(@PathVariable String name) {
        String response = authService.getRoleByName(name);
        return ResponseEntity.ok(response);
    }
}