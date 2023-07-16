package cl.tbd.ejemplo.services;

import cl.tbd.ejemplo.models.Dog;
import cl.tbd.ejemplo.models.Emergencia;
import cl.tbd.ejemplo.repositories.EmergenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
