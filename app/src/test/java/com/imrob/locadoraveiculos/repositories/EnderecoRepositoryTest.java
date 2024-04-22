package com.imrob.locadoraveiculos.repositories;

import com.imrob.locadoraveiculos.entities.Endereco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoRepositoryTest {
    private EnderecoRepository repository;
    @BeforeEach
    void setUp() {
        repository = new EnderecoRepository();
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
        Endereco endereco = new Endereco(
                "Rua 1",
            "123",
            "Bairro 1",
            "Cidade 1",
            "Estado 1",
            "123456789"
        );
        Long id = repository.save(endereco);
        assertNotNull(id);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}