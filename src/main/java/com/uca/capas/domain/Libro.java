package com.uca.capas.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(schema = "public", name = "cat_libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_libro")
    private Integer codigoLibro;

    @NotEmpty(message = "El campo titulo no puede estar vacio")
    @Size(max = 500, message = "El campo sobrepasa la cantidad de 500 caracteres")
    @Column(name = "s_titulo")
    private String titulo;

    @NotEmpty(message = "El campo autor no puede estar vacio")
    @Size(max = 150, message = "El campo sobrepasa la cantidad de 150 caracteres")
    @Column(name = "s_autor")
    private String autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="c_categoria")
    private Categoria categoria;

    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm")
    @Column(name = "f_ingreso")
    private Date fechaIngreso;

    @Column(name = "b_estado")
    private boolean estado;

    @NotEmpty(message = "El campo isbn no puede estar vacio")
    @Size(max = 10, message = "El campo sobrepasa la cantidad de 10 caracteres")
    @Column(name = "s_isbn")
    private String isbn;

    public Libro() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Integer getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(Integer codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getFechaIngreso() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
        String fecha = formatter.format(fechaIngreso);
        return fecha;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
