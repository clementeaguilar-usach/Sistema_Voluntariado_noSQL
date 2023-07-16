package cl.tbd.ejemplo.repositories;

import cl.tbd.ejemplo.models.Tarea;

import java.util.List;

public interface TareaRepository {
    public Tarea createTarea(Tarea tarea);
    public List<Tarea> getTareas();
    public void setTarea(Tarea tarea);
    public void deleteTarea(String nombreTarea);
}
