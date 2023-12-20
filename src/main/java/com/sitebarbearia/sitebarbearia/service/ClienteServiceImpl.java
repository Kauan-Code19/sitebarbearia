package com.sitebarbearia.sitebarbearia.service;

import com.sitebarbearia.sitebarbearia.model.Cliente;
import com.sitebarbearia.sitebarbearia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Cliente atualizarCliente(Cliente clienteAtualizado) {
        Long clienteID = clienteAtualizado.getClienteID();

        Optional<Cliente> clienteExistente = clienteRepository.findById(clienteID);

        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setEmail(clienteAtualizado.getEmail());
            cliente.setSenha(clienteAtualizado.getSenha());
            cliente.setEndereco(clienteAtualizado.getEndereco());

            return clienteRepository.save(cliente);
        }else {
            throw new RuntimeException("Cliente não encontrado");
        }
    }

    @Override
    public void excluirCliente(Long clienteId) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(clienteId);

        if (clienteExistente.isPresent()) {
            clienteRepository.deleteById(clienteId);
        } else throw new RuntimeException("Cliente não encontrado");
    }
}