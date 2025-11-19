package com.example.demo.DTO;

import com.example.demo.Entity.Recurso;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AmbienteDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank(message = "O campo nome deve ser preenchido")
    private String nome;

    @NotBlank(message = "O campo descrição deve ser preenchido")
    private String descricao;

    @NotBlank(message = "O campo localização deve ser preenchido")
    private String localizacao;

    @NotNull(message = "O campo capacidade deve ser preenchido")
    private int capacidade;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Recurso> recursos;

}
