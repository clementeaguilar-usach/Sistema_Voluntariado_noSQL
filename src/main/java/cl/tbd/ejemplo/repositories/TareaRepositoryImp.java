package cl.tbd.ejemplo.repositories;

import cl.tbd.ejemplo.models.Emergencia;
import cl.tbd.ejemplo.models.Tarea;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class TareaRepositoryImp implements TareaRepository {

    @Autowired
    MongoDatabase database;

    @Override
    public Tarea createTarea(Tarea tarea) {
        MongoCollection<Tarea> collection = database.getCollection("tareas", Tarea.class);
        collection.insertOne(tarea);
        return tarea;
    }

    @Override
    public List<Document> getTareas() {
        MongoCollection<Tarea> collection = database.getCollection("tareas", Tarea.class);

        List<Bson> pipeline = Arrays.asList(new Document("$lookup",
                new Document("from", "estados")
                        .append("localField", "estado")
                        .append("foreignField", "descripcion")
                        .append("as", "estado")));



        List <Document> tareas = collection.aggregate(pipeline, Document.class).into(new ArrayList<>());

        return tareas;
    }

    @Override
    public Document getTarea2(ObjectId idTarea) {
        MongoCollection<Tarea> collection = database.getCollection("tareas", Tarea.class);

        List<Bson> pipeline = Arrays.asList(new Document("$match",
                        new Document("_id", idTarea)),
                new Document("$lookup",
                        new Document("from", "estados")
                                .append("localField", "estado")
                                .append("foreignField", "descripcion")
                                .append("as", "estado")));

        Document tarea = collection.aggregate(pipeline, Document.class).first();
        return tarea;
    }

    @Override
    public Document getTarea(ObjectId idTarea){
        MongoCollection<Document> collection = database.getCollection("tarea");
        Document filtro = new Document("_id", idTarea);
        return collection.find(filtro).first();
    }

    @Override
    public void deleteTarea(ObjectId idTarea) {
        MongoCollection<Document> tareaCollection = database.getCollection("tareas");
        Document filtro = new Document("_id", idTarea);
        tareaCollection.deleteOne(filtro);
    }

    @Override
    public void updateTarea(Tarea tarea){
        MongoCollection<Tarea> collection = database.getCollection("tareas", Tarea.class);
        // Crear el filtro para buscar la emergencia por su ID
        Document filtro = new Document("_id", tarea.getId());

        // Campos a actualizar
        Bson update = Updates.combine(
                Updates.set("nombre", tarea.getNombre()),
                Updates.set("descripcion", tarea.getDescripcion()),
                Updates.set("fechaInicio", tarea.getFechaInicio()),
                Updates.set("fechaFin", tarea.getFechaFin()),
                Updates.set("voluntariosRequeridos", tarea.getVoluntariosRequeridos()),
                Updates.set("voluntariosInscritos", tarea.getVoluntariosInscritos()),
                Updates.set("estado", tarea.getEstado()),
                Updates.set("habilidades", tarea.getHabilidades())
        );

        // Realizar la actualización
        collection.findOneAndUpdate(filtro, update);
    }
}
