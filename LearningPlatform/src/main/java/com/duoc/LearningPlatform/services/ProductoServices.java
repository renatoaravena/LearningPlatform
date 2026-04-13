package com.duoc.LearningPlatform.services;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.duoc.LearningPlatform.model.Producto;

@Service
public class ProductoServices {
    
    List<Producto> productos = new ArrayList<Producto>(
        Arrays.asList(
            new Producto(1,"Completo", 4500, "Rico completo italiano"),
            new Producto(2,"Hamburguesa", 5000, "Jugosa hamburguesa con queso"),
            new Producto(3,"Perro caliente", 3500, "Delicioso perro caliente")
        )
    );

    public List<Producto> getProductos() {
        return productos;
    }

    public Producto getProductoById(int id) {
        return productos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }    

    public void addProducto(Producto producto) {
        productos.add(producto);
    }

    public void updateProducto(int id, Producto producto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == id) {
                productos.set(i, producto);
                return;
            }
        }
    }

    public void deleteProducto(int id) {
        productos.removeIf(p -> p.getId() == id);
    }
}
