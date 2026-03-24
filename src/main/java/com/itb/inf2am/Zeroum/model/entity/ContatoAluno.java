package com.itb.inf2am.Zeroum.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ContatoAluno")
public class ContatoAluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "aluno_id", nullable = false)
    private Integer alunoId;

    @Column(name = "nomeContato", length = 50, nullable = false)
    private String nomeContato;

    @Column(length = 200, nullable = false)
    private String link;

    // Getters e Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Integer alunoId) {
        this.alunoId = alunoId;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}