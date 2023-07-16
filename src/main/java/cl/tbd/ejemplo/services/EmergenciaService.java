package cl.tbd.ejemplo.services;

import cl.tbd.ejemplo.models.Dog;
import cl.tbd.ejemplo.models.Emergencia;
import cl.tbd.ejemplo.models.Tarea;
import cl.tbd.ejemplo.repositories.EmergenciaRepository;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmergenciaService {
    private final EmergenciaRepository emergenciaRepository;

    public Emergencia createEmergencia(Emergencia emergencia){
        try{
            return emergenciaRepository.createEmergencia(emergencia);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Document> getTareasByEmergenciaId(ObjectId idEmergencia) {
        try{
            return emergenciaRepository.getTareasByEmergenciaId(idEmergencia);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
