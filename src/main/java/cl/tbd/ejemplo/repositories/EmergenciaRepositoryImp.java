package cl.tbd.ejemplo.repositories;

import cl.tbd.ejemplo.models.Emergencia;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.tbd.ejemplo.models.Dog;

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
}