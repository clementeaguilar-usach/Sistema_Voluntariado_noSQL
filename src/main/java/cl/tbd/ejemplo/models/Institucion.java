package cl.tbd.ejemplo.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.List;

public class Institucion {
    @BsonId
    ObjectId _id;
    String nombre;
    String descripcion;
    //List<Coordinador> coordinadores;
    //List<Emergencia> emergencias;

    public ObjectId get_id() { return this._id; }
    public void set_id(ObjectId _id) { this._id = _id; }

    public String getNombre() { return this.nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return this.descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    //public List<Coordinador> getCoordinadores() { return this.coordinadores; }
    //public void setCoordinadores(List<Coordinador> coordinadores) { this.coordinadores = coordinadores; }

    //public List<Emergencia> getEmergencias() { return this.emergencias; }
    //public void setEmergencias(List<Emergencia> emergencias) { this.emergencias = emergencias; }
}
