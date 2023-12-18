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
    public ResponseEntity<Cliente> cadastrarCliente (@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.cadastrarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @GetMapping("/teste")
    public ResponseEntity<String> teste() {
        return ResponseEntity.ok("Teste bem-sucedido");
    }

    @PostMapping("/cadastro-barbearia")
    public ResponseEntity<Barbearia> cadastrarBarbearia (@RequestBody Barbearia barbearia) {
        Barbearia novaBarbearia = barbeariaService.cadastrarBarbearia(barbearia);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaBarbearia);
    }
}