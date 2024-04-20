package com.imrob.locadoraveiculos.services;

import com.imrob.locadoraveiculos.DTO.CarroDTO;
import com.imrob.locadoraveiculos.gui.application.Application;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CarroServiceTest {
    private CarroService service;

    @BeforeEach
    void setUp() {
        service = new CarroService();
    }

    @Order(1)
    @Test
    void deveRetornarUmaListaDeCarrosDoBancoDeDados() {
        List<CarroDTO> result = service.findAll();
        System.out.println("O Tamanho da lista é: " + result.size());
        assertNotNull(result);
    }

    @Order(2)
    @Test
    void deveRetornarUmaListaDeCarrosDoCache() {
        List<CarroDTO> result = service.findAll();
        result.forEach(System.out::println);

        assertNotNull(result);
    }
}
