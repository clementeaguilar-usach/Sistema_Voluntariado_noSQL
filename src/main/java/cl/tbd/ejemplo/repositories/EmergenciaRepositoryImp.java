package cl.tbd.ejemplo.repositories;

import cl.tbd.ejemplo.models.Emergencia;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.print.Doc;

import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.eq;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository {

    @Autowired
    MongoDatabase database;
    @Override
    public Emergencia createEmergencia(Emergencia emergencia) {
        MongoCollection<Emergencia> collection = database.getCollection("emergencias", Emergencia.class);
        collection.insertOne(emergencia);
        return emergencia;
    }

    @Override
    public List<Document> getTareasActivasByEmergenciaId(ObjectId idEmergencia){
        MongoCollection<Emergencia> collection = database.getCollection("emergencias",  Emergencia.class);

        Bson matchStage = match(eq("_id", idEmergencia));

        Bson lookupTareasStage = lookup("tareas", "tareas", "_id", "tareas_info");

        Bson unwindTareasStage = unwind("$tareas_info");

        Bson lookupEstadosStage = lookup("estados", "tareas_info.estado", "descripcion", "tareas_info.estado_info");

        Bson unwindEstadosStage = unwind("$tareas_info.estado_info");

        Bson matchEstadoStage = match(eq("tareas_info.estado_info.descripcion", "activa"));

        Bson projectStage = project(
                new Document("_id", "$tareas_info._id")
                        .append("nombre", "$tareas_info.nombre")
                        .append("descripcion", "$tareas_info.descripcion")
                        .append("estado", "$tareas_info.estado")
                        .append("fechaFin", "$tareas_info.fechaFin")
                        .append("fechaInicio", "$tareas_info.fechaInicio")
                        .append("volInscritos", "$tareas_info.volInscritos")
                        .append("volRequeridos", "$tareas_info.volRequeridos")
                        .append("estado_info", "$tareas_info.estado_info")
        );

        // Agregar las etapas al pipeline
        List<Bson> pipeline = Arrays.asList(
                matchStage,
                lookupTareasStage,
                unwindTareasStage,
                lookupEstadosStage,
                unwindEstadosStage,
                matchEstadoStage,
                projectStage
        );

        //Realizar agregación y transformar resultado en una lista.
        List<Document> results = collection.aggregate(pipeline, Document.class).into(new ArrayList<>());

        return results;
    }

    @Override
    public void updateEmergencia(Emergencia emergencia) {
        MongoCollection<Emergencia> collection = database.getCollection("emergencias", Emergencia.class);
        // Crear el filtro para buscar la emergencia por su ID
        Document filtro = new Document("_id", emergencia.getId());

        // Campos a actualizar
        Bson update = Updates.combine(
                Updates.set("nombre", emergencia.getNombre()),
                Updates.set("descripcion", emergencia.getDescripcion()),
                Updates.set("fechaInicio", emergencia.getFechaInicio()),
                Updates.set("fechaFin", emergencia.getFechaFin()),
                Updates.set("tareas", emergencia.getTareas()),
                Updates.set("habilidades", emergencia.getHabilidades()),
                Updates.set("institucion", emergencia.getInstitucion())
        );

        // Realizar la actualización
        collection.findOneAndUpdate(filtro, update);
    }

    @Override
    public Document getEmergencia(ObjectId idEmergencia){
        MongoCollection<Document> collection = database.getCollection("emergencias");
        Document filtro = new Document("_id", idEmergencia);
        return collection.find(filtro).first();
    }

    @Override
    public Document getEmergencia2(ObjectId idEmergencia){
        MongoCollection<Emergencia> collection = database.getCollection("emergencias", Emergencia.class);
        List<Bson> pipeline = Arrays.asList(new Document("$match",
                        new Document("_id", idEmergencia)),
                new Document("$lookup",
                        new Document("from", "tareas")
                                .append("localField", "tareas")
                                .append("foreignField", "_id")
                                .append("as", "tareas")),
                new Document("$lookup",
                        new Document("from", "habilidades")
                                .append("localField", "habilidades")
                                .append("foreignField", "_id")
                                .append("as", "habilidades")),
                new Document("$lookup",
                        new Document("from", "instituciones")
                                .append("localField", "institucion")
                                .append("foreignField", "_id")
                                .append("as", "institucion")));

        Document emergencia = collection.aggregate(pipeline, Document.class).first();
        return emergencia;
    }

    @Override
    public void deleteEmergencia(ObjectId id) {
        MongoCollection<Emergencia> collection = database.getCollection("emergencias", Emergencia.class);
        // Crear el filtro para buscar la emergencia por su ID
        Document filtro = new Document("_id", id);

        // Realizar la actualización
        collection.deleteOne(filtro);
    }

    @Override
    public List<Document> getEmergencias(){
        MongoCollection<Emergencia> collection = database.getCollection("emergencias", Emergencia.class);
        List<Bson> pipeline = Arrays.asList(
                new Document("$lookup",
                        new Document("from", "tareas")
                                .append("localField", "tareas")
                                .append("foreignField", "_id")
                                .append("as", "tareas")),
                new Document("$lookup",
                        new Document("from", "habilidades")
                                .append("localField", "habilidades")
                                .append("foreignField", "_id")
                                .append("as", "habilidades")),
                new Document("$lookup",
                        new Document("from", "instituciones")
                                .append("localField", "institucion")
                                .append("foreignField", "_id")
                                .append("as", "institucion")));

        List<Document> emergencia = collection.aggregate(pipeline, Document.class).into(new ArrayList<>());
        return emergencia;
    };
}