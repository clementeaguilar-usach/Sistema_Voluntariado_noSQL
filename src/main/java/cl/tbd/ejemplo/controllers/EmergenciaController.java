package cl.tbd.ejemplo.controllers;

import cl.tbd.ejemplo.models.Emergencia;
import cl.tbd.ejemplo.services.EmergenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmergenciaController {
    private final EmergenciaService emergenciaService;

    @PostMapping("/emergencias")
    public Emergencia createEmergencia(@RequestBody Emergencia emergencia){
        return emergenciaService.createEmergencia(emergencia);
    }

}
