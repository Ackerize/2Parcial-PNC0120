package com.uca.capas.dao;

import com.uca.capas.domain.Categoria;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface CategoriaDAO {
    public List<Categoria> findAll() throws DataAccessException;
    public void save(Categoria categoria) throws  DataAccessException;
}
