package ec.edu.espe.arquitectura.examen.controller.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class EmpresaRQ {
    private String ruc;
    private String razonSocial;
    private Boolean cuentaPrincipal;
    private List<EmpleadoRQ> empleados;
    public EmpresaRQ(){}
}
