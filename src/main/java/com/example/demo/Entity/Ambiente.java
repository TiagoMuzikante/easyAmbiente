package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ambiente")
@EqualsAndHashCode(callSuper = false)
public class Ambiente extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String localizacao;

    @Column(nullable = false)
    private int capacidade = 1;

    @Column(nullable = true)
    @ManyToMany
    @JoinTable(name = "ambiente_recurso", joinColumns = @JoinColumn(name = "ambiente_id"), inverseJoinColumns = @JoinColumn(name = "recurso_id"))
    private Set<Recurso> recursos;

    public void addResource(Recurso resource){
        this.recursos.add(resource);
    }

}
