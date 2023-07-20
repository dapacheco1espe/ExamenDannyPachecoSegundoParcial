package ec.edu.espe.arquitectura.examen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.arquitectura.examen.model.PagoRol;

public interface ValidacionPagoRolRepository extends MongoRepository<PagoRol,String>{
    PagoRol findByMesAndRucEmpresaAnd(String mes, String ruc);
}
