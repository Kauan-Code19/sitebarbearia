package com.sitebarbearia.sitebarbearia.service;

import com.sitebarbearia.sitebarbearia.model.Cliente;
import com.sitebarbearia.sitebarbearia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        if (autenticarCliente(cliente.getEmail(), cliente.getSenha())) {
            throw new RuntimeException("Cliente já existente");
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> buscarClientePorEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    @Override
    public Boolean autenticarCliente(String email, String senha) {
        Optional<Cliente> clienteExistente = buscarClientePorEmail(email);

        return clienteExistente.isPresent() && clienteExistente.get().getSenha().equals(senha);
    }

    public List<Cliente> obterTodosClientes() {
        return clienteRepository.findAll();
    }
}