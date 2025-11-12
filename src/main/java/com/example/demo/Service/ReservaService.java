package com.example.demo.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ReservaDTO;
import com.example.demo.Entity.Ambiente;
import com.example.demo.Entity.Reserva;
import com.example.demo.Repository.AmbienteRepository;
import com.example.demo.Repository.ReservaRepository;

@Service
public class ReservaService extends BaseService<Reserva, ReservaDTO>{

    ReservaRepository repository;

    @Autowired
    AmbienteRepository ambienteRepository;

    protected ReservaService(ReservaRepository repository){
        super(repository);
        this.repository = repository;
    }

    public ReservaDTO create(ReservaDTO dto) {
        //Verificar se o ambiente existe
        Ambiente ambiente = ambienteRepository.findById(dto.getAmbiente().getId())
            .orElseThrow(() -> new IllegalStateException("Ambiente não existe."));
        
        //Verificar se o ambiente está ativo
        if(!ambiente.isAtivo()){
            throw new IllegalStateException("O ambiente não está ativo.");
        }        

        //Verficiar se o ambiente tem horários sobrepostos
        boolean disponivel = repository.temDisponibilidade(
            ambiente.getId(), 
            dto.getDataInicio(), 
            dto.getDataFim()
        );

        if(!disponivel){
            throw new IllegalStateException("O ambiente já está ocupado.");
        }


        return super.create(dto);
    }

    public ReservaDTO update(Long id, ReservaDTO dto){
        Reserva reserva = repository.findById(id).orElseThrow(() -> new IllegalStateException("Reserva não encontrada."));

        if(reserva.getDataInicio().isBefore(LocalDateTime.now())){
            throw new IllegalStateException("Não pode, já iniciou");
        }

        return super.update(id, dto);
    }



}
