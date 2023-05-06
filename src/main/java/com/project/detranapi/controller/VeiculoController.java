package com.project.detranapi.controller;

import com.project.detranapi.model.Veiculo;
import com.project.detranapi.repository.VeiculoRepository;
import com.project.detranapi.representation.VeiculoDTO;
import com.project.detranapi.service.VeiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    private VeiculoRepository veiculoRepository;

    private VeiculoService veiculoService;

    public VeiculoController(VeiculoRepository veiculoRepository, VeiculoService veiculoService) {
        this.veiculoRepository = veiculoRepository;
        this.veiculoService = veiculoService;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cadastrar")
    public Veiculo cadastrarVeiculo(@RequestBody Veiculo data){
       return veiculoService.salvarVeiculo(data);
    }
    @GetMapping("/buscar/renavan/{renavan}")
    public VeiculoDTO buscarVeiculoPeloRenavan(@PathVariable String renavan){
       Veiculo data = veiculoService.buscarVeiculoPeloRenavam(renavan);
        return VeiculoDTO.converterParaDTo(data);
    }


}
