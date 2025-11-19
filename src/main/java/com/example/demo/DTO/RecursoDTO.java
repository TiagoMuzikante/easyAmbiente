package com.example.demo.DTO;

import com.example.demo.Entity.Ambiente;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecursoDTO {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Long id;

  @NotBlank(message = "O nome deve ser preenchido.")
  private String nome;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private List<Ambiente> ambientes;


}
