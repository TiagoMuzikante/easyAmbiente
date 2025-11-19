package com.example.demo.Service;

import com.example.demo.Entity.Recurso;
import com.example.demo.Repository.RecursoRepository;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.AmbienteDTO;
import com.example.demo.Entity.Ambiente;
import com.example.demo.Repository.AmbienteRepository;

import java.util.List;

@Service
public class AmbienteService extends BaseService<Ambiente, AmbienteDTO>{

  private AmbienteRepository repository;
  private RecursoRepository recursoRepository;

  protected AmbienteService(RecursoRepository recursoRepository, AmbienteRepository repository){
    super(repository);
    this.repository = repository;
    this.recursoRepository = recursoRepository;
  }

  public List<AmbienteDTO> findByResource(Long resourceId){
    Recurso recurso = recursoRepository.findById(resourceId).orElseThrow(() -> new RuntimeException("Recurso não encontrado"));

    return recurso.getAmbientes().stream().map(this::toDto).toList();
  }

  public void implementResource(Long ambienteId, Long resourceId){
    Ambiente ambiente = repository.findById(ambienteId).orElseThrow(() -> new RuntimeException("Ambiente não encontrado."));
    Recurso recurso = recursoRepository.findById(resourceId).orElseThrow(() -> new RuntimeException("Recurso não encontrado"));

    ambiente.addResource(recurso);
    repository.save(ambiente);
  }


  public void delete(Long id){
    boolean reservado = repository.temReservaFutura(id);

    if(reservado){
        throw new IllegalStateException("Ambiente possui reservas futuras e não pode ser excluído.");
    }

    super.delete(id);
  }



}
