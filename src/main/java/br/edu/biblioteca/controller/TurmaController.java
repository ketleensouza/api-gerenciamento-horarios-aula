package br.edu.biblioteca.controller;

import br.edu.biblioteca.domain.Turma;
import br.edu.biblioteca.dto.TurmaRequest;
import br.edu.biblioteca.service.app.TurmaService;
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
@RequestMapping("/api/turmas")
public class TurmaController {

    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @GetMapping
    public List<Turma> listar() {
        return turmaService.listar();
    }

    @GetMapping("/{id}")
    public Turma buscarPorId(@PathVariable Long id) {
        return turmaService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Turma criar(@Valid @RequestBody TurmaRequest request) {
        return turmaService.criar(request);
    }

    @PutMapping("/{id}")
    public Turma atualizar(@PathVariable Long id, @Valid @RequestBody TurmaRequest request) {
        return turmaService.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        turmaService.remover(id);
    }
}
