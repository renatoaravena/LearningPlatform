package com.duoc.LearningPlatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.duoc.LearningPlatform.services.ProductoServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.duoc.LearningPlatform.model.Producto;
import com.duoc.LearningPlatform.services.ProductoServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    private ProductoServices productoServices;

    @GetMapping("/producto")
    public List<Producto> getProductos() {
        return productoServices.getProductos();
    }
    
    @GetMapping("/producto/{id}")
    public Producto getProductoById(@PathVariable int id) {
        return productoServices.getProductoById(id);
    }

    @PostMapping("/producto")
    public void addProducto(@RequestBody Producto producto) {
        productoServices.addProducto(producto);
    }

    @PutMapping("/producto/{id}")
    public void updateProducto(@PathVariable int id, @RequestBody Producto producto) {
        productoServices.updateProducto(id, producto);
    }

    @DeleteMapping("/producto/{id}")
    public void deleteProducto(@PathVariable int id) {
        productoServices.deleteProducto(id);
    }

}
