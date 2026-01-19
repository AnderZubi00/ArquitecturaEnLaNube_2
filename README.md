# Actividad 2 - API REST en Spring Boot con CI/CD

Este proyecto implementa una API REST en Spring Boot con Integración Continua (CI) y Despliegue Continuo (CD) utilizando GitHub Actions y AWS Elastic Beanstalk.

## Requisitos

- Java 17
- Spring Boot 3.2.0
- Maven (incluido Maven Wrapper)
- Git y GitHub
- Cuenta de AWS con acceso a Elastic Beanstalk

## Estructura del Proyecto

```
Actividad_2/
├── src/
│   ├── main/
│   │   └── java/org/example/
│   │       ├── Main.java                    # Clase principal Spring Boot
│   │       └── controller/
│   │           └── EstadoController.java    # Controlador REST
│   └── test/
│       └── java/org/example/controller/
│           └── EstadoControllerTest.java    # Tests unitarios
├── .github/
│   └── workflows/
│       └── ci-cd.yml                        # Pipeline CI/CD
├── .mvn/
│   └── wrapper/                             # Maven Wrapper
├── pom.xml                                  # Configuración Maven
├── Procfile                                 # Configuración Elastic Beanstalk
├── mvnw                                     # Maven Wrapper (Unix/Mac)
└── mvnw.cmd                                 # Maven Wrapper (Windows)
```

## Endpoints de la API

### GET /
Devuelve un mensaje de texto indicando el fin de la práctica.

**Ejemplo de respuesta:**
```
Actividad 2 - API REST en Spring Boot con Integración Continua y Despliegue en la nube (GitHub Actions + AWS Elastic Beanstalk) - Finalizada
```

### GET /api/estado
Devuelve un JSON con información básica del servicio.

**Ejemplo de respuesta:**
```json
{
  "estado": "activo",
  "nombre": "Actividad 2 API",
  "mensaje": "API REST funcionando correctamente"
}
```

## Ejecución Local

1. Clonar el repositorio:
```bash
git clone <URL_DEL_REPOSITORIO>
cd Actividad_2
```

2. Compilar el proyecto:
```bash
./mvnw clean compile
```

3. Ejecutar los tests:
```bash
./mvnw test
```

4. Generar el JAR ejecutable:
```bash
./mvnw package
```

5. Ejecutar la aplicación:
```bash
java -jar target/Actividad_2-1.0-SNAPSHOT.jar
```

La aplicación estará disponible en `http://localhost:8080`

## Pipeline CI/CD

El pipeline de GitHub Actions está configurado en `.github/workflows/ci-cd.yml` y realiza las siguientes acciones:

1. **Build and Test**:
   - Checkout del código
   - Configuración de JDK 17
   - Compilación con Maven Wrapper
   - Ejecución de tests
   - Empaquetado del JAR
   - Subida del artefacto

2. **Deploy**:
   - Descarga del artefacto
   - Renombrado del JAR a `app.jar`
   - Creación del paquete de despliegue (`deploy.zip`) con:
     - `app.jar`
     - `Procfile`
   - Despliegue automático a AWS Elastic Beanstalk

## Configuración de AWS Elastic Beanstalk

### Requisitos previos:

1. Crear una aplicación en AWS Elastic Beanstalk:
   - Nombre: `actividad-2-api`
   - Plataforma: Java SE
   - Versión: Java 17

2. Crear un entorno:
   - Nombre: `actividad-2-api-env`

3. Configurar secrets en GitHub:
   - `AWS_ACCESS_KEY_ID`: Clave de acceso de AWS
   - `AWS_SECRET_ACCESS_KEY`: Clave secreta de AWS

### Pasos para configurar los secrets:

1. Ve a tu repositorio en GitHub
2. Settings → Secrets and variables → Actions
3. Agrega los siguientes secrets:
   - `AWS_ACCESS_KEY_ID`
   - `AWS_SECRET_ACCESS_KEY`

## Despliegue

El despliegue se realiza automáticamente cuando:
- Se hace push a la rama `main`
- El pipeline de CI pasa exitosamente

También se puede ejecutar manualmente desde la pestaña "Actions" en GitHub.

## Verificación del Despliegue

Una vez desplegado, verifica que los endpoints funcionan:

- URL raíz: `https://<tu-dominio>.elasticbeanstalk.com/`
- Estado: `https://<tu-dominio>.elasticbeanstalk.com/api/estado`

## Notas Importantes

- El pipeline está configurado para la región `us-east-1`. Modifica `region` en `.github/workflows/ci-cd.yml` si usas otra región.
- Asegúrate de que los nombres de la aplicación y entorno en AWS coincidan con los del workflow.
- El `Procfile` está configurado para ejecutar la aplicación en el puerto 5000, que es el puerto estándar de Elastic Beanstalk.

## Tecnologías Utilizadas

- **Spring Boot 3.2.0**: Framework para desarrollo de aplicaciones Java
- **Maven 3.9.5**: Herramienta de gestión de dependencias y construcción
- **GitHub Actions**: Plataforma de CI/CD
- **AWS Elastic Beanstalk**: Plataforma de despliegue en la nube

## Autor

Actividad desarrollada para el curso de Arquitectura en la Nube - UNIR.

