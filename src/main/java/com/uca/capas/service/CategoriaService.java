package com.uca.capas.service;

import com.uca.capas.domain.Categoria;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface CategoriaService {
    public List<Categoria> findAll() throws DataAccessException;
    public void save(Categoria categoria) throws  DataAccessException;
}
