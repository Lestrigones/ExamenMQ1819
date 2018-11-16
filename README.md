# examqt1819
construyan un nuevo servicio con las siguientes características:
- Añadir usuarios al sistema.   // usurio
- Obtener información sobre los usuarios.// info usuario
- Mostrar las bicicletas disponibles. // productos


PARTE I: 6 puntos
1. Implementación de la fachada (MyBike.java): MyBikeImpl.java
1.1. Las estructuras de datos que se deben utilizar serán las siguientes:
● Array para almacenar las estaciones (objeto [])//estaciones 
● LinkedList para guardar las bicicletas de una estación.//
● HashMap para almacenar los usuarios.//usuarios
● LinkedList para almacenar las bicicletas de un usuario//listado pedidos realizados
1.2. La Fachada se implementará como un patrón Singleton.
1.3. Todas las operaciones tendrán registros de depuración (LOG4J) al principio y al final de cada una.
Registros de operación y error cuando se lanzan las excepciones.
1.4. Integración en una prueba JUNIT proporcionada

PARTE II: 4 puntos
1. Implementar un servicio REST (utilizando las bibliotecas de Jersey) que permita mostrar el
operaciones de la fachada: addUser, addStation, addBike, bikesByStationOrderByKms,
GetBike, bicicletasByUser. Definir las rutas y métodos HTP para cada operación.
2. Agregue las anotaciones swagger en el servicio REST y genere la documentación


NOTA:
- No está permitido el uso de "System.out.println"
- Debes utilizar la herramienta Maven para gestionar las bibliotecas.
- La entrega se debe realizar en un repositorio Github y cargar un archivo de texto en la tarea Atenea con
la URL del representante
