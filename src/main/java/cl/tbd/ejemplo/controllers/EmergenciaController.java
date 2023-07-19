package cl.tbd.ejemplo.controllers;

import cl.tbd.ejemplo.models.Emergencia;
import cl.tbd.ejemplo.models.Tarea;
import cl.tbd.ejemplo.services.EmergenciaService;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmergenciaController {
    private final EmergenciaService emergenciaService;

    @PostMapping("/emergencias")
    public Emergencia createEmergencia(@RequestBody Emergencia emergencia){
        return emergenciaService.createEmergencia(emergencia);
    }

    @GetMapping("/emergencias/{id}/tareas")
    public List<Document> getTareasByEmergenciaId(@PathVariable ObjectId id){
        return emergenciaService.getTareasByEmergenciaId(id);
    }
}
