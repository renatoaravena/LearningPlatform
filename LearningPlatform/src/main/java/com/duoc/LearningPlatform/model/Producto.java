package com.duoc.LearningPlatform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Producto {

    private int id;
    private String nombre;
    private int precio;
    private String descripcion;                
    

}
