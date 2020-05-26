package com.uca.capas.dao;

import com.uca.capas.domain.Libro;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface LibroDAO {
    public List<Libro> findAll() throws DataAccessException;
    public void save(Libro libro) throws  DataAccessException;
}
