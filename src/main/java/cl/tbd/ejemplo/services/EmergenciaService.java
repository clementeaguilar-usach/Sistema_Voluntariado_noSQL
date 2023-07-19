package cl.tbd.ejemplo.services;

import cl.tbd.ejemplo.models.Emergencia;
import cl.tbd.ejemplo.repositories.EmergenciaRepository;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
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

    public List<Document> getTareasActivasByEmergenciaId(ObjectId idEmergencia) {
        try{
            return emergenciaRepository.getTareasActivasByEmergenciaId(idEmergencia);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void updateEmergencia(Emergencia nuevaEmergencia) {
        try{
            Document emergenciaActual = emergenciaRepository.getEmergencia(nuevaEmergencia.getId());
            if(nuevaEmergencia.getNombre() == null){
                nuevaEmergencia.setNombre(emergenciaActual.getString("nombre"));
            }
            if(nuevaEmergencia.getDescripcion() == null){
                nuevaEmergencia.setDescripcion(emergenciaActual.getString("descripcion"));
            }
            if(nuevaEmergencia.getFechaInicio() == null){
                nuevaEmergencia.setFechaInicio(emergenciaActual.getDate("fechaInicio"));
            }
            if(nuevaEmergencia.getFechaFin() == null){
                nuevaEmergencia.setFechaFin(emergenciaActual.getDate("fechaFin"));
            }
            if(nuevaEmergencia.getTareas() == null){
                nuevaEmergencia.setTareas(emergenciaActual.getList("tareas", ObjectId.class));
            }
            if(nuevaEmergencia.getHabilidades() == null){
                nuevaEmergencia.setHabilidades(emergenciaActual.getList("habilidades", ObjectId.class));
            }
            if(nuevaEmergencia.getInstitucion() == null){
                nuevaEmergencia.setInstitucion(emergenciaActual.getObjectId("institucion"));
            }
            emergenciaRepository.updateEmergencia(nuevaEmergencia);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Document getEmergencia(ObjectId id) {
        try {
            return emergenciaRepository.getEmergencia2(id);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteEmergencia(ObjectId id) {
        try{
            emergenciaRepository.deleteEmergencia(id);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Document> getEmergencias(){
        try{
            return emergenciaRepository.getEmergencias();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
