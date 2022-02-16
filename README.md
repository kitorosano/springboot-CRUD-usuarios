# springboot-CRUD-usuarios

Esto es una aplicacion de ejemplo que provee una API REST de usuarios

La aplicacion es un proyecto creado en Java utilizando Springboot como framework

## Ejecutar la app

    mvnw.cmd spring-boot:run

# API REST

La API REST de la aplicacion se explica a continuacion

## Obtener listado de usuarios

`GET /usuario`

    [(...)]

## Crear nuevo usuario

`POST /usuario/`


    [
        {"id":1,"name":"Foo","email":"foo@gmail.com","prioridad": 3},
        {"id": 2,"name":"Bar","email":"bar@gmail.com","prioridad": 5},
        (...)
    ]

## Obtener usuario en específico

`GET /usuario/{id}`

    {"id":1,"name":"Foo","email":"foo@gmail.com","prioridad": 3}

## Obtener usuario mediante ID

`GET /usuario/id`

    {"id":1,"name":"Foo","email":"foo@gmail.com","prioridad": 3}

## Obtener usuario mediante parametros

`GET /usuario/query?priodidad=3`

    [
        {"id":1,"name":"Foo","email":"foo@gmail.com","prioridad": 3},
    ]

`GET /usuario/query?nombre=Foo`

    [
        {"id":1,"name":"Foo","email":"foo@gmail.com","prioridad": 3},
    ]

`GET /usuario/query?email=foo@gmail.com`

    [
        {"id":1,"name":"Foo","email":"foo@gmail.com","prioridad": 3},
    ]

## Eliminar un usuario

`DELETE /usuario/id`

    "Se eliminó el usuario con id " + id
    
    "No se pudo eliminar el usuario con id " + id
