package cl.tbd.ejemplo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

public class Emergencia {
    @BsonId
    ObjectId _id;
    String nombre;
    String descripcion;
    Date fechaInicio;
    Date fechaFin;
    ObjectId institucion;
    List<ObjectId> habilidades;
    List<ObjectId> tareas;

    public ObjectId getId() {
        return this._id;
    }
    public void setId(ObjectId id) {
        this._id = id;
    }

    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() { return this.fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public Date getFechaFin() { return this.fechaFin; }
    public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }

    public List<ObjectId> getTareas() { return this.tareas; }
    public void setTareas(List<ObjectId> tareas) { this.tareas = tareas; }

    public ObjectId getInstitucion() {
        return institucion;
    }

    public void setInstitucion(ObjectId institucion) {
        this.institucion = institucion;
    }

    public List<ObjectId> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<ObjectId> habilidades) {
        this.habilidades = habilidades;
    }
}