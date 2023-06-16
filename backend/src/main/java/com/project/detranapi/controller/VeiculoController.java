package com.project.detranapi.controller;

import com.project.detranapi.model.Veiculo;
import com.project.detranapi.repository.VeiculoRepository;
import com.project.detranapi.representation.VeiculoDTO;
import com.project.detranapi.service.VeiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    private final VeiculoRepository veiculoRepository;
    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoRepository veiculoRepository, VeiculoService veiculoService) {
        this.veiculoRepository = veiculoRepository;
        this.veiculoService = veiculoService;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cadastrar")
    public Veiculo cadastrarVeiculo(@Valid @RequestBody Veiculo data){
       return veiculoService.salvarVeiculo(data);

    }
    @GetMapping("/buscar/renavan/{renavan}")
    public VeiculoDTO buscarVeiculoPeloRenavan(@PathVariable String renavan){
       var data = veiculoService.buscarVeiculoPeloRenavam(renavan);
        return VeiculoDTO.converterParaDTo(data);

    }
    @GetMapping("/listar")
    public List <VeiculoDTO> listarVeiculos(){
       var data = veiculoRepository.findAll();
       return VeiculoDTO.converterListaDTo(data);


    }
    @GetMapping("/listar/todos")
    public List <Veiculo> listarVeiculosInteiros(){
       return veiculoRepository.findAll();

    }

    @PutMapping("/editar/renavam/{renavam}")
    public ResponseEntity <Veiculo> editarInfoVeiculo
      (@Valid @PathVariable String renavam , @RequestBody Veiculo veiculo){
       return veiculoService.editarVeiculo(renavam,veiculo);

    }
    @DeleteMapping("/deletar/renavam/{renavam}")
    public ResponseEntity <Void> deletarVeiculo
            (@PathVariable String renavam){

        return veiculoService.deletarVeiculo(renavam);
    }




}
