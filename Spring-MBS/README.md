Validar: Usuario por correo:contraseña
Metodo POST : URL: http://localhost:8080/validate?email=martin@mail.com&string=prueba123

Buscar: Usuario por correo
Metodo GET : URL: http://localhost:8080/find?email=martin@mail.com

Agregar: Usuario
Metodo POST : URL: http://localhost:8080/register
Headers Remove All
Content-Type: application/json×

        {
            "nombre": "Martin",
            "apellido": "Diaz",
            "telefono": "54 11 44315780",
            "dni": "27093141",
            "mail": "martin@mail.com",
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







