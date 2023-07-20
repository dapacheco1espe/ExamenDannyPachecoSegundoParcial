package ec.edu.espe.arquitectura.examen.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.examen.controller.dto.EmpleadoPagoRQ;
import ec.edu.espe.arquitectura.examen.controller.dto.PagoRolRQ;
import ec.edu.espe.arquitectura.examen.model.EmpleadoPago;
import ec.edu.espe.arquitectura.examen.model.PagoRol;
import ec.edu.espe.arquitectura.examen.repository.PagoRolRepository;

@Service
public class PagoRolService {
    private final PagoRolRepository pagoRolRepository;

    public PagoRolService(PagoRolRepository pagoRolRepository){
        this.pagoRolRepository = pagoRolRepository;
    }

    public void createRolDePagos(PagoRolRQ pagoRolrq){
        PagoRol pagoRol = this.transformRolDePagoRQ(pagoRolrq);
        PagoRol pagoRolTmp = this.pagoRolRepository.findByMesAndRucEmpresaAndFechaProceso(pagoRol.getMes(), pagoRol.getRucEmpresa(), pagoRol.getFechaProceso());
        if(pagoRolTmp == null){
            pagoRol.setValorTotal(this.sumAllValuesOfSueldos(pagoRol.getEmpleadosPago()));
            this.pagoRolRepository.save(pagoRol);
        }else{
            throw new RuntimeException("El rol de pagos que intenta ingresar ya existe");
        }
    }
    private PagoRol transformRolDePagoRQ(PagoRolRQ rq){
        PagoRol pagoRol =  PagoRol.builder()
                            .mes(rq.getMes())
                            .fechaProceso(rq.getFechaProceso())
                            .rucEmpresa(rq.getRucEmpresa())
                            .valorTotal(new BigDecimal(0))
                            .valorReal(new BigDecimal(0))
                            .empleadosPago(this.transformEmpleadosListEmpleadosPagoRQ(rq.getEmpleadosPago()))
                            .build();
        return pagoRol;
    }

    private List<EmpleadoPago> transformEmpleadosListEmpleadosPagoRQ(List<EmpleadoPagoRQ> listrq){
        List<EmpleadoPago> empleadosPago = new ArrayList<EmpleadoPago>();
        for(EmpleadoPagoRQ tempEmpleadoPagoRQ : listrq){
            EmpleadoPago tempEmpleadoPago = EmpleadoPago.builder()
                                    .numeroCuenta(tempEmpleadoPagoRQ.getNumeroCuenta())
                                    .valor(tempEmpleadoPagoRQ.getValor())
                                    .estado("PEN")
                                    .build();
            empleadosPago.add(tempEmpleadoPago);
        }
        return empleadosPago;
    }

    private BigDecimal sumAllValuesOfSueldos(List<EmpleadoPago> list){
        BigDecimal valorTotal = new BigDecimal(0);
        for(EmpleadoPago tempEmpleadoPago : list){
            valorTotal = valorTotal.add(tempEmpleadoPago.getValor());
        }
        return valorTotal;
    }
}
