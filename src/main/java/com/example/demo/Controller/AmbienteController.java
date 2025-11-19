package com.example.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.AmbienteDTO;
import com.example.demo.Service.AmbienteService;

@RestController
@RequestMapping("/ambientes")
public class AmbienteController extends BaseController<AmbienteDTO> {

    private AmbienteService service;

    protected AmbienteController(AmbienteService service){
        super(service);
        this.service = service;
    }

    @PatchMapping("/recursos/{ambienteId}/{recursoId}")
    public ResponseEntity<Void> implementResource(@PathVariable(required = true) Long ambienteId, @PathVariable(required = true) Long recursoId){
        service.implementResource(ambienteId, recursoId);
        return ResponseEntity.ok().build();
    }

}
