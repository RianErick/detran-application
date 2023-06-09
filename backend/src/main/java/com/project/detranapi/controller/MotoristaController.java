package com.project.detranapi.controller;



import com.project.detranapi.model.Motorista;
import com.project.detranapi.repository.MotoristaRepository;
import com.project.detranapi.service.MototristaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/motoristas")
public class MotoristaController {

    private final MotoristaRepository motoristaRepository;
    private final MototristaService motoristaService;

    public MotoristaController(
              MotoristaRepository motoristaRepository
            , MototristaService motoristaService)    {

        this.motoristaRepository = motoristaRepository;
        this.motoristaService = motoristaService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cadastro")
    public Motorista cadastrarMotorista
            (@Valid @RequestBody Motorista data ){
        return motoristaService.cadastrarMotorista(data);
    }
    @GetMapping("/listar")
    public List<Motorista> listarMotoristas(){
        return motoristaRepository.findAll();
    }

    @GetMapping("/buscar/cpf/{cpf}")
   public Motorista buscarMotoristaPeloCpf(String cpf){
        return motoristaService.buscarMotoristaPeloCpf(cpf);
   }

}
