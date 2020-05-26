package com.uca.capas.domain;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(schema = "public", name = "cat_categoria")
public class Categoria {

    @Id
    @Column(name = "c_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoCategoria;

    @NotEmpty(message = "El campo nombre categoria no puede estar vacio")
    @Size(max = 50, message = "El campo sobrepasa la cantidad de 50 caracteres")
    @Column(name = "s_categoria")
    private String nombre;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Integer getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
