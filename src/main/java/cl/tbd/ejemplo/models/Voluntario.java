package cl.tbd.ejemplo.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.List;

public class Voluntario {
    @BsonId
    ObjectId _id;
    Usuario usuario;
    Integer puntaje;
    List<Tarea> tareas;
    List<Habilidad> habilidades;

    public ObjectId get_id() { return this._id; }
    public void set_id(ObjectId _id) { this._id = _id; }

    public Usuario getUsuario() { return this.usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Integer getPuntaje() { return this.puntaje; }
    public void setPuntaje(Integer puntaje) { this.puntaje = puntaje; }

    public List<Tarea> getTareas() { return this.tareas; }
    public void setTareas(List<Tarea> tareas) { this.tareas = tareas; }

    public List<Habilidad> getHabilidades() { return this.habilidades; }
    public void setHabilidades(List<Habilidad> habilidades) {this.habilidades = habilidades; }
}
