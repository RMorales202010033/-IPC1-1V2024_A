# COMANDOS PARA LA CREACIÓN DE PROYECTOS EN REACT :D

## FORMA 1 PARA CREAR PROYECTO DE REACT:

### - Crear proyecto de react usando Vite
Para poder crear un nuevo proyecto en react debemos colocar lo siguiente:
```node
npm create vite@latest
```
- Cuando solicite el nombre del proyecto, colocar cualquiera, pero en minúsculas o solo colocar el "." para hacer referencia a la carpeta actual.
- Seleccionar el framework que se desea utilizar, en nuestro caso se usará: React. Para seleccionar react, moverse con las flechitas y al tenerlo, darle enter.
- Seleccionar como lenguaje: Javascript.

Una vez se haya creado nuestro nuevo proyecto, deberemos ejecutar los siguientes comandos:
```node
npm install
npm run dev
```
Este último comando se encargará de iniciar nuestra aplciación de react, abriendo su puerto por defecto.

## FORMA 2 PARA CREAR PROYECTO DE REACT:

### - Instalar create-react-app
Luego de tener instalado node js y npm desde su sitio oficial, necesitamos instalar create-react-app para poder crear un nuevo proyecto de react. Para instalar debemos colocar el siguiente comando:
```node
npm install -g create-react-app
```

### - Crear nuevo proyecto de react
Para poder crear un nuevo proyecto en react debemos colocar el siguiente comando y esperar a que instale todas las dependencias:
```node
npx create-react-app nombre-del-proyecto
```
El nombre del proyecto debe ir en minúsculas.

## DEPENDENCIAS A UTILIZAR:

### - Instalar las siguientes dependencias para no tener error en nuestra aplicación
```node
// Dependencia para poder usar en enrutador
npm i react-router-dom
// Dependencia para poder usar cookies en el navegador
npm i react-cookie
// Dependencia para usar estilos de react-bootstrap
npm i react-bootstrap
```

### - Utilizar Bootstrap en nuestra aplicación para darle estilos
En nuestro proyecto de react debemos colocar la CDN la cual se obtiene de la página oficial de bootstrap, para eso debemos ir a la carpeta ```public``` luego buscar el archivo index.html y colocar la cdn dentro de la etiqueta ```<head>```. La CDN es la siguiente:
```html
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
https://getbootstrap.com/
```

## REFERENCIAS:

### - Documentación de Bootstrap y react-bootstrap

- https://react-bootstrap.netlify.app/docs/components/modal/

- https://getbootstrap.com/docs/4.0/content/tables/
