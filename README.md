# Konecta

# Tecnologias y Librerias Usadas

Este aplicativo es desarrollado con las siguientes tecnologias:
1. `JAVA version 8 (SpringBoot version 2.6.6)`
2. `JPA/Hibernate`
3. `Thymeleaf`
4. `Maven`
5. `Jquery`
6. `AJAX`
7. `Bootstrap version 5.1`
8. `MySql`
9. `SweetAlert version 2`

# Como funciona

El aplicativo esta realizado como un hibrido entre Java(Spring Boot), Thymeleaf, Jquery(AJAX) y Bootstrap; esto con el fin de implementar las técnologias mencionadas en el documento para realizar la prueba y las habilidades detalladas en la oferta laboral.

Esta App esta desarrollada bajo una arquitectura MVC detallando la siguiente estructura:
1. `Model`: Mapeo de Base de datos
2. `Repository`: Persistencia de datos extendiendo a JPA
3. `Service`:Interfaz para implementar la persistencia de datos
4. `Controller`:Contiene un controlador donde se almacenan las Api REST `InventarioController` y un controlador `FrontController` donde se hace uso de la conexión con el archivo HTML y el paso de información para manipularla posteriormente con Thymeleaf
5. `Config`: Se configura de manera simple el intercambio de recursos CORS
6. `Templates`:Almacena el archivo HTML trabajado

Al desplegar la App se ejecuta sobre el puerto 9000, adicional se mapea mediante Hibernate en Base de datos dos tablas (inventario y venta), y realiza una incersión de dos registros en la tabla de inventario.

A nivel Frontend, se renderiza:
1. `Tabla para listar productos`:Lista la información de la tabla inventario
2. `Botón '+Nuevo'`: Despliega un formulario en forma de modal para realizar el registro de un producto
3. `Botón 'Vender Producto'`: Despliega un formulario en forma de modal con información para vender un producto
4. `Botón 'Editar'`: Despliega un formulario con la información referente al producto a editar
5. `Botón 'Eliminar'`: Despliega una alerta para confirmar si realmente se desea eliminar el producto
6. `Tabla de ventas`: Lista la información de la tabla ventas

# Consideraciones para la instalación

Es necesario tener JAVA en versión 8, Spring boot version 2.6.6 y una base de datos Mysql.
En el `aplication.properties`, se detalla la conexion a base de datos realizada, es necesario cambiar esta configuración con la información pertinente a la Base datos a usar:
* spring.datasource.url=URL de base de datos
* spring.datasource.username=Usuario de base de datos
* spring.datasource.password=Contraseña de base de datos

# Consultas SQL solicitadas

* Realizar una consulta que permita conocer cuál es el producto que más stock tiene:
* SQL=> SELECT nombre_producto AS producto, max(stock) AS stock FROM inventario;
* Realizar una consulta que permita conocer cuál es el producto más vendido.
* SQL => SELECT i.nombre_producto AS producto,sum(v.cantidad) AS "cantidad vendida"  FROM ventas v
  INNER JOIN inventario i ON v.inventario_id = i.id
  GROUP BY  inventario_id ORDER BY 2 DESC LIMIT 1;



