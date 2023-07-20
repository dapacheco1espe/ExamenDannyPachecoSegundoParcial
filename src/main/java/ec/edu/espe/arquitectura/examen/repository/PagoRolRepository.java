package ec.edu.espe.arquitectura.examen.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.arquitectura.examen.model.PagoRol;

public interface PagoRolRepository extends MongoRepository<PagoRol,String>{
    PagoRol findByMesAndRucEmpresaAndFechaProceso(Integer mes,String ruc, Date fechaProceso);
}
