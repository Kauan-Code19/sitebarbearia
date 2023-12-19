package com.sitebarbearia.sitebarbearia.repository;

import com.sitebarbearia.sitebarbearia.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByEmail (String email);
    List<Cliente> findAll();
}