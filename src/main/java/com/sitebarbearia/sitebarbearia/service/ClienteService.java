package com.sitebarbearia.sitebarbearia.service;

import com.sitebarbearia.sitebarbearia.model.Cliente;
import java.util.Optional;

public interface ClienteService {
    Cliente cadastrarCliente(Cliente cliente);
    Optional<Cliente> buscarClientePorEmail (String email);
    Boolean autenticarCliente(String email, String senha);
    Cliente atualizarCliente (Cliente clienteAtualizado);
    void excluirCliente (Long clienteId);
}