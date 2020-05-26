package com.uca.capas.dao;

import com.uca.capas.domain.Libro;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class LibroDAOImpl implements LibroDAO{
    @PersistenceContext(unitName = "capas")
    private EntityManager entityManager;

    @Override
    public List<Libro> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM cat_libro");
        Query query = entityManager.createNativeQuery(sb.toString(), Libro.class);
        List<Libro> libros = query.getResultList();
        return libros;
    }

    @Override
    @Transactional
    public void save(Libro libro) throws DataAccessException {
        try{
            if(libro.getCodigoLibro() == null){
                entityManager.persist(libro);
            }else{
                entityManager.merge(libro);
                entityManager.flush();
            }
        }catch (Throwable e){
            e.printStackTrace();
        }
    }
}
