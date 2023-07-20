package ec.edu.espe.arquitectura.examen.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.examen.controller.dto.EmpresaRQ;
import ec.edu.espe.arquitectura.examen.service.EmpresaService;

@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController {
    private final EmpresaService empresaService;
    
    public EmpresaController(EmpresaService empresaService){
        this.empresaService = empresaService;
    }

    @PostMapping 
    public ResponseEntity<String> createClient(@RequestBody EmpresaRQ empresaRQ) {
        try {
            this.empresaService.crearEmpresa(empresaRQ);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        } 
    } 
}
