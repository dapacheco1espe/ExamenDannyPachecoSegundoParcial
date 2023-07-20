package ec.edu.espe.arquitectura.examen.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Document(collection = "pagosRoles")
@Builder
public class PagoRol {
    @Id
    private String id;
    private Integer mes;
    private Date fechaProceso;
    private String rucEmpresa;
    private Boolean cuentaPrincipal;
    private BigDecimal valorTotal;
    private BigDecimal valorReal;
    private List<EmpleadoPago> empleadosPago;
    public PagoRol(){}
}
