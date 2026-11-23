package br.edu.biblioteca.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TurmaRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String semestre;

    @NotNull
    private Long disciplinaId;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Long getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Long disciplinaId) {
        this.disciplinaId = disciplinaId;
    }
}
