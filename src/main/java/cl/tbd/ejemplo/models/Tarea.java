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
    Estado estado;
    //List<Habilidad> habilidades;
    //Emergencia emergencia;

    public ObjectId get_id() { return this._id; }
    public void set_id(ObjectId _id) { this._id = _id; }

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

    public Estado getEstado() { return this.estado; }
    public void setEstado(Estado estado) { this.estado = estado; }

    //public List<Habilidad> getHabilidades() { return this.habilidades; }
    //public void setHabilidades(List<Habilidad> habilidades) { this.habilidades = habilidades; }

    //public Emergencia getEmergencia() { return this.emergencia; }
    //public void setEmergencia(Emergencia emergencia) { this.emergencia = emergencia; }

    public Document toDocument() {
        Document document = new Document();
        document.append("nombre", this.nombre);
        document.append("descripcion", this.descripcion);
        document.append("voluntariosRequeridos", this.voluntariosRequeridos);
        document.append("voluntariosInsrcitos", this.voluntariosInscritos);
        document.append("fechaInicio", this.fechaInicio);
        document.append("fechaFin", this.fechaFin);
        document.append("estado", this.estado);
        //document.append("habilidades", this.habilidades);
        //document.append("emergencia", this.emergencia);
        return document;
    }
}
