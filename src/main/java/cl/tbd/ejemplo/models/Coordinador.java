package cl.tbd.ejemplo.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

public class Coordinador {
    @BsonId
    ObjectId _id;
    Institucion institucion;
    Usuario usuario;

    public ObjectId get_id() { return this._id; }
    public void set_id(ObjectId _id) { this._id = _id; }

    public Institucion getInstitucion() { return this.institucion; }
    public void setInstitucion(Institucion institucion) { this.institucion = institucion; }

    public Usuario getUsuario() { return this.usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
