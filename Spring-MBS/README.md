Addon de Firefox RESTClient

Descargar SpringTest.java

navegar a la ruta en el cmd: java -jar SpringTest.jar

Metodos de turnos>
Consultar Todos los Turnos de un negocio por id:
Metodo GET : http://localhost:8080/manager/total/appointments?id=1234

Consultar libres Turnos de un negocio por id:
Metodo GET : http://localhost:8080/manager/free/appointments?id=1234

Motodos de usuarios>
Validar: Usuario por correo:contraseña
Metodo POST : URL: http://localhost:8080/validate?email=martin@mail.com&string=prueba123

Buscar: Usuario por correo
Metodo GET : URL: http://localhost:8080/find?email=martin@mail.com

Agregar: Usuario
Metodo POST : URL: http://localhost:8080/register

Content-Type: application/json

        {
            "nombre": "Martin",
            "apellido": "Diaz",
            "telefono": "54 11 44315780",
            "dni": "27093141",
            "mail": "martin@mail.com",
            "contraseña":"prueba123"
            "sexo": "M",
            "fechDeNacimiento": "06/03/1979",
            "address":
            [
                {
                    "pais": "Argentina",
                    "provincia": "CABA",
                    "barrio": "Caballito",
                    "direccion": "direccion larga"
                },
                {
                    "pais": "Argentina",
                    "provincia": "CABA",
                    "barrio": "Flore",
                    "direccion": "direccion larga 2"
                }
            ]
        }







