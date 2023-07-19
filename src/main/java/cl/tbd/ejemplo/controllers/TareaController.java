package cl.tbd.ejemplo.controllers;

import cl.tbd.ejemplo.models.Tarea;
import cl.tbd.ejemplo.services.TareaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TareaController {
    private final TareaService tareaService;

    @PostMapping("/crearTarea")
    public Tarea createTarea(@RequestBody Tarea tarea){
        return tareaService.createTarea(tarea);
    }
}
