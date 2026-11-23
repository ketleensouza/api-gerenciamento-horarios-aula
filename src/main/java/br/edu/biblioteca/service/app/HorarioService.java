package br.edu.biblioteca.service.app;

import br.edu.biblioteca.domain.Horario;
import br.edu.biblioteca.dto.HorarioRequest;
import br.edu.biblioteca.repository.jpa.HorarioRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class HorarioService {

    private final HorarioRepository horarioRepository;
    private final ProfessorService professorService;
    private final TurmaService turmaService;

    public HorarioService(HorarioRepository horarioRepository,
                          ProfessorService professorService,
                          TurmaService turmaService) {
        this.horarioRepository = horarioRepository;
        this.professorService = professorService;
        this.turmaService = turmaService;
    }

    public List<Horario> listar() {
        return horarioRepository.findAll();
    }

    public Horario buscarPorId(Long id) {
        return horarioRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Horario nao encontrado: " + id));
    }

    public Horario criar(HorarioRequest request) {
        Horario horario = new Horario();
        aplicarDados(horario, request);
        return horarioRepository.save(horario);
    }

    public Horario atualizar(Long id, HorarioRequest request) {
        Horario existente = buscarPorId(id);
        aplicarDados(existente, request);
        return horarioRepository.save(existente);
    }

    public void remover(Long id) {
        Horario existente = buscarPorId(id);
        horarioRepository.delete(existente);
    }

    public List<Horario> listarPorProfessor(Long professorId) {
        professorService.buscarPorId(professorId);
        return horarioRepository.findByProfessorIdOrderByDiaSemanaAscHoraInicioAsc(professorId);
    }

    public List<Horario> listarPorTurma(Long turmaId) {
        turmaService.buscarPorId(turmaId);
        return horarioRepository.findByTurmaIdOrderByDiaSemanaAscHoraInicioAsc(turmaId);
    }

    private void aplicarDados(Horario horario, HorarioRequest request) {
        horario.setDiaSemana(request.getDiaSemana());
        horario.setHoraInicio(request.getHoraInicio());
        horario.setHoraFim(request.getHoraFim());
        horario.setProfessor(professorService.buscarPorId(request.getProfessorId()));
        horario.setTurma(turmaService.buscarPorId(request.getTurmaId()));
    }
}
