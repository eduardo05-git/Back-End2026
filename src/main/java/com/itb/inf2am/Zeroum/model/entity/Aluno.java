package com.itb.inf2am.Zeroum.model.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 10, unique = true, nullable = false)
    private String rm;

    @Column(length = 50, nullable = false)
    private String curso;

    @Column(length = 20, nullable = false)
    private String conclusao;

    @Lob
    @Column(name = "curriculo")
    private byte[] curriculo;

    @Column(name = "bio", length = 500)
    private String bio;

    @Column(name = "habilidades", length = 300)
    private String habilidades;

    @Column(name = "linkPortfolio", length = 255)
    private String linkPortfolio;

    @Column(name = "linkCurriculo", length = 255)
    private String linkCurriculo;

    @Column(name = "dataNascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "dataCadastro", nullable = false)
    private LocalDateTime dataCadastro;

    @Column(name = "statusAluno", length = 20, nullable = false)
    private String statusAluno;


    // Getters e Setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getRm() { return rm; }
    public void setRm(String rm) { this.rm = rm; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public String getConclusao() { return conclusao; }
    public void setConclusao(String conclusao) { this.conclusao = conclusao; }

    public byte[] getCurriculo() { return curriculo; }
    public void setCurriculo(byte[] curriculo) { this.curriculo = curriculo; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }

    public String getStatusAluno() { return statusAluno; }
    public void setStatusAluno(String statusAluno) { this.statusAluno = statusAluno; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public String getHabilidades() { return habilidades; }
    public void setHabilidades(String habilidades) { this.habilidades = habilidades; }

    public String getLinkPortfolio() { return linkPortfolio; }
    public void setLinkPortfolio(String linkPortfolio) { this.linkPortfolio = linkPortfolio; }

    public String getLinkCurriculo() { return linkCurriculo; }
    public void setLinkCurriculo(String linkCurriculo) { this.linkCurriculo = linkCurriculo; }
}