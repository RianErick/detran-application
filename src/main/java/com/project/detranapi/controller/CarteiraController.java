package com.project.detranapi.controller;

import com.project.detranapi.model.CarteiraHabilitacao;
import com.project.detranapi.repository.CarteiraRepository;
import com.project.detranapi.service.CarteiraService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            @RequestBody CarteiraHabilitacao carteiraHabilitacao){
        return  carteiraService.cadastro(carteiraHabilitacao);
    }


}
