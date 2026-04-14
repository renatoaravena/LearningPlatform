package com.duoc.LearningPlatform.repository;

import com.duoc.LearningPlatform.model.Curso;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CursoRepository {
    
    private List<Curso> listaCursos = new ArrayList<>();

    public CursoRepository() {
        listaCursos.add(new Curso(1L, "Spring Boot Basico", "Introduccion a microservicios", true));
        listaCursos.add(new Curso(2L, "Docker para Desarrolladores", "Gestion de contenedores", true));
        listaCursos.add(new Curso(3L, "Arquitectura de Software", "Patrones y diseño", false)); // Inactivo
        listaCursos.add(new Curso(4L, "Bases de Datos con JPA", "Persistencia de datos", true));
    }

    public List<Curso> obtenerTodos() {
        return listaCursos;
    }

    public boolean eliminarCurso(Long id) {
        return listaCursos.removeIf(curso -> curso.getId().equals(id));
    }

    public Curso agregarCurso(Curso nuevoCurso) {
        listaCursos.add(nuevoCurso);
        
        return nuevoCurso; 
    }

    public boolean actualizarCurso(Long id, Curso cursoConNuevosDatos) {
    for (Curso curso : listaCursos) {
        if (curso.getId().equals(id)) {
            curso.setNombre(cursoConNuevosDatos.getNombre());
            curso.setDescripcion(cursoConNuevosDatos.getDescripcion());
            curso.setActivo(cursoConNuevosDatos.isActivo());
            return true; // Actualización exitosa
        }
    }
    return false; // No se encontró el curso
    }
}
