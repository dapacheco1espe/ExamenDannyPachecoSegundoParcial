package ec.edu.espe.arquitectura.examen.controller.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PagoRolRQ {
    private Integer mes;
    private Date fechaProceso;
    private String rucEmpresa;
    private Boolean cuentaPrincipal;
    private List<EmpleadoPagoRQ> empleadosPago;
    public PagoRolRQ(){}
}
