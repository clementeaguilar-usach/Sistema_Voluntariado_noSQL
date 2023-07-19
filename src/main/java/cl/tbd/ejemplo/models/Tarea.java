package cl.tbd.ejemplo.models;

import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

public class Tarea {
    @BsonId
    ObjectId _id;
    String nombre;
    String descripcion;
    Integer voluntariosRequeridos;
    Integer voluntariosInscritos;
    Date fechaInicio;
    Date fechaFin;
    String estado;
    List<ObjectId> habilidades;
    ObjectId emergencia;
    public ObjectId getId() { return this._id; }
    public void setId(ObjectId _id) { this._id = _id; }

    public String getNombre() { return this.nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return this.descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Integer getVoluntariosRequeridos() { return this.voluntariosRequeridos; }
    public void setVoluntariosRequeridos(Integer volreq) { this.voluntariosRequeridos = volreq; }

    public Integer getVoluntariosInscritos() { return this.voluntariosInscritos; }
    public void setVoluntariosInscritos(Integer volinsc) { this.voluntariosInscritos = volinsc; }

    public Date getFechaInicio() { return this.fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public Date getFechaFin() { return this.fechaFin; }
    public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }

    public String getEstado() { return this.estado; }
    public void setEstado(String estado) { this.estado = estado; }


    public List<ObjectId> getHabilidades() { return this.habilidades; }
    public void setHabilidades(List<ObjectId> habilidades) { this.habilidades = habilidades; }

    public ObjectId getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(ObjectId emergencia) {
        this.emergencia = emergencia;
    }
}
