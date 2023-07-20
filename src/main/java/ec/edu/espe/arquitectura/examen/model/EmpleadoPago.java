package ec.edu.espe.arquitectura.examen.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@Builder
public class EmpleadoPago {
    private String numeroCuenta;
    private BigDecimal valor;
    private String estado;
    public EmpleadoPago(){}
}
