package ec.edu.espe.arquitectura.examen.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Empleado {
    private String cedulaIdentidad;
    private String apellidos;
    private String nombres;
    private String numeroDeCuenta;
    public Empleado(){}
}
