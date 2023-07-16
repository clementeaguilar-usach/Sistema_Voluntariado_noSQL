package cl.tbd.ejemplo.repositories;

import cl.tbd.ejemplo.models.Emergencia;
import cl.tbd.ejemplo.models.Tarea;
import com.mongodb.client.AggregateIterable;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.tbd.ejemplo.models.Dog;

import javax.print.Doc;

import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.*;

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
    public List<Document> getTareasByEmergenciaId(ObjectId idEmergencia){
        MongoCollection<Emergencia> collection = database.getCollection("emergencias",  Emergencia.class);
        // Filtrar por el ID de emergencia
        Bson matchStage = match(eq("_id", idEmergencia));

        // Realizar el primer lookup con la colección "tareas"
        Bson lookupTareasStage = lookup("tareas", "tareas", "_id", "tareas_info");

        // Desenrollar el array resultante
        Bson unwindTareasStage = unwind("$tareas_info");

        // Realizar el segundo lookup con la colección "estados"
        Bson lookupEstadosStage = lookup("estados", "tareas_info.estado", "descripcion", "tareas_info.estado_info");

        // Desenrollar el array resultante
        Bson unwindEstadosStage = unwind("$tareas_info.estado_info");

        // Filtrar las tareas con estado "activa"
        Bson matchEstadoStage = match(eq("tareas_info.estado_info.descripcion", "activa"));

        // Proyectar el resultado final
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

        // Agregar las etapas al pipeline de agregación
        List<Bson> pipeline = Arrays.asList(
                matchStage,
                lookupTareasStage,
                unwindTareasStage,
                lookupEstadosStage,
                unwindEstadosStage,
                matchEstadoStage,
                projectStage
        );

        // Ejecutar la agregación y obtener el resultado
        List<Document> results = collection.aggregate(pipeline, Document.class).into(new ArrayList<>());
        // Convertir el resultado en una lista de tareas
        return results;
    }
}