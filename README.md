# Documentacion ProyectoFinal_PrograAvanzada2017
========================================================
El proyecto final del curso de Programación Avanzada consistió en implementar los conocimientos adquiridos a lo largo del curso
para ello, la solución al enunciado requeria implementar las estructuras dinamicas vistas en clase: Lista enlazada simple, Lista circular 
enlazada, Lista doblemente enlazada y Arbol binario. De igual manera el problema pedía dos disciplinas de estructuras que son Pila y Cola 
que se implementaron usando polimorfismo haciendo que interfaces de estas dos disciplinas tomaran la forma de una lista enlazada simple.

Estas estructuras debían llenarse de manera automática al momento que el usuario ingresara un archivo de texto que debe cumplir con un formato especifico en el cual se indica el nombre de la estructura y así mismo los valores que van a ingresarse dentro de cada una. Dicho esto el archivo debe tener un formato como el del siguiente archivo:

![](https://image.ibb.co/ch3jCm/Text.png)

*Este archivo de texto fue utilizado para comprobar el funcionamiento del proyecto.

Así como las estructuras era automáticas, el enunciado también requeria representar de forma gráfica los datos ingresados y de manera que 
hicieran una ejemplificación de la estructura en la que estaban contenidos, para esto se utilizo la herramienta GraphViz que permitio de 
manera recursiva generar grafos capaces de cumplir con la solución del problema. Para dibujar las estructuras en la herramienta se 
utilizaron dos maneras distintas, primero mediante código directo con Java en el que se tomaron las estructuras de Pila y Cola que eran 
las más sencillas tomando los valores de la lista e ingresandolos en un arreglo que con el código podía ser representado facilmente. Por 
otro lado, las estructuras restantes tenían más complejidad ya que se referenciaban entre sí los nodos de estas por lo que para las 
Listas Enlazadas: Simple, Doble, Circular y Arbol Binario; se realizo un algoritmo recursivo que generara un archivo .dot en el que 
GraphViz fuera capaz de leer este numero archivo y en base a su contenido generar los grafos con los enlaces requeridos para cada nodo.

---------------------------------------
## Form1
Dentro del Form que se uso, el usuario ingresa la direccion del archivo de texto que desea leer para ingresar en las estructuras y así despues de leerlo con el botón que llena automaticamente las estructuras el usuario ingresa la direccion en donde desea que sean guardadas las imagenes generadas a partir de los datos.
![](https://image.ibb.co/ec1t56/Principal.png)

## Los Grafos generados a partir del archivo de prueba, quedaron de la siguiente manera:
### Cola
![](https://image.ibb.co/ezKrsm/Cola.png)
### Pila
![](https://image.ibb.co/f17Bsm/Pila.png)
### Lista enlazada simple
![](https://image.ibb.co/f3mnXm/grafo_Linked_List.png)
### Lista circular enlazada
![](https://image.ibb.co/kJMzdR/grafo_Circular.png)
### Lista doblemente enlazada
![](https://image.ibb.co/dacuCm/grafo_Doble.png)
### Arbol Binario
![](https://image.ibb.co/m4T6Q6/Arbol_Binario.png)
