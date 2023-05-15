package com.project.detranapi.controller;

import com.project.detranapi.model.CarteiraHabilitacao;
import com.project.detranapi.repository.CarteiraRepository;
import com.project.detranapi.representation.CarteiraDTO;
import com.project.detranapi.service.CarteiraService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/cnh")
@RestController
public class CarteiraController {

    private final CarteiraRepository carteiraRepository;
    private final CarteiraService carteiraService;


    public CarteiraController(CarteiraRepository carteiraRepository,
                              CarteiraService carteiraService) {
        this.carteiraRepository = carteiraRepository;
        this.carteiraService = carteiraService;
    }

    @PostMapping("/criar")
    public CarteiraHabilitacao gerar(
            @RequestBody CarteiraHabilitacao carteiraHabilitacao) {
        return carteiraService.cadastro(carteiraHabilitacao);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("atualizar/cnh/{cnh}/multa/{id}")
    public CarteiraDTO atualizarProntuario(@PathVariable String cnh
            , @PathVariable Long id) {
        return carteiraService.atualizarProntuario(cnh, id);
    }

}
