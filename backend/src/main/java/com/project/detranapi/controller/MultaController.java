package com.project.detranapi.controller;

import com.project.detranapi.model.Multa;
import com.project.detranapi.model.Veiculo;
import com.project.detranapi.repository.MultaRepository;
import com.project.detranapi.service.MultaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/multa")
public class MultaController {


    private final MultaRepository multaRepository;
    private final MultaService multaService;

    public MultaController(MultaRepository multaRepository, MultaService multaService) {
        this.multaRepository = multaRepository;
        this.multaService = multaService;
    }

    @PostMapping("/atribuir")
    public Multa atribuirMulta(@RequestBody Multa multa) {

        return multaService.atribuirMulta(multa);
    }

    @GetMapping("buscar/{id}")
    public Multa buscarPorId(@PathVariable Long id) {

        return multaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Multa Erro"));

    }
    @GetMapping("/renavam/{renavam}")
    public Multa buscarPeloMultaDoVeiculo (@PathVariable String renavam) {
        return multaRepository.findMultaByRenavamVeiculo(renavam);
    }



}