package cl.tbd.ejemplo.services;

import cl.tbd.ejemplo.models.Emergencia;
import cl.tbd.ejemplo.models.Tarea;
import cl.tbd.ejemplo.repositories.EmergenciaRepository;
import cl.tbd.ejemplo.repositories.TareaRepository;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TareaService {
    private final TareaRepository tareaRepository;
    private final EmergenciaRepository emergenciaRepository;
    private final EmergenciaService emergenciaService;
    public Tarea createTarea(Tarea tarea) {
        try{
            Tarea nuevaTarea =  tareaRepository.createTarea(tarea);

            Document emergencia = emergenciaRepository.getEmergencia(tarea.getEmergencia());
            System.out.println(emergencia);
            List<ObjectId> nuevasTareas = emergencia.getList("tareas", ObjectId.class);
            nuevasTareas.add(nuevaTarea.getId());
            Emergencia nuevaEmergencia = new Emergencia();
            nuevaEmergencia.setId(tarea.getEmergencia());
            nuevaEmergencia.setTareas(nuevasTareas);
            emergenciaService.updateEmergencia(nuevaEmergencia);
            return nuevaTarea;
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Document> getTareas() {
        try {
            return tareaRepository.getTareas();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Document getTarea(ObjectId id) {
        try {
            return tareaRepository.getTarea2(id);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void updateTarea(Tarea nuevaTarea) {
        try{
            Document tareaActual = tareaRepository.getTarea(nuevaTarea.getId());
            if(nuevaTarea.getNombre() == null){
                nuevaTarea.setNombre(tareaActual.getString("nombre"));
            }
            if(nuevaTarea.getDescripcion() == null){
                nuevaTarea.setDescripcion(tareaActual.getString("descripcion"));
            }
            if(nuevaTarea.getFechaInicio() == null){
                nuevaTarea.setFechaInicio(tareaActual.getDate("fechaInicio"));
            }
            if(nuevaTarea.getFechaFin() == null){
                nuevaTarea.setFechaFin(tareaActual.getDate("fechaFin"));
            }
            if(nuevaTarea.getEstado() == null){
                nuevaTarea.setEstado(tareaActual.getString("estado"));
            }
            if(nuevaTarea.getHabilidades() == null){
                nuevaTarea.setHabilidades(tareaActual.getList("habilidades", ObjectId.class));
            }
            if(nuevaTarea.getVoluntariosRequeridos() == null){
                nuevaTarea.setVoluntariosRequeridos(tareaActual.getInteger("voluntariosRequeridos"));
            }
            if(nuevaTarea.getVoluntariosInscritos() == null){
                nuevaTarea.setVoluntariosInscritos(tareaActual.getInteger("voluntariosInscritos"));
            }
            tareaRepository.updateTarea(nuevaTarea);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteTarea(ObjectId id) {
        try{
            tareaRepository.deleteTarea(id);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
