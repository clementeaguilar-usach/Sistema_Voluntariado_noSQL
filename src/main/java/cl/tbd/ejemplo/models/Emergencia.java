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
    Institucion institucion;
    List<Habilidad> habilidades;
    List<Tarea> tareas;

    public ObjectId getId() {
        return this._id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

    public String getStringId(){
        return this._id.toString();
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

    public Institucion getInstitucion() { return this.institucion; }

    public void setInstitucion(Institucion institucion) { this.institucion = institucion; }

    public List<Habilidad> getHabilidades() { return this.habilidades; }

    public void setHabilidades(List<Habilidad> habilidades) { this.habilidades = habilidades; }

    public List<Tarea> getTareas() { return this.tareas; }

    public void setTareas(List<Tarea> tareas) { this.tareas = tareas; }
}