package br.edu.biblioteca.service.app;

import br.edu.biblioteca.domain.Professor;
import br.edu.biblioteca.repository.jpa.ProfessorRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> listar() {
        return professorRepository.findAll();
    }

    public Professor buscarPorId(Long id) {
        return professorRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Professor nao encontrado: " + id));
    }

    public Professor criar(Professor professor) {
        professor.setId(null);
        return professorRepository.save(professor);
    }

    public Professor atualizar(Long id, Professor professor) {
        Professor existente = buscarPorId(id);
        existente.setNome(professor.getNome());
        existente.setEmail(professor.getEmail());
        return professorRepository.save(existente);
    }

    public void remover(Long id) {
        Professor existente = buscarPorId(id);
        professorRepository.delete(existente);
    }
}
