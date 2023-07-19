package cl.tbd.ejemplo.repositories;

import cl.tbd.ejemplo.models.Emergencia;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;

public interface EmergenciaRepository {
    Document getEmergencia(ObjectId idEmergencia);
    Emergencia createEmergencia(Emergencia emergencia);
    void updateEmergencia(Emergencia emergencia);

    List<Document> getTareasActivasByEmergenciaId(ObjectId idEmergencia);

    Document getEmergencia2(ObjectId id);
    List<Document> getEmergencias();
    void deleteEmergencia(ObjectId id);
//    public List<Emergencia> getEmergencias();
}
