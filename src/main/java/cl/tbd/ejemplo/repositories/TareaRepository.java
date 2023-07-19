package cl.tbd.ejemplo.repositories;

import cl.tbd.ejemplo.models.Tarea;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.print.Doc;
import java.util.List;

public interface TareaRepository {
    Tarea createTarea(Tarea tarea);
    List<Document> getTareas();

    void deleteTarea(ObjectId idTarea);

    Document getTarea2(ObjectId id);

    Document getTarea(ObjectId id);

    void updateTarea(Tarea tarea);
}
