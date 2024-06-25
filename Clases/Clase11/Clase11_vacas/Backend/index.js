// Dependencias a utilizar
const fs = require('fs');
const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');

//Creacion del backend usando el framework express
const app = express();
// Especificar el puerto en el cual queremos que se abra nuestro servidor (backend)
const PORT = 5000;
// Nombre del archivo que nos dará persistencia de datos
const FILENAME = 'Usuarios.json';
const FILENAME1 = 'Posts.json';

// Especificarle al framework que vamos a usar el bodyParser los cors
app.use(bodyParser.json());
app.use(cors());

// Simulacion de Base datos de ejemplo
let dataStudents = [];
let dataPosts = [];

// Verificar y crear archivo si no existe
if (!fs.existsSync(FILENAME)) {
    fs.writeFileSync(FILENAME, JSON.stringify(dataStudents));
} else {
    // Si el archivo existe, cargar los datos
    const fileData = fs.readFileSync(FILENAME, 'utf8');
    dataStudents = JSON.parse(fileData);
}

// Verificar y crear archivo si no existe (publicaciones)
if (!fs.existsSync(FILENAME1)) {
    fs.writeFileSync(FILENAME1, JSON.stringify(dataPosts));
} else {
    // Si el archivo existe, cargar los datos (publicaciones)
    const fileData = fs.readFileSync(FILENAME1, 'utf8');
    dataPosts = JSON.parse(fileData);
}

// Función que ayuda a actualizar el contenido del archivo json
function updateDataFile() {
    fs.writeFileSync(FILENAME, JSON.stringify(dataStudents));
}

// Función que ayuda a actualizar el contenido del archivo json de publicaciones
function updateDataFile1() {
    fs.writeFileSync(FILENAME1, JSON.stringify(dataPosts));
}



// Estructura para recibir peticiones:
// app = variable con la que creamos nuestro backend haciendo uso del framework express
// .Tipo de metodo = GET, POST, PUT, DELETE
// "/url" = Endpoint que se quiere consultar
// req = recibe los parametros que vienen por parte del cliente
// res = se encarga de responder al cliente

// Creando un endpoint sencillo que retorne un mensaje
app.get("/", (req, res) => {
    let saludo = {
        Saludo: "Hola mundo!",
        infoAdicional: "Ejemplo de valor de la clave infoAdicional"
    };
    res.json(saludo);
});

// Endpoint el cual retorna todos los posts almacenados
app.get('/getPosts', (req, res) => {
    res.json(dataPosts);
});

// Endpoint el cual retorna todos los estudiantes almacenados
app.get("/students", (req, res) => {
    res.json(dataStudents)
});

// Endpoint el cual retorna un estudiante en especifico a partir de su carnet
// /:carnet es un parametro el cual no conocemos su valor, es una manera dinamica de obtener valores
app.get("/students/:carnet", (req, res) => {
    // Obtenemos el carnet que viene en los parametros de la url
    const carnet = parseInt(req.params.carnet, 10);

    // Buscamos en la lista si existe algun objeto json con ese carnet, si no existe nos retorna null = false
    // y si encuentra algun objetos con este carnet nos retorna el objeto
    const student = dataStudents.find(student => student.carnet === carnet);
    if (!student) {
        // Si no se encuentra retornamos este mensaje
        res.status(404).send({ response: 'Usuario no encontrado' });
    } else {
        // Si encuentra al estudiante retorna el objeto json con su info
        res.json(student);
    }
});


// Endpoint en el cual guardamos un nuevo estudiante, la info se manda en el body en formato json
app.post("/students", (req, res) => {
    // Guardamos el cuerpo de la peticion
    const newStudent = req.body;
    // Agregamos el estudiante a la lista
    dataStudents.push(newStudent);
    updateDataFile();
    // Brindamos un mensaje de confirmacion
    res.status(201).send({ response: "Elemento creado correctamente." })
});

// Endpoint en el cual guardamos una nueva publicacion, la info se manda en el body en formato json
app.post('/createPost', (req, res) => {
    // Guardamos el cuerpo de la peticion
    const newPost = req.body;
    const savePost = {
        id: (dataPosts.length + 1),
        description: newPost.description,
        image: newPost.image,
        name: newPost.name
    };
    // Agregamos el estudiante a la lista
    dataPosts.push(savePost);
    updateDataFile1();
    // Brindamos un mensaje de confirmacion
    res.status(201).send({ response: 'Publicacion guardada correctamente.' });
});

// Endpoint en el cual recibimos los datos del usuario que se quiere loggear, se valida si el usuario existe o no
// en el array de usuarios y también se valida que su password sea correcto
app.post('/login', (req, res) => {
    const data = req.body;
    console.log(data)
    const student = dataStudents.find(student => {
        console.log(student.carnet)
        console.log(student.password)
        if (student.carnet === data.carnet && student.password === data.password) {
            return student
        }
    });
    if (!student) {
        const response = {
            success: false,
            user: null
        }
        res.status(404).send(response);
    } else {
        const response = {
            success: true,
            user: student
        }
        res.json(response);
    }
});

// Endpoint con el cual actualizaremos los atributos de un objeto, menos su carnet
app.put("/students/:carnet", (req, res) => {
    // Obtenemos el carnet del objeto que se va a actualizar
    const carnet = parseInt(req.params.carnet, 10);
    // Obtenemos el cuerpo de la peticion en el cual vienen los nuevos valores
    const updatedStudent = req.body;
    // Obtenemos el indice de la lista en donde se encuentra el objeto con el carnet
    const index = dataStudents.findIndex(student => student.carnet === carnet);
    // Si no existe el objeto nos retorna un -1
    if (index === -1) {
        res.status(404).send({ response: 'Usuario no encontrado' });
    } else {
        // Si se encontro el objeto, editamos sus atributos haciendo uso del indice
        dataStudents[index].nombre = updatedStudent.nombre;
        dataStudents[index].apellido = updatedStudent.apellido;
        dataStudents[index].edad = updatedStudent.edad;
        updateDataFile();
        res.send({ response: 'Usuario actualizado correctamente' });
    }
});

// Endpoint con el cual se eliminar un estudiante en especifico
app.delete('/students/:carnet', (req, res) => {
    // Obtenemosel carnet del objeto que se va a actualizar
    const carnet = parseInt(req.params.carnet, 10);
    // Obtenemos el indice de la lista en donde se encuentra el objeto con el carnet
    const index = dataStudents.findIndex(student => student.carnet === carnet);
    if (index === -1) {
        res.status(404).send({ mensaje: 'Usuario no encontrado' });
    } else {
        // Eliminamos el objeto
        dataStudents.splice(index, 1);
        updateDataFile();
        res.send({ mensaje: 'Usuario eliminado correctamente' });
    }
});

app.listen(PORT, () => {
    console.log(`Servidor escuchando en el puerto: ${PORT}`);
})