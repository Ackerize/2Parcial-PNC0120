package com.uca.capas.service;

import com.uca.capas.dao.LibroDAO;
import com.uca.capas.domain.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService{

    @Autowired
    LibroDAO libroDAO;

    @Override
    public List<Libro> findAll() throws DataAccessException {
        return libroDAO.findAll();
    }

    @Override
    public void save(Libro libro) throws DataAccessException {
        libroDAO.save(libro);
    }
}
