package ec.edu.espe.arquitectura.examen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.examen.controller.dto.EmpleadoRQ;
import ec.edu.espe.arquitectura.examen.controller.dto.EmpresaRQ;
import ec.edu.espe.arquitectura.examen.model.Empleado;
import ec.edu.espe.arquitectura.examen.model.Empresa;
import ec.edu.espe.arquitectura.examen.repository.EmpresaRepository;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }

    public void crearEmpresa(EmpresaRQ empresarq){
            Empresa empresaTransform = this.transformEmpresa(empresarq);
            Empresa empresaBusqueda = this.empresaRepository.findByRuc(empresaTransform.getRuc());
            if(empresaBusqueda == null){
                this.empresaRepository.save(empresaTransform);
            }else{
                throw new RuntimeException("Ya existe una empresa con este RUC");
            }
    }

    private Empresa transformEmpresa(EmpresaRQ rq){
        Empresa empresa =  Empresa.builder()
                            .ruc(rq.getRuc())
                            .razonSocial(rq.getRazonSocial())
                            .cuentaPrincipal(rq.getCuentaPrincipal())
                            .empleados(this.transformEmpleadosList(rq.getEmpleados()))
                            .build();
        return empresa;
    }

    private List<Empleado> transformEmpleadosList(List<EmpleadoRQ> listrq){
        List<Empleado> empleados = new ArrayList<Empleado>();
        for(EmpleadoRQ tempEmpleadoRQ : listrq){
            Empleado tempEmpleado = Empleado.builder()
                                    .cedulaIdentidad(tempEmpleadoRQ.getCedulaIdentidad())
                                    .apellidos(tempEmpleadoRQ.getApellidos())
                                    .nombres(tempEmpleadoRQ.getNombres())
                                    .numeroDeCuenta(tempEmpleadoRQ.getNumeroDeCuenta())
                                    .build();
            empleados.add(tempEmpleado);
        }
        return empleados;
    }
}
