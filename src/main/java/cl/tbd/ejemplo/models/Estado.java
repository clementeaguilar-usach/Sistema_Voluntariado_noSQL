package cl.tbd.ejemplo.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

public class Estado {
    @BsonId
    ObjectId _id;
    String descripcion;
    Tarea tarea;

    public ObjectId get_id() { return this._id; }
    public void set_id(ObjectId _id) { this._id = _id; }

    public String getDescripcion() { return this.descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Tarea getTarea() { return this.tarea; }
    public void setTarea(Tarea tarea) { this.tarea = tarea; }
}