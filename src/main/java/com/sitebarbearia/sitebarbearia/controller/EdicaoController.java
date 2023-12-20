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
@RequestMapping("/edicao")
public class EdicaoController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private BarbeariaService barbeariaService;

    @PostMapping("/edicao-cliente")
    public ResponseEntity<Object> edicaoCliente (@RequestBody Cliente cliente) {
        try {
            Cliente clienteAtualizado = clienteService.atualizarCliente(cliente);
            return ResponseEntity.ok(clienteAtualizado);
        }catch (RuntimeException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }

    @PostMapping("/edicao-barbearia")
    public ResponseEntity<Object> edicaoBarbearia (@RequestBody Barbearia barbearia) {
        try {
            Barbearia barbeariaAtualizada = barbeariaService.atualizarBarbearia(barbearia);
            return ResponseEntity.ok(barbeariaAtualizada);
        }catch (RuntimeException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }
}
