package com.project.detranapi.controller;

import com.project.detranapi.model.Licenciamento;
import com.project.detranapi.repository.LicenciamentoRepository;
import com.project.detranapi.service.LicenciamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/licenciamento")
public class LicenciamentoController {

    private final LicenciamentoRepository licenciamentoRepository;

    private final LicenciamentoService licenciamentoService;

    public LicenciamentoController(LicenciamentoRepository licenciamentoRepository, LicenciamentoService licenciamentoService) {
        this.licenciamentoRepository = licenciamentoRepository;
        this.licenciamentoService = licenciamentoService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/atribuir")
    public Licenciamento Atribuir
            (@RequestBody Licenciamento data) {
        return licenciamentoService.atribuir(data);
    }

}
