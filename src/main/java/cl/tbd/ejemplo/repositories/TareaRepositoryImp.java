package cl.tbd.ejemplo.repositories;

import cl.tbd.ejemplo.models.Tarea;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TareaRepositoryImp {

    @Autowired
    MongoDatabase database;

    @Override
    public Tarea createTarea(Tarea tarea) {
        MongoCollection<Tarea> collection = database.getCollection("tarea", Tarea.class);
        collection.insertOne(tarea);
        return tarea;
    }

    @Override
    public List<Tarea> getTareas() {
        MongoCollection<Tarea> collection = database.getCollection("tarea", Tarea.class);
        List <Tarea> tareas = collection.find().into(new ArrayList<>());
        return tareas;
    }

    @Override
    public void setTarea(Tarea tarea) {
        MongoCollection<Tarea> collection = database.getCollection("tarea", Tarea.class);
        Document filtro = new Document("nombre", tarea.getNombre());
        Document newTarea = new Document("$set", tarea.toDocument());
        collection.updateOne(filtro, newTarea);
    }

    @Override
    public void deleteTarea(String nombreTarea) {
        MongoCollection<Document> tareaCollection = database.getCollection("tarea");
        Document filtro = new Document("nombre", nombreTarea);
        tareaCollection.deleteOne(filtro);
    }
}
