// Importamos el cliente de MongoDB
const MongoClient = require('mongodb').MongoClient;

// Definimos la URL de conexión a MongoDB
const url = "mongodb://localhost:27017/";

// Creamos una nueva instancia del cliente de MongoDB
const client = new MongoClient(url, { useNewUrlParser: true, useUnifiedTopology: true });

client.connect(err => {
  if (err) throw err;

  // Creamos la base de datos "voluntariado"
  const db = client.db("voluntariado");

  // Creamos la colección "emergencias"
  db.createCollection("emergencias", function(err, res) {
    if (err) throw err;
    console.log("Colección 'emergencias' creada");
  });

  // Creamos la colección "tareas"
  db.createCollection("tareas", function(err, res) {
    if (err) throw err;
    console.log("Colección 'tareas' creada");
  });

  // Cerramos la conexión
  client.close();
});
