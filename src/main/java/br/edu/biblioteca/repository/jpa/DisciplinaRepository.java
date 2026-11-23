package br.edu.biblioteca.repository.jpa;

import br.edu.biblioteca.domain.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
