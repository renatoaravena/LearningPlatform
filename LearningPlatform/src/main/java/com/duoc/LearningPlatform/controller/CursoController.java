package com.duoc.LearningPlatform.controller;

import com.duoc.LearningPlatform.model.Curso;
import com.duoc.LearningPlatform.repository.CursoRepository;
import com.duoc.LearningPlatform.services.CursoService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;
    private final CursoRepository cursoRepository;

    @GetMapping("/disponibles")
    public List<Curso> listarCursos() {
        return cursoService.obtenerCursosDisponibles();
    }

    @GetMapping("/no-disponibles")
    public List<Curso> listarCursosNoDisponibles() {
        return cursoService.obtenerCursosNoDisponibles();
    }

    @GetMapping("/todos-los-cursos")
    public List<Curso> listarTodosLosCursos() {
        return cursoService.obtenerCursos();
    }
    

    @DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        boolean fueEliminado = cursoRepository.eliminarCurso(id); // O llamando a tu Service
        
        if (fueEliminado) {
            return "El curso fue eliminado con éxito.";
        } else {
            return "Error: No se encontró un curso con ese ID.";
        }
    }

    @PostMapping("/agregar")
    public Curso agregar(@RequestBody Curso nuevoCurso) {
        return cursoRepository.agregarCurso(nuevoCurso);
    }

    @PutMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Long id, @RequestBody Curso cursoActualizado) {
        boolean exito = cursoService.editarCurso(id, cursoActualizado);
    
        if (exito) {
            return "El curso con ID " + id + " ha sido actualizado correctamente.";
        } else {
            return "No se pudo actualizar: El curso con ID " + id + " no existe.";
        }
    }

}