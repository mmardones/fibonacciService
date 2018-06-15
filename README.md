# fibonacciService

Desarrollo

	El servicio está hecho en spring boot  java 1.8 y Gradle.

	Cuenta con la clase main que ejecuta la aplicación  “FibonacciRestServiceApplication”.

	- FibobacciController que expone el servicio a internet, en él se encuentra el servicio "servicioFibonacci" que utiliza método GET y en su Header debe contener un Token.

	-FibonacciException permite entregar un mensaje personalizado al cliente.

	-FibonacciService dispone el método Fibonacci para que otras clases o servicios puedan utilizar.

	-TokenService dispone el método de validateToken para identificar el cliente y permitir la utilización del servicio.

	Para seguridad es necesario enviar en el header el Token definido por el proveedor del servicio.

Dependecia:

	Utiliza la librería “org.springframework.boot:spring-boot-starter-web”

Installation

	-Para la ejecución es necesario tener instalado java 8 de 32bit o 64bit.

1.- Puerto y Endpoint

		Puerto: 8080 
		Endpoint: http://localhost:8000/api/servicioFibonacci/{numero}

2.- Instalación

	Descargar repositorio https://github.com/mmardones/fibonacciService
	
	Linux:
	1.- Ubicarse en carpeta del proyecto /fibonacciService
	2.- Compilar
	/fibonacciService$ ./gradlew build

	3.- Ejecutar APP
	/fibonacciService$ java -jar build/libs/FibonacciRestService-0.0.1-SNAPSHOT.jar

	Windows:
	1.- Ubicarse en carpeta del proyecto /fibonacciService
	2.- Compilar
	/fibonacciService/ gradlew build
	3.- Ejecutar APP
	/fibonacciService/ java -jar build/libs/FibonacciRestService-0.0.1-SNAPSHOT.jar
	
3.- Test:

	Linux:
	1.- Test OK:
	/fibonacciService$ curl -X GET -H "token: 2CX56733221DA21SQE11DTB5H" http://localhost:8080/api/servicioFibonacci/23
	Respuesta: 7

	2.- Test Error:
	/fibonacciService$ curl -X GET -H "token: 2CX56733221DA21SQE11DTB5H" http://localhost:80080/api/servicioFibonacci/-1
	Respuesta: {"timestamp":"2018-06-15T21:05:09.738+0000","status":500,"error":"Internal Server Error","message":"Debes ingresar un tamaño mayor o igual a 1","path":"/api/servicioFibonacci/-1"}

Utilización Servicio:

	Ingresar la URL : http://localhost:8080/api/servicioFibonacci/  en la aplicación Postman

	Ingresar como un Integer de entrada como en la siguiente url : http://localhost:8080/api/servicioFibonacci/23

	Ingresar el Token en el header :

	Key: token

	Value: 2CX56733221DA21SQE11DTB5H
