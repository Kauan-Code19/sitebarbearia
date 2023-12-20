package com.sitebarbearia.sitebarbearia.controller;

import com.sitebarbearia.sitebarbearia.service.BarbeariaService;
import com.sitebarbearia.sitebarbearia.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/excluir")
public class ExcluirController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private BarbeariaService barbeariaService;

    @DeleteMapping("/excluir-cliente/{clienteID}")
    public ResponseEntity<Object> excluirCliente (@PathVariable Long clienteID) {
        try {
            clienteService.excluirCliente(clienteID);
            return ResponseEntity.ok("Cliente excluido com sucesso");
        } catch (RuntimeException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }

    @DeleteMapping("/excluir-barbearia/{barbeariaID}")
    public ResponseEntity<Object> excluirBarbearia (@PathVariable Long barbeariaID) {
        try {
            barbeariaService.excluirBarbearia(barbeariaID);
            return ResponseEntity.ok("Barbearia excluida com sucesso");
        } catch (RuntimeException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }
}
