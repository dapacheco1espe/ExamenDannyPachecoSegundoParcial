package ec.edu.espe.arquitectura.examen.controller.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PagoRolRS {
    private Integer mes;
    private String rucEmpresa;
    private Boolean cuentaPrincipal;
    private BigDecimal valorTotal;
    private BigDecimal valorReal;
    private Integer totalTransacciones;
    private Integer errores;
    public PagoRolRS(){}
}
