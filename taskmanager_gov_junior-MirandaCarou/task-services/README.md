# Prueba técnica Imatia
# [task-services] https://github.com/

## Tabla de Contenidos
- Funcionalidades implementadas de base en el servicio.
- Decisiones tomadas en el desarrollo. 
- Procedimientos de instalación y ejecución.
- Ejemplos de la API.

## Funcionalidades implementadas de base en el servicio

Las funcionalidades implementadas de base son: 
- Una operación para obtener una tarea por defecto.

La base de datos utilizada es H2 en memoria, es decir, una vez que tiremos el servicio dejarán de existir los registros
que fuesen creados. En el fichero src/main/resources/tasks.sql se dispone del script con los datos con los que queremos
que arranque el servicio.

## Decisiones tomadas en el desarrollo
A cubrir por el candidato.

## Procedimientos de instalación y ejecución
Una vez descargado el proyecto, debemos de cumplir los siguientes requisitos:
- Tener Java 11 instalado.
- Tener Maven a partir de la version 3.6.0 instalado.

Posteriormente, habrá que ejcutar el comando "mvn clean install" desde la consola
de comandos estando en el directorio raiz del proyecto.

Finalmente, entrar en el directorio "../target" del proyecto y ejecutar el comando
"java -jar Calculator-0.0.1-SNAPSHOT.jar".

Con ello debería de levantarse el servicio. 
Para obtener las peticiones disponibles del mismo: http://localhost:8080/v3/api-docs/

## Ejemplos de la API
**http://localhost:8080/task/default**
- Body respuesta:
{
  "idTask": "da75a13a-aa95-11ec-b909-0242ac120002",
  "name": "Tarea por defecto",
  "creationDate": "2022-03-16T23:00:00.000+0000"
}
