# MowerApp

## Descripción

MowerApp es una aplicación que simula el movimiento de cortacéspedes en un plateau. Cada cortacésped se mueve 
en un área rectangular según las instrucciones proporcionadas por el usuario. El propósito de la aplicación es 
gestionar el movimiento de los cortacéspedes, asegurando que no se salgan de los límites del plateau ni 
colisionen con obstáculos, que pueden incluir otros cortacéspedes.

## Características

- Definir el tamaño de un plateau rectangular.
- Colocar uno o más cortacéspedes en posiciones iniciales en el plateau.
- Ejecutar una serie de instrucciones (L, R, M) para mover los cortacéspedes.
- Detección de colisiones con otros cortacéspedes y obstáculos.
- Validación de entradas de usuario, incluyendo direcciones e instrucciones válidas.

## Tecnologías

- **Java**: Lenguaje principal.
- **JUnit 4**: Para pruebas unitarias.
- **Cucumber**: Para pruebas basadas en BDD (Behavior Driven Development).
- **Maven/Gradle**: Para la gestión de dependencias y construcción del proyecto.
- **SLF4J**: Para el registro de logs.

## Estructura del Proyecto

- `src/main/java/com/example/mowerApp`:
    - **domain**: Contiene las clases principales del dominio, como `Mower`, `Plateau`, `Obstacle`, y `ObstacleManager`.
    - **application**: Contiene la clase de servicio `MowerService` que maneja la lógica principal del movimiento de los cortacéspedes.
    - **infrastructure**: Contiene la interfaz de consola `MowerConsoleApp` para interactuar con la aplicación.
    - **tools/validator**: Contiene las clases de validación para validar entradas como direcciones, posiciones de los cortacéspedes y tamaño del plateau.

- `src/test/java/com/example/mowerApp`:
    - **unit**: Contiene las pruebas unitarias para cada clase de dominio y validación.
    - **integration**: Contiene las pruebas de integración usando Cucumber.

## Instrucciones de Uso

### Ejecución de la Aplicación

1. **Compilación**:
   ```bash
   ./gradlew build

2. **Ejecucíon**:

    ```bash
    java -jar build/libs/mowerApp-0.0.1-SNAPSHOT.jar

3. **Ejecucíon de pruebas**:
3.1 **Pruebas unitarias**:
    ```bash
    ./gradlew test
3.2 **Pruebas de integración**:
    ```bash
    ./gradlew cucumber

### Personalización y Extensiones

**Obstáculos:** La clase `ObstacleManager` ha sido diseñada para manejar obstáculos en el plateau, que ahora incluye a 
otros cortacéspedes como obstáculos para asegurar que no se produzcan colisiones.

### Posibles Implementaciones Futuras

- **Soporte para múltiples tipos de obstáculos:** 
- Ampliar `ObstacleManager` para manejar diferentes tipos 
- de obstáculos con comportamientos específicos, como áreas prohibidas o zonas de paso limitado.

- **Mejoras en la lógica de movimiento:** 
- Implementar rutas óptimas para los cortacéspedes para evitar 
- obstáculos y minimizar el tiempo de trabajo en el plateau.

- **Interfaz gráfica de usuario (GUI):** 
- Crear una interfaz gráfica que permita a los usuarios configurar el plateau, 
- posicionar cortacéspedes y observar sus movimientos en tiempo real.

- **Simulaciones avanzadas:** 
- Incluir opciones para ejecutar simulaciones de largo plazo que permitan observar el 
- rendimiento de múltiples cortacéspedes trabajando simultáneamente en un mismo plateau.

- **Soporte para terrenos irregulares:** 
- Permitir la configuración de terrenos con diferentes niveles de elevación 
- o áreas inaccesibles, lo que influiría en las rutas y movimientos de los cortacéspedes.



### Contribución

Si deseas contribuir al desarrollo de MowerApp:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y haz commit (`git commit -am 'Añadir nueva característica'`).
4. Empuja la rama (`git push origin feature/nueva-caracteristica`).
5. Abre un Pull Request.

### Licencia

MowerApp está disponible bajo la Licencia MIT.


