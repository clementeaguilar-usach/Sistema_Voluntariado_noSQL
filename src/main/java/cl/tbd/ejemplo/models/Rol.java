package cl.tbd.ejemplo.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

public class Rol {
    @BsonId
    ObjectId _id;
    String nombre;

    public ObjectId get_id() { return this._id; }
    public void set_id(ObjectId _id) { this._id = _id; }

    public String getNombre() { return this.nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
