package com.sitebarbearia.sitebarbearia.service;

import com.sitebarbearia.sitebarbearia.model.Barbearia;
import java.util.Optional;

public interface BarbeariaService {
    Barbearia cadastrarBarbearia (Barbearia barbearia);
    Optional<Barbearia> buscarBarbeariaPorEmail (String email);
    Boolean autenticarBarbearia (String email, String senha);
    Barbearia atualizarBarbearia (Barbearia barbeariaAtualizada);
}