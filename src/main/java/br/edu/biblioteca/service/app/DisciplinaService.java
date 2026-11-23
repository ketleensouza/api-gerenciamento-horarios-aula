package br.edu.biblioteca.service.app;

import br.edu.biblioteca.domain.Disciplina;
import br.edu.biblioteca.repository.jpa.DisciplinaRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<Disciplina> listar() {
        return disciplinaRepository.findAll();
    }

    public Disciplina buscarPorId(Long id) {
        return disciplinaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Disciplina nao encontrada: " + id));
    }

    public Disciplina criar(Disciplina disciplina) {
        disciplina.setId(null);
        return disciplinaRepository.save(disciplina);
    }

    public Disciplina atualizar(Long id, Disciplina disciplina) {
        Disciplina existente = buscarPorId(id);
        existente.setNome(disciplina.getNome());
        existente.setCodigo(disciplina.getCodigo());
        existente.setCargaHoraria(disciplina.getCargaHoraria());
        return disciplinaRepository.save(existente);
    }

    public void remover(Long id) {
        Disciplina existente = buscarPorId(id);
        disciplinaRepository.delete(existente);
    }
}
