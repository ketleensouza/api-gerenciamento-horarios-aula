package br.edu.biblioteca.controller;

import br.edu.biblioteca.domain.Horario;
import br.edu.biblioteca.dto.HorarioRequest;
import br.edu.biblioteca.service.app.HorarioService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    private final HorarioService horarioService;

    public HorarioController(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    @GetMapping
    public List<Horario> listar() {
        return horarioService.listar();
    }

    @GetMapping("/{id}")
    public Horario buscarPorId(@PathVariable Long id) {
        return horarioService.buscarPorId(id);
    }

    @GetMapping("/professor/{professorId}")
    public List<Horario> listarPorProfessor(@PathVariable Long professorId) {
        return horarioService.listarPorProfessor(professorId);
    }

    @GetMapping("/turma/{turmaId}")
    public List<Horario> listarPorTurma(@PathVariable Long turmaId) {
        return horarioService.listarPorTurma(turmaId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Horario criar(@Valid @RequestBody HorarioRequest request) {
        return horarioService.criar(request);
    }

    @PutMapping("/{id}")
    public Horario atualizar(@PathVariable Long id, @Valid @RequestBody HorarioRequest request) {
        return horarioService.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        horarioService.remover(id);
    }
}
