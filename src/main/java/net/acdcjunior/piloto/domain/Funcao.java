package net.acdcjunior.piloto.domain;

import javax.persistence.*;

@Entity
@Table(name = "tb_funcao")
public class Funcao extends BaseEntity {

    @Column(length = 50, unique = true)
    private String nome;

    public void setNome(String nome) { this.nome = nome; }
    public String getNome() { return nome; }

}