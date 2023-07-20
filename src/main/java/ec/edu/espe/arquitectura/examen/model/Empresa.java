package ec.edu.espe.arquitectura.examen.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Document(collection = "empresas")
public class Empresa {
    @Id
    private String id;
    @Indexed(unique = true)
    private String ruc;
    private String razonSocial;
    private Boolean cuentaPrincipal;
    private List<Empleado> empleados;
    public Empresa(){}

}
