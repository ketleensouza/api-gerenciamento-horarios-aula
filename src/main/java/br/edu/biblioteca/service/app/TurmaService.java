package br.edu.biblioteca.service.app;

import br.edu.biblioteca.domain.Disciplina;
import br.edu.biblioteca.domain.Turma;
import br.edu.biblioteca.dto.TurmaRequest;
import br.edu.biblioteca.repository.jpa.TurmaRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;
    private final DisciplinaService disciplinaService;

    public TurmaService(TurmaRepository turmaRepository, DisciplinaService disciplinaService) {
        this.turmaRepository = turmaRepository;
        this.disciplinaService = disciplinaService;
    }

    public List<Turma> listar() {
        return turmaRepository.findAll();
    }

    public Turma buscarPorId(Long id) {
        return turmaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Turma nao encontrada: " + id));
    }

    public Turma criar(TurmaRequest request) {
        Disciplina disciplina = disciplinaService.buscarPorId(request.getDisciplinaId());
        Turma turma = new Turma();
        turma.setNome(request.getNome());
        turma.setSemestre(request.getSemestre());
        turma.setDisciplina(disciplina);
        return turmaRepository.save(turma);
    }

    public Turma atualizar(Long id, TurmaRequest request) {
        Turma existente = buscarPorId(id);
        Disciplina disciplina = disciplinaService.buscarPorId(request.getDisciplinaId());
        existente.setNome(request.getNome());
        existente.setSemestre(request.getSemestre());
        existente.setDisciplina(disciplina);
        return turmaRepository.save(existente);
    }

    public void remover(Long id) {
        Turma existente = buscarPorId(id);
        turmaRepository.delete(existente);
    }
}
