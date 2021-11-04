# Indexacion-BD2-Java-GUI
Trabajo final BD2, uso de los árboles B+ para la búsqueda indexada y la diferencia en complejidad computacional con la búsqueda secuencial. Hecho en Java con Interfaz gráfica de usuario (GUI)

# DESCRIPCIÓN DEL PROBLEMA

Descripción:
Implemente una aplicación de escritorio en el lenguaje de su preferencia que permita evaluar la efectividad del uso de árboles B+ para indexar archivos y mejorar tiempos de respuesta a consultas.

### La aplicación debe permitir:
- Generar un archivo con N registros. N es un valor digitado por el usuario. En cada registro se almacena una pareja de números separada por un espacio. Los números se generan de forma aleatoria. El primer número representa un código único de búsqueda y el segundo número representa el valor asociado a ese código. El código es un número único mayor a cero y menor a un millón. El valor es un número mayor a cero y menor a 1 millón.
Ejemplo de datos almacenados en el archivo:

234 3456
145 45678
12 344556

- El archivo se puede generar las veces que el usuario desee.
- El usuario puede agregar un nuevo registro al archivo de forma manual **digitando el código y el valor en la    aplicación**.
- Cuando se inicie la aplicación, se verifica si ya se tiene un archivo generado. En caso de que exista, se construye un árbol B+ en memoria principal a partir de cada registro del archivo. La clave de los nodos del árbol corresponde a la clave de búsqueda y en los nodos hoja adicionalmente se almacena la posición de esa clave en el archivo. Si no existe el archivo, se crea el árbol inmediatamente después de que se genere el archivo usando la aplicación.
- Cada vez que se actualice el archivo se debe actualizar el índice.
- Con el fin de evaluar la efectividad del índice, se ofrecen dos opciones de búsqueda por código: "Búsqueda indexada" y "Búsqueda no indexada".
- Al usar la "Búsqueda indexada", mediante el índice se obtiene la posición del registro en el archivo. Con esta posición es posible moverse directamente al lugar del archivo donde se encuentra el producto y cargarlo en memoria. De esta manera se evita un recorrido secuencial sobre el archivo.
- Al usar la "Búsqueda no indexada" se hace una búsqueda secuencial en el archivo para encontrar el producto con el código introducido en la búsqueda. Junto al resultado de una búsqueda se debe mostrar el tiempo empleado. De esta manera, se podrá comparar el rendimiento de las consultas con ambas opciones.
- Cada nodo del árbol debe almacenar un máximo de 4 claves.

### Criterios de evaluación
#### Aplicación
1. Se evaluará el cumplimiento de todos los requisitos, aspectos de arquitectura y usabilidad.
2. Sustentación (Nota individual):
    - Ningún dominio de la aplicación y el tema: 0%
    - Poco dominio de la aplicación y el tema: 50%
    - Buen dominio de la aplicación y el tema con algunas deficiencias - 80%
    - Excelente dominio de la aplicación y el tema: 100%
*** La nota final se obtiene al multiplicar la nota de la aplicación por la nota de la sustentación. ***