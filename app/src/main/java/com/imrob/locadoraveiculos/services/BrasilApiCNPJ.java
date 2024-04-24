package com.imrob.locadoraveiculos.services;

import com.fasterxml.jackson.databind.JsonNode;
import feign.Param;
import feign.RequestLine;

public interface BrasilApiCNPJ {
    @RequestLine("GET /api/cnpj/v1/{cnpj}")
    JsonNode consultarCNPJ(@Param("cnpj") String cnpj);
}