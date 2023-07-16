package cl.tbd.ejemplo.repositories;

import cl.tbd.ejemplo.models.Emergencia;
import cl.tbd.ejemplo.models.Tarea;
import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import javax.print.Doc;
import java.util.List;

public interface EmergenciaRepository {
    public Emergencia createEmergencia(Emergencia emergencia);

    public List<Document> getTareasByEmergenciaId(ObjectId idEmergencia);
//    public List<Emergencia> getEmergencias();
}
