package br.edu.biblioteca.repository.jpa;

import br.edu.biblioteca.domain.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
}
