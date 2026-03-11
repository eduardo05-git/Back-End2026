package com.itb.inf2am.Zeroum.model.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 18, unique = true, nullable = false)
    private String cnpj;

    @Column(length = 300, nullable = false)
    private String informacao;

    @Column(length = 8, nullable = false)
    private String cep;

    @Column(length = 10, nullable = false)
    private String numero;

    @Column(name = "webSite", length = 50)
    private String webSite;

    @Column(length = 20, nullable = false)
    private String telefone;

    @Column(name = "dataCadastro", nullable = false)
    private LocalDateTime dataCadastro;

    @Column(name = "statusEmpresa", length = 20, nullable = false)
    private String statusEmpresa;

    // Getters e Setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getInformacao() { return informacao; }
    public void setInformacao(String informacao) { this.informacao = informacao; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getWebSite() { return webSite; }
    public void setWebSite(String webSite) { this.webSite = webSite; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }

    public String getStatusEmpresa() { return statusEmpresa; }
    public void setStatusEmpresa(String statusEmpresa) { this.statusEmpresa = statusEmpresa; }
}