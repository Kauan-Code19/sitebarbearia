package com.sitebarbearia.sitebarbearia.controller;

import com.sitebarbearia.sitebarbearia.model.Barbearia;
import com.sitebarbearia.sitebarbearia.model.Cliente;
import com.sitebarbearia.sitebarbearia.service.BarbeariaService;
import com.sitebarbearia.sitebarbearia.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private BarbeariaService barbeariaService;

    @PostMapping("/cadastro-cliente")
    public ResponseEntity<Object> cadastrarCliente (@RequestBody Cliente cliente) {
        try {
            Cliente novoCliente = clienteService.cadastrarCliente(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
        }catch (RuntimeException error) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error.getMessage());
        }
    }

    @PostMapping("/cadastro-barbearia")
    public ResponseEntity<Object> cadastrarBarbearia (@RequestBody Barbearia barbearia) {
        try {
            Barbearia novaBarbearia = barbeariaService.cadastrarBarbearia(barbearia);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaBarbearia);
        }catch (RuntimeException error) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error.getMessage());
        }
    }
}