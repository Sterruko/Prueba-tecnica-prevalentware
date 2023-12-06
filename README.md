# API REST PARA SISTEMA DE TRANSPORTE
Este proyecto tiene como objetivo la construcción del backend para una aplicación dedicada a monitorear el comportamiento de los usuarios dentro de una plataforma digital. La tarea principal del backend es registrar las interacciones de los usuarios y asociarlas con distintos países. Además, se implementará un sistema que asignará diferentes niveles de acceso a la información según el rol de cada usuario.

### Configuración
Asegúrate de tener las siguientes herramientas instaladas en tu entorno de desarrollo:
* Java 17
* SringBoot 3.2.0
* Base de datos postgreSQL 
#### NOTA
Una ves se replique el proyecto se debera configurar la URL, username y password para el acceso a la base de datos 

### La aplicación se ejecutará en http://localhost:8031 por defecto.
Los siguientes Endpoints a ejecutar son:

#### - Consultar todos los usuarios.
```bash
  curl --location --request GET 'http://localhost:8031/User/findAll?token=&page=&size='
  ```
#### - Consultar usuarios por email.
```bash
curl --location --request GET'http://localhost:8031/User/findByEmail?token=&email='
  ```
#### - Consultar todos los paises.
```bash
  curl --location --request GET 'http://localhost:8031/Country/findAll?token='
  ```
#### - Consultar Monitoreo de usuario en un rango de fecha.
```bash
  curl --location --request GET 'http://localhost:8031/UserMonitoring/find?Token=&email=&dateStart=&dateEnd='
  ```
#### - Consular 3 usuarios con mas registros en userMonitoring en un rango de fechas.
```bash
  curl --location --request GET 'http://localhost:8031/UserMonitoring/find?Token=&email=&dateStart=&dateEnd='
  ```
#### - Consular monitoreo de usuario por pais, tipo de monitoreo en un rango de fechas.
```bash
  curl --location --request GET 'http://localhost:8031/User/userMonitoringResults?token=&dateStart=&dateEnd=&countryId=&monitoringType='
  ```
### Estructura del Proyecto
La estructura del proyecto está diseñada para demostrar habilidades en la creación de soluciones backend robustas y eficientes, apropiadas para un entorno de desarrollo profesional moderno.

#### - Comando para construir la imagen de Docker
```bash
docker build -t gradle-wrapper.jar
  ```

#### - Comando para para iniciar el contenedor
```bash
docker run -p 8080:80 gradle-wrapper.jar
  ```

### Despliegue en AWS Lambda y Amazon ECS

Para desplegar tu aplicación Java en AWS, hay dos opciones populares que se pueden considerar: AWS Lambda y Amazon ECS (Elastic Container Service). A continuación, te proporcionaré una breve guía para cada opción.

### Despliegue en AWS Lambda:
#### Preparación del Código:
* Configura tu aplicación Java para ejecutarse como una función Lambda.
#### Empaquetado y Subida a Lambda:
* Empaqueta tu aplicación como un archivo JAR y sube a Lambda a través de la consola o AWS CLI.
#### Configuración de la Función Lambda:
* Define variables de entorno y roles de IAM necesarios para tu función.
#### Configuración de API Gateway (opcional):
* Configura una API Gateway si necesitas una interfaz HTTP.
### Despliegue en Amazon ECS:
#### Preparación del Dockerfile:
* Crea un Dockerfile que construya una imagen para tu aplicación Java.
#### Empaquetado de la Aplicación:
* Empaqueta tu aplicación y construye una imagen Docker.
#### Registro de Imágenes en ECR:
* Sube la imagen a Amazon ECR.
#### Configuración de Amazon ECS:
* Crea un clúster, define un servicio para tu aplicación y configura el uso de la imagen de ECR.
#### Configuración de un Balanceador de Carga (opcional):
* Configura un balanceador de carga si es necesario.
#### Despliegue:
* Lanza tu servicio en ECS para iniciar instancias de contenedores basadas en tu imagen Docker.