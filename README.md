# Ejercicio-conocimiento-gco Formulario registro de proveedores
Ejercicio de conocimiento para empresa GCO, formulario registro de proveedores, realizado por Daniel Puerta

## Características
- Registro de proveedores con información detallada.
- Listado de proveedores en la base de datos
- Validación de datos de entrada por parte del back
- Carga y almacenamiento de archivos PDF.
  
## Tecnologías Utilizadas
### Backend
- **Java 17**
- **Spring Boot**
  - Spring Boot DevTools
  - Spring Data JPA
  - Spring Web
  - H2 Database (para pruebas)
-   Lombok
-   MySQL (como base de datos principal)

### Frontend
- **React**
  - Axios (para hacer peticiones HTTP)
  - Tailwind CSS (para el diseño y estilos)
- **SweetAlert2** (para alertas y mensajes emergentes)
  
### Herramientas de Desarrollo
- **IntelliJ IDEA** (como IDE principal)
- **Git** (para control de versiones)
- **GitHub** (para alojar el repositorio del proyecto
- **Visual Studio Code** 
  
## Instalación y Configuración
### Prerrequisitos
- JDK 17
- Node.js
- MySQL

### Clonar el Repositorio

git clone https://github.com/danielpuerta1013/ejercicio-conocimiento-gco.git
cd formulario-proveedores

## Instrucciones de Despliegue

### Prerrequisitos
Asegúrate de tener instalados los siguientes programas:
- **XAMPP** (para iniciar Apache y MySQL)
- **IntelliJ IDEA** (para ejecutar el backend en Spring Boot)
- **Visual Studio Code** (para ejecutar el frontend en React)
- **Node.js** y **npm** (para gestionar las dependencias del frontend)

### Pasos para Desplegar el Programa

1. **Iniciar Apache y MySQL con XAMPP**
   - Abre **XAMPP**.
   - En el panel de control de XAMPP, inicia los servicios de **Apache** y **MySQL** haciendo clic en los botones **Start** correspondientes.
  
     **Configurar la Base de Datos**
   - Abre tu navegador y visita http://localhost/phpmyadmin/index.php.
   - Crea una nueva base de datos llamada `proveedor`.
   - Importa la base de datos utilizando el archivo `database/init.sql`. Este archivo se encuentra en la carpeta `database/` del proyecto.

2. **Ejecutar el Backend con IntelliJ IDEA**
   - Navega a la carpeta del proyecto backend (`FormularioProveedores`).
   - Abre la carpeta `FormularioProveedores` con **IntelliJ IDEA**.
   - En IntelliJ IDEA, localiza el archivo `main` de tu aplicación Spring Boot.
   - Ejecuta el archivo `main` para iniciar el servidor. Asegúrate de que el servidor se está ejecutando en `localhost:8080`.

3. **Ejecutar el Frontend con Visual Studio Code**
   - Navega a la carpeta del proyecto frontend (`formulario-proveedor`).
   - Abre la carpeta `formulario-proveedor` con **Visual Studio Code**.
   - Abre una terminal en Visual Studio Code y ejecuta el siguiente comando para instalar las dependencias:
     ```bash
     npm install
     ```
   - Una vez instaladas las dependencias, ejecuta el siguiente comando para iniciar el servidor de desarrollo:
     ```bash
     npm run dev
     ```

### Notas Importantes
- **Puerto del Backend**: El backend está configurado para ejecutarse en `localhost:8080`. Por eso, en el frontend, la dirección de la API está configurada para apuntar a este puerto.
- **Base de Datos**: Asegúrate de que los servicios de **Apache** y **MySQL** están en ejecución en XAMPP antes de intentar iniciar el backend.

¡Eso es todo! Ahora deberías poder acceder a tu aplicación y utilizarla para registrar y listar proveedores.
