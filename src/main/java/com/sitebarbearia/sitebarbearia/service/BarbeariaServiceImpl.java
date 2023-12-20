package com.sitebarbearia.sitebarbearia.service;

import com.sitebarbearia.sitebarbearia.model.Barbearia;
import com.sitebarbearia.sitebarbearia.repository.BarbeariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BarbeariaServiceImpl implements BarbeariaService {
    @Autowired
    private BarbeariaRepository barbeariaRepository;

    @Override
    public Barbearia cadastrarBarbearia(Barbearia barbearia) {
        if (autenticarBarbearia(barbearia.getEmail(), barbearia.getSenha())) {
            throw new RuntimeException("Barbearia já Existente");
        }
        return barbeariaRepository.save(barbearia);
    }

    @Override
    public Optional<Barbearia> buscarBarbeariaPorEmail(String email) {
        return barbeariaRepository.findByEmail(email);
    }

    @Override
    public Boolean autenticarBarbearia(String email, String senha) {
        Optional<Barbearia> barbeariaExistente = buscarBarbeariaPorEmail(email);

        return barbeariaExistente.isPresent() && barbeariaExistente.get().getSenha().equals(senha);
    }

    @Override
    public Barbearia atualizarBarbearia(Barbearia barbeariaAtualizada) {
        Long barbeariaID = barbeariaAtualizada.getBarbeariaID();

        Optional<Barbearia> barbeariaExistente = barbeariaRepository.findById(barbeariaID);

        if (barbeariaExistente.isPresent()) {
            Barbearia barbearia = barbeariaExistente.get();
            barbearia.setNome(barbeariaAtualizada.getNome());
            barbearia.setEmail(barbeariaAtualizada.getEmail());
            barbearia.setSenha(barbeariaAtualizada.getSenha());
            barbearia.setDescricao(barbeariaAtualizada.getDescricao());
            barbearia.setEndereco(barbeariaAtualizada.getEndereco());
            barbearia.setContato(barbeariaAtualizada.getContato());

            return barbeariaRepository.save(barbearia);
        }else {
            throw new RuntimeException("Barbearia não encontrada");
        }
    }
}