package com.example.demo.Repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Reserva;

@Repository
public interface ReservaRepository extends BaseRepository<Reserva, Long>{

    @Query("""
       SELECT COUNT(r) <= 0     
       FROM Reserva r
       WHERE r.ambiente.id = :id
       AND r.ativo = true
       AND r.dataInicio < :dataFim
       AND r.dataFim > :dataInicio
    """)
    boolean temDisponibilidade(Long id, LocalDateTime dataInicio, LocalDateTime dataFim);

}
