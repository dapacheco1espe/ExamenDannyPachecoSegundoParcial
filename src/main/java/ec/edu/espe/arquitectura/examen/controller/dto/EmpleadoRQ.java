package ec.edu.espe.arquitectura.examen.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class EmpleadoRQ {
    private String cedulaIdentidad;
    private String apellidos;
    private String nombres;
    private String numeroDeCuenta;
    public EmpleadoRQ(){}
}
