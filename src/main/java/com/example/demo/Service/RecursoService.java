package com.example.demo.Service;

import com.example.demo.DTO.RecursoDTO;
import com.example.demo.Entity.Recurso;
import com.example.demo.Repository.RecursoRepository;
import org.springframework.stereotype.Service;

@Service
public class RecursoService extends BaseService<Recurso, RecursoDTO> {

  private RecursoRepository repository;

  public RecursoService(RecursoRepository repository) {
    super(repository);
    this.repository = repository;
  }

}
