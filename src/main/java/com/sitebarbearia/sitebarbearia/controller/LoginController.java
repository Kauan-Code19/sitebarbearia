package com.sitebarbearia.sitebarbearia.controller;

import com.sitebarbearia.sitebarbearia.model.Barbearia;
import com.sitebarbearia.sitebarbearia.model.Cliente;
import com.sitebarbearia.sitebarbearia.service.BarbeariaService;
import com.sitebarbearia.sitebarbearia.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private BarbeariaService barbeariaService;

    @PostMapping("/login-cliente")
    public ResponseEntity<String> loginCliente (@RequestBody Cliente cliente) {
        if (clienteService.autenticarCliente(cliente.getEmail(), cliente.getSenha())) {
            return ResponseEntity.ok("Login bem-sucedido para cliente");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas para cliente");
        }
    }

    @PostMapping("login-barbearia")
    public ResponseEntity<String> loginBarbearia (@RequestBody Barbearia barbearia) {
        if (barbeariaService.autenticarBarbearia(barbearia.getEmail(), barbearia.getSenha())) {
            return ResponseEntity.ok("Login bem-sucedido para barbearia");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas para barbeiro");
        }
    }
}