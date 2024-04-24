package com.imrob.locadoraveiculos.services;

import com.fasterxml.jackson.databind.JsonNode;
import feign.Param;
import feign.RequestLine;

public interface ViaCEP {
    @RequestLine("GET /ws/{cep}/json/")
    JsonNode consultarCEP(@Param("cep") String cep);
}

