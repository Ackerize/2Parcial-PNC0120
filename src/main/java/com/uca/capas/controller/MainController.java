package com.uca.capas.controller;

import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Libro;
import com.uca.capas.service.CategoriaService;
import com.uca.capas.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private LibroService libroService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @GetMapping("/nuevoLibro")
    public ModelAndView nuevoLibro(){
        ModelAndView mav = new ModelAndView();
        Libro libro = new Libro();
        List<Categoria> categorias = null;
        mav.addObject("libro", libro);
        try{
            categorias = categoriaService.findAll();
            mav.addObject("categoria", categorias);
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.setViewName("libro");
        return mav;
    }

    @PostMapping("/insertarLibro")
    public ModelAndView insertLibro(@Valid @ModelAttribute Libro libro, BindingResult result){
        ModelAndView mav = new ModelAndView();
        List<Categoria> categorias = null;

        if(result.hasErrors()){
            categorias = categoriaService.findAll();
            mav.addObject("categoria", categorias);
            mav.setViewName("libro");
        }else{
            libro.setFechaIngreso(new Date());
            try{
                libroService.save(libro);
                mav.addObject("mensaje", "Libro guardado con exito");
                mav.setViewName("index");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return mav;
    }

    @GetMapping("/nuevaCat")
    public ModelAndView nuevaCat(){
        ModelAndView mav = new ModelAndView();
        Categoria categoria = new Categoria();
        mav.addObject("categoria", categoria);
        mav.setViewName("categoria");
        return mav;
    }

    @PostMapping("/insertarCategoria")
    public ModelAndView insertCategoria(@Valid @ModelAttribute Categoria categoria, BindingResult result){
        ModelAndView mav = new ModelAndView();
        if(result.hasErrors()){
            mav.setViewName("categoria");
        }else{
            try{
                categoriaService.save(categoria);
                mav.addObject("mensaje", "Categoria guardada con exito");
                mav.setViewName("index");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return mav;
    }

    @GetMapping("/libros")
    public ModelAndView lista(){
        ModelAndView mav = new ModelAndView();
        List<Libro> libros = null;
        try{
            libros = libroService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("libro", libros);
        mav.setViewName("listado");
        return mav;
    }
}
