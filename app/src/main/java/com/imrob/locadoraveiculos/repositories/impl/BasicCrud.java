package com.imrob.locadoraveiculos.repositories.impl;

import java.util.List;

public interface BasicCrud<ENTITY> {
    public ENTITY save(ENTITY entity);
    public void delete(ENTITY entity);
    public ENTITY update(ENTITY entity);
    public ENTITY findById(Long id);
    public List<ENTITY> findAll();

}
