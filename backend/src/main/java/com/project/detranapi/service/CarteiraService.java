package com.project.detranapi.service;

import com.project.detranapi.model.CarteiraHabilitacao;
import com.project.detranapi.representation.CarteiraDTO;

public interface CarteiraService {
    CarteiraHabilitacao cadastro (CarteiraHabilitacao carteiraHabilitacao);

    CarteiraDTO atualizarProntuario(String cnh ,Long id);
}
