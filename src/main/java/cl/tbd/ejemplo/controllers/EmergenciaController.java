package cl.tbd.ejemplo.controllers;

import cl.tbd.ejemplo.models.Emergencia;
import cl.tbd.ejemplo.services.EmergenciaService;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/emergencias/{id}")
    public ResponseEntity<?> getEmergencia(@PathVariable ObjectId id){
        return new ResponseEntity<>(emergenciaService.getEmergencia(id), HttpStatus.OK);
    }

    @GetMapping("/emergencias")
    public ResponseEntity<?> getEmergencias(){
        return new ResponseEntity<>(emergenciaService.getEmergencias(), HttpStatus.OK);
    }

    @GetMapping("/emergencias/{id}/tareas")
    public List<Document> getTareasActivasByEmergenciaId(@PathVariable ObjectId id){
        return emergenciaService.getTareasActivasByEmergenciaId(id);
    }

    @PutMapping("/emergencias/{id}")
    public ResponseEntity<?> updateEmergencia(@PathVariable ObjectId id, @RequestBody Emergencia emergencia){
        emergencia.setId(id);
        emergenciaService.updateEmergencia(emergencia);
        return new ResponseEntity<>("Emergencia actualizada con éxito", HttpStatus.OK);
    }

    @DeleteMapping("/emergencias/{id}")
    public ResponseEntity<?> deleteEmergencia(@PathVariable ObjectId id){
        emergenciaService.deleteEmergencia(id);
        return new ResponseEntity<>("Emergencia eliminada con éxito", HttpStatus.OK);
    }
}
