package com.example.demo.Controller;

import com.example.demo.DTO.AmbienteDTO;
import com.example.demo.DTO.RecursoDTO;
import com.example.demo.Service.AmbienteService;
import com.example.demo.Service.RecursoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recursos")
public class RecursoController extends BaseController<RecursoDTO> {

  private AmbienteService ambienteService;

  public RecursoController(AmbienteService ambienteService, RecursoService service) {
    super(service);
    this.ambienteService = ambienteService;
  }

  @GetMapping("/listagem/{resourceId}")
  public List<AmbienteDTO> findByResource(@PathVariable Long resourceId){
    return ambienteService.findByResource(resourceId);
  }

}
