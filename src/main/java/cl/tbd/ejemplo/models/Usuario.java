package cl.tbd.ejemplo.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.List;

public class Usuario {
    @BsonId
    ObjectId _id;
    String nombre;
    String apellido;
    String email;
    String password;
    List<Rol> roles;
    Coordinador coordinador;
    Voluntario voluntario;

    public ObjectId get_id() { return this._id; }
    public void set_id(ObjectId _id) { this._id = _id; }

    public String getNombre() { return this.nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return this.apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEmail() { return this.email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return this.password; }
    public void setPassword(String password) { this.password = password; }

    public List<Rol> getRoles() { return this.roles; }
    public void setRoles(List<Rol> roles) { this.roles = roles; }

    public Coordinador getCoordinador() { return this.coordinador; }
    public void setCoordinador(Coordinador coordinador) { this.coordinador = coordinador; }

    public Voluntario getVoluntario() { return this.voluntario; }
    public void setVoluntario(Voluntario voluntario) { this.voluntario = voluntario; }
}
