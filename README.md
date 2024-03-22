**HOUM PASO A PASO**


Una vez modificado el código pertinente antes entregado, podemos montar la API y la web para comenzar con la automatización.

![image](https://github.com/OliverABV/HoumQa/assets/45653045/38dc302b-cd5b-45ca-ae64-927eec6f46de)

Requisitos para el proyecto:
- **Lenguaje:** JAVA
- **IDE:** Eclipse, IntelliJ, etc.
- **Browser** Chrome o firefox
  **COMO EJECUTAR**

  ![image](https://github.com/OliverABV/HoumQa/assets/45653045/0c1221f4-69e9-4341-8e68-92e3bacac21c)
Solo necesitamos indicar el nombre de la clase y esta hará el resto del trabajo. El navegador que viene por defecto es Chrome, si desea ejecutar con Firefox, debe agregar el campo en las variables de entorno de la siguiente manera:
  ![image](https://github.com/OliverABV/HoumQa/assets/45653045/eb42c3dd-5aa9-4dbb-929c-951dae4f6c59)



Las tecnologías utilizadas en este proyecto incluyen el lenguaje de programación Java, la arquitectura POM (Project Object Model) para mantener un orden en el código, y la sintaxis Gherkin para tener una visión clara del flujo desde la perspectiva del cliente. Además, se utiliza Selenium, una herramienta de código abierto que se utiliza para automatizar aplicaciones web.

Es importante destacar que el uso de Java como lenguaje de programación proporciona una base sólida y ampliamente utilizada en el desarrollo de software. **Para pruebas técnicas, resulta más robusto, ya que se dispone del conocimiento directo del usuario, lo cual no ocurriría con frameworks que abstraen algunas capas.**

**STEP STEP**

Se crea un archivo .feature (Cucumber), en el cual se plantea el escenario de la prueba, la cual contiene la capa de interpretación usuario de fácil lectura para personas de áreas de productos y otros. Aquí se dictan las acciones que ejecutará el código en lenguaje natural.
![image](https://github.com/OliverABV/HoumQa/assets/45653045/94587b92-b715-49f8-8113-87b2b4719bb1)

Continúa la capa que corresponde a una clase de Java que contiene definiciones de pasos (steps) para realizar pruebas automatizadas utilizando el framework de pruebas Cucumber. Aquí tienes una explicación para tu informe:
![image](https://github.com/OliverABV/HoumQa/assets/45653045/dbe08a40-dabc-402f-ac53-201d0090eea5)


Este archivo corresponde a una clase de Java que contiene los métodos y acciones específicas que se ejecutan como parte de las pruebas automatizadas de la página de inicio de la aplicación bajo prueba.
![image](https://github.com/OliverABV/HoumQa/assets/45653045/8d581846-9cb7-4b3f-81d8-5bd4be4de036)

Aquí pueden ver el orden de las carpetas.

![image](https://github.com/OliverABV/HoumQa/assets/45653045/661730da-bd68-4ba5-872c-295f487c9f1a)

**También se creó un archivo con el nombre de (base), el cual monta los navegadores y tiene la lógica para procesar tiempos de espera y vistas necesarias.**
