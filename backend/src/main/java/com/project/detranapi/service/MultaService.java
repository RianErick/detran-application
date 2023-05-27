package com.project.detranapi.service;

import com.project.detranapi.controller.MultaController;
import com.project.detranapi.model.Multa;
import com.project.detranapi.representation.MultaDTO;

import java.util.List;

public interface MultaService {

    Multa atribuirMulta (Multa multa);

    List<MultaDTO> buscarMultaPeloRenavam(String renavam);



}
