package com.duoc.LearningPlatform.services;

import com.duoc.LearningPlatform.model.Curso;
import com.duoc.LearningPlatform.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;

   
    public List<Curso> obtenerCursosDisponibles() {
        return cursoRepository.obtenerTodos().stream()
                .filter(Curso::isActivo) // Filtramos los activos, les aplica el metodo isActivo() generado por Lombok en cada Curso, si es true se queda, si es false se descarta.
                .sorted((c1, c2) -> c1.getNombre().compareToIgnoreCase(c2.getNombre())) // Tomamos cursos de pares y comparamos para ir ordenando alfabeticamente por nombre.
                .collect(Collectors.toList()); // Atrapa los cursos filtrados y ordenados en una nueva lista que se retorna al controlador.
    }

    public List<Curso> obtenerCursosNoDisponibles() {
        return cursoRepository.obtenerTodos().stream()
                .filter(curso -> !curso.isActivo()) // Filtramos los activos, les aplica el metodo isActivo() generado por Lombok en cada Curso, si es true se queda, si es false se descarta.
                .sorted((c1, c2) -> c1.getNombre().compareToIgnoreCase(c2.getNombre())) // Tomamos cursos de pares y comparamos para ir ordenando alfabeticamente por nombre.
                .collect(Collectors.toList()); // Atrapa los cursos filtrados y ordenados en una nueva lista que se retorna al controlador.
    }

    public List<Curso> obtenerCursos() {
        return cursoRepository.obtenerTodos().stream()
                .sorted((c1, c2) -> c1.getNombre().compareToIgnoreCase(c2.getNombre())) 
                .collect(Collectors.toList()); 
    }

    public boolean editarCurso(Long id, Curso cursoActualizado) {
        return cursoRepository.actualizarCurso(id, cursoActualizado);
    }

    
}