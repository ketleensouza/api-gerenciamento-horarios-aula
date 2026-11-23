package br.edu.biblioteca.repository.jpa;

import br.edu.biblioteca.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
