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
        return barbeariaRepository.save(barbearia);
    }

    @Override
    public Optional<Barbearia> buscarBarbeariaPorEmail(String email) {
        return barbeariaRepository.findByEmail(email);
    }
}