package ec.edu.espe.arquitectura.examen.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.examen.controller.dto.PagoRolRQ;
import ec.edu.espe.arquitectura.examen.service.PagoRolService;

@RestController
@RequestMapping("/api/v1/rolpago")
public class PagoRolController {
    private final PagoRolService pagoRolService;
    
    public PagoRolController(PagoRolService pagoRolService){
        this.pagoRolService = pagoRolService;
    }

    @PostMapping 
    public ResponseEntity<String> createClient(@RequestBody PagoRolRQ pagoRolRQ) {
        try {
            this.pagoRolService.createRolDePagos(pagoRolRQ);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        } 
    } 
}
