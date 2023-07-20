package ec.edu.espe.arquitectura.examen.service;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.examen.repository.ValidacionPagoRolRepository;

@Service
public class ValidacionPagoRolService {
    private final ValidacionPagoRolRepository pagoRolRepository;

    public ValidacionPagoRolService(ValidacionPagoRolRepository pagoRolRepository){
        this.pagoRolRepository = pagoRolRepository;
    }

}
