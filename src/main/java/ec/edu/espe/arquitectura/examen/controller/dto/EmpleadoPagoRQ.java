package ec.edu.espe.arquitectura.examen.controller.dto;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
@AllArgsConstructor
public class EmpleadoPagoRQ {
    private String numeroCuenta;
    private BigDecimal valor;
    public EmpleadoPagoRQ(){}
}
