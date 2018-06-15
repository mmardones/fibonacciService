# fibonacciService

Desarrollo:

El servicio está hecho en spring boot  java 1.8 y Gradle.

Cuenta con la clase main que ejecuta la aplicación  “FibonacciRestServiceApplication”.

- FibobacciController que expone el servicio a internet, en él se encuentra el servicio "servicioFibonacci" que utiliza método GET y en su Header debe contener un Token.

-FibonacciException permite entregar un mensaje personalizado al cliente.

-FibonacciService dispone el método Fibonacci para que otras clases o servicios puedan utilizar.

-TokenService dispone el método de validateToken para identificar el cliente y permitir la utilización del servicio.

Para seguridad es necesario enviar en el header el Token definido por el proveedor del servicio.

Dependecia:

Utiliza la librería “org.springframework.boot:spring-boot-starter-web”

Ejecución:

-Para la ejecución es necesario tener instalado java 8 de 32bit o 64bit.

 -Tener disponible el puerto 8080.

-Es necesario ingresar a la ruta: https://github.com/mmardones/fibonacciService , debe descargar y ejecutar el siguiente comando para compitar el proyecto:

Window : G:\workspaceSpring\FibonacciService>gradlew build

Linux:  ruta  ./gradlew build

Comando para Ejecutar la aplicación:

Window  G:\workspaceSpring\FibonacciService>gradlew run

Linux:  ruta  ./gradlew run

Utilización Servicio:

Ingresar la URL : http://localhost:8080/api/servicioFibonacci/  en la aplicación Postman

Ingresar como un Integer de entrada como en la siguiente url : http://localhost:8080/api/servicioFibonacci/23

Ingresar el Token en el header :

Key: token

Value: 2CX56733221DA21SQE11DTB5H
