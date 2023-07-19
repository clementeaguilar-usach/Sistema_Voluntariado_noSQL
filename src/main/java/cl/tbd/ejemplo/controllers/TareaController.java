package cl.tbd.ejemplo.controllers;

import cl.tbd.ejemplo.models.Tarea;
import cl.tbd.ejemplo.services.TareaService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TareaController {
    private final TareaService tareaService;

    @PostMapping("/tareas")
    public ResponseEntity<?> createTarea(@RequestBody Tarea tarea){
        return new ResponseEntity<>(tareaService.createTarea(tarea), HttpStatus.OK);
    }

    @GetMapping("/tareas")
    public ResponseEntity<?> getTareas(){
        return new ResponseEntity<>(tareaService.getTareas(), HttpStatus.OK);
    }

    @GetMapping("/tareas/{id}")
    public ResponseEntity<?> getTareas(@PathVariable ObjectId id){
        return new ResponseEntity<>(tareaService.getTarea(id), HttpStatus.OK);
    }

    @PutMapping("/tareas/{id}")
    public ResponseEntity<?> updateTarea(@PathVariable ObjectId id, @RequestBody Tarea tarea){
        tarea.setId(id);
        tareaService.updateTarea(tarea);
        return new ResponseEntity<>("Tarea actualizada con éxito", HttpStatus.OK);
    }

    @DeleteMapping("/tareas/{id}")
    public ResponseEntity<?> deleteTarea(@PathVariable ObjectId id){
        tareaService.deleteTarea(id);
        return new ResponseEntity<>("Tarea eliminada con éxito", HttpStatus.OK);
    }
}
