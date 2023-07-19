package cl.tbd.ejemplo.services;

import cl.tbd.ejemplo.models.Tarea;
import cl.tbd.ejemplo.repositories.TareaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TareaService {
    private final TareaRepository tareaRepository;

    public Tarea createTarea(Tarea tarea) {
        try{
            return tareaRepository.createTarea(tarea);
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
