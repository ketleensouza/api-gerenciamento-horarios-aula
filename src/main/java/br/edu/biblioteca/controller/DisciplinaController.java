package br.edu.biblioteca.controller;

import br.edu.biblioteca.domain.Disciplina;
import br.edu.biblioteca.service.app.DisciplinaService;
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
@RequestMapping("/api/disciplinas")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @GetMapping
    public List<Disciplina> listar() {
        return disciplinaService.listar();
    }

    @GetMapping("/{id}")
    public Disciplina buscarPorId(@PathVariable Long id) {
        return disciplinaService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Disciplina criar(@Valid @RequestBody Disciplina disciplina) {
        return disciplinaService.criar(disciplina);
    }

    @PutMapping("/{id}")
    public Disciplina atualizar(@PathVariable Long id, @Valid @RequestBody Disciplina disciplina) {
        return disciplinaService.atualizar(id, disciplina);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        disciplinaService.remover(id);
    }
}
