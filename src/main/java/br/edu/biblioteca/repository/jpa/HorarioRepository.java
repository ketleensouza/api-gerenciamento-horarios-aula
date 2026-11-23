package br.edu.biblioteca.repository.jpa;

import br.edu.biblioteca.domain.Horario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepository extends JpaRepository<Horario, Long> {

    List<Horario> findByProfessorIdOrderByDiaSemanaAscHoraInicioAsc(Long professorId);

    List<Horario> findByTurmaIdOrderByDiaSemanaAscHoraInicioAsc(Long turmaId);
}
