package com.imrob.locadoraveiculos;

import com.imrob.locadoraveiculos.DTO.CarroDTO;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        Field[] campos = CarroDTO.class.getDeclaredFields();
        List<String> colunas = new ArrayList<>();

        for (Field campo : campos) {
            colunas.add(campo.getName());
        }

        System.out.println(colunas);
    }
}
