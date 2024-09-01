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

    ```bash
    src/
      ├── main/
      │   ├── java/
      │   │   └── mowerApp/
      │   │       ├── service/
      │   │       │   └── MowerService.java               # Service class handling the main mower movement logic
      │   │       ├── domain/
      │   │       │   ├── exception/
      │   │       │   │   ├── InvalidDirectionException.java
      │   │       │   │   └── InvalidInstructionException.java
      │   │       │   ├── model/
      │   │       │   │   ├── enums/
      │   │       │   │   │   ├── Direction.java
      │   │       │   │   │   ├── Instruction.java
      │   │       │   │   ├── Mower.java
      │   │       │   │   ├── Obstacle.java
      │   │       │   │   ├── ObstacleManager.java
      │   │       │   │   └── Plateau.java
      │   │       ├── console/
      │   │       │   └── MowerConsoleApp.java            # Console interface to interact with the application
      │   │       └── validator/
      │   │           ├── DirectionValidator.java
      │   │           ├── InputValidator.java
      │   │           ├── InstructionValidator.java
      │   │           ├── MowerPositionValidator.java
      │   │           └── PlateauSizeValidator.java
      
      test/
      ├── java/
      │   └── mowerApp/
      │       ├── integration/
      │       │   ├── stepdefs/
      │       │   │   ├── MowerStepDefinitions.java       # Step definitions for integration testing with Cucumber
      │       │   └── MowerAppApplicationTests.java       # Main class for running integration tests
      │       ├── unit/
      │       │   ├── service/
      │       │   │   └── MowerServiceUnitTest.java
      │       │   ├── model/
      │       │   │   ├── enums/
      │       │   │   │   ├── DirectionUnitTest.java
      │       │   │   │   ├── InstructionUnitTest.java
      │       │   │   ├── MowerUnitTest.java
      │       │   │   ├── ObstacleManagerUnitTest.java
      │       │   │   └── PlateauUnitTest.java
      │       │   └── validator/
      │       │       ├── DirectionValidatorTest.java
      │       │       ├── MowerPositionValidatorTest.java
      │       │       ├── PlateauSizeValidatorTest.java
      │       │       └── InstructionValidatorTest.java
      ├── resources/
      │   ├── features/
      │   │   ├── MowerApp.feature
      │   └── cucumber.properties


## Instrucciones de Uso

### Ejecución de la Aplicación

1. **Compilación**:
   ```bash
   ./gradlew build

2. **Ejecucíon**:

    ```bash
    java -jar build/libs/mowerApp-0.0.1-SNAPSHOT.jar

3. **Ejecucíon de pruebas**:
    ### Configuración del Entorno
    
    Antes de ejecutar las pruebas de Cucumber, asegúrate de tener instalado el plugin de Cucumber en tu entorno de 
    desarrollo. Esto es necesario para que las pruebas de Cucumber se ejecuten correctamente.
    
    #### Instalación del Plugin de Cucumber
    
    - **En IntelliJ IDEA**:
        1. Ve a `File > Settings > Plugins`.
        2. Busca "Cucumber for Java" en el mercado de plugins.
        3. Instala el plugin y reinicia IntelliJ IDEA si es necesario.
    
    - **En Eclipse**:
        1. Ve a `Help > Eclipse Marketplace`.
        2. Busca "Cucumber" y selecciona "Cucumber Eclipse Plugin".
        3. Instala el plugin y reinicia Eclipse si es necesario.
    
    ### Ejecución de Pruebas
    
    3.1. **Pruebas unitarias**:
    ```bash
    ./gradlew test
    ```
   
    3.2. **Pruebas de integración**:
    ```bash
    ./gradlew cucumber
    ```

### Personalización y Extensiones

**Obstáculos:** La clase `ObstacleManager` ha sido diseñada para manejar obstáculos en el plateau, que ahora incluye a 
otros cortacéspedes como obstáculos para asegurar que no se produzcan colisiones.

### Posibles Implementaciones Futuras

1. **Soporte para múltiples tipos de obstáculos:**
    - Ampliar `ObstacleManager` para manejar diferentes tipos de obstáculos con
      comportamientos específicos, como áreas prohibidas o zonas de paso limitado.

2. **Mejoras en la lógica de movimiento:**
    - Implementar rutas óptimas para los cortacéspedes para evitar obstáculos y
      minimizar el tiempo de trabajo en el plateau.

3. **Interfaz gráfica de usuario (GUI):**
    - Crear una interfaz gráfica que permita a los usuarios configurar el plateau,
      posicionar cortacéspedes y observar sus movimientos en tiempo real.

4. **Simulaciones avanzadas:**
    - Incluir opciones para ejecutar simulaciones de largo plazo que permitan observar
      el rendimiento de múltiples cortacéspedes trabajando simultáneamente en un mismo plateau.

5. **Soporte para terrenos irregulares:**
    - Permitir la configuración de terrenos con diferentes niveles de elevación o
      áreas inaccesibles, lo que influiría en las rutas y movimientos de los cortacéspedes.

### Contribución

Si deseas contribuir al desarrollo de MowerApp:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y haz commit (`git commit -am 'Añadir nueva característica'`).
4. Empuja la rama (`git push origin feature/nueva-caracteristica`).
5. Abre un Pull Request.

### Licencia

MowerApp está disponible bajo la Licencia MIT.


