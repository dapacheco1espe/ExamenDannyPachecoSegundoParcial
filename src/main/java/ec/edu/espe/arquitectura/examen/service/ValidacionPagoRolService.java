package ec.edu.espe.arquitectura.examen.service;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.examen.repository.PagoRolRepository;

@Service
public class ValidacionPagoRolService {
    private final PagoRolRepository pagoRolRepository;

    public ValidacionPagoRolService(PagoRolRepository pagoRolRepository){
        this.pagoRolRepository = pagoRolRepository;
    }

}
