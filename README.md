# 🎮 **MasterMind Game** 

## **Descripción**
Este proyecto es una implementación del clásico juego **MasterMind** en Java. El juego permite a los jugadores adivinar una secuencia oculta de colores dentro de un número limitado de intentos. Proporciona retroalimentación en cada intento, indicando cuántos colores son correctos y están en la posición correcta, y cuántos colores son correctos pero están en la posición incorrecta.

## ✨ **Características**
- ⚙️ **Configuración del juego**: El juego puede iniciarse con una nueva secuencia o cargando una partida guardada.
- 🎯 **Entrada del usuario**: El juego lee la entrada del usuario para las jugadas y comandos.
- 💬 **Retroalimentación**: Después de cada jugada, el juego proporciona información sobre el número de colores correctos en la posición correcta e incorrecta.
- 💾 **Guardar y cargar**: El estado del juego puede guardarse en un archivo y cargarse desde un archivo.
- 🏁 **Condiciones de fin**: El juego termina cuando el jugador adivina correctamente la secuencia o se queda sin intentos.

## 📂 **Clases**
- ### **MasterMind**
🧠 Clase principal que gestiona la lógica del juego, incluyendo el inicio de una nueva partida, la carga de una partida guardada, el procesamiento de la entrada del usuario y la retroalimentación.

- ### **Tablero**
📊 Representa el tablero del juego, almacenando las jugadas del jugador y la retroalimentación correspondiente.

- ### **Jugada**
🧩 Representa una jugada individual realizada por el jugador.

- ### **Pistas**
💡 Representa la retroalimentación de una jugada, indicando el número de colores correctos en la posición correcta y los colores correctos en la posición incorrecta.

- ### **Teclado**
⌨️ Clase de utilidad para leer la entrada del usuario desde la consola.

## 🛠️ **Métodos**

### **MasterMind**
- `MasterMind(int numFichas)`: Constructor para iniciar una nueva partida con un número específico de fichas.
- `MasterMind(String nombreArchivo)`: Constructor para cargar una partida desde un archivo.
- `guardarPartida(String nombreArchivo)`: Guarda el estado actual del juego en un archivo.
- `jugar()`: Bucle principal del juego que procesa la entrada del usuario y proporciona retroalimentación.
- `main(String[] args)`: Punto de entrada de la aplicación.

### **Tablero**
- `Tablero()`: Constructor que inicializa el tablero de juego.
- `insertar(Jugada jugada, Pistas pistas)`: Inserta una jugada y su retroalimentación en el tablero.
- `completo()`: Verifica si el tablero está lleno (es decir, si se alcanzó el número máximo de intentos).
- `visualizar()`: Muestra el estado actual del tablero.

### **Jugada**
- `Jugada(int numFichas)`: Constructor para crear una secuencia oculta aleatoria.
- `Jugada(String jugada)`: Constructor para crear una jugada a partir de una cadena de texto.
- `comprobar(Jugada jugadaOculta)`: Compara la jugada con la secuencia oculta y devuelve la retroalimentación.
- `visualizar()`: Muestra la jugada.

### **Pistas**
- `Pistas(int aciertos, int descolocados)`: Constructor para crear retroalimentación con el número de colores correctos y descolocados.
- `visualizar()`: Muestra la retroalimentación.
- `getAciertos()`: Devuelve el número de colores correctos en la posición correcta.
- `toString()`: Devuelve una representación en texto de la retroalimentación.

### **Teclado**
- `leerEntero(int min, int max, String mensaje)`: Lee un número entero desde la consola dentro de un rango especificado.
- `leerString(String mensaje)`: Lee una cadena de texto desde la consola.
- `leerSiNo(String mensaje)`: Lee una respuesta "sí" o "no" desde la consola.
- `leerJugadaGuardar(int longitud, String mensaje)`: Lee una jugada o un comando para guardar desde la consola.

## 🎯 **Cómo jugar**

1. 🚀 **Iniciar una nueva partida**:  
   Ejecuta la aplicación y elige iniciar una nueva partida. Especifica el número de fichas de la secuencia oculta.

2. 📂 **Cargar una partida guardada**:  
   Ejecuta la aplicación y elige cargar una partida guardada. Proporciona el nombre del archivo de la partida.

3. ✏️ **Realizar una jugada**:  
   Ingresa una secuencia como intento para adivinar la secuencia oculta. El juego proporcionará retroalimentación sobre los colores correctos y descolocados.

4. 💾 **Guardar la partida**:  
   Ingresa `G` para guardar el estado actual del juego en un archivo.

5. 🏁 **Terminar el juego**:  
   El juego termina cuando se adivina correctamente la secuencia oculta o se alcanzan el máximo de intentos.

## 📝 **Ejemplo**

```plaintext
¿Quieres recuperar una partida? (S/N): N  
Número de fichas de las jugadas (4 - 6): 4  
Introduce jugada o G (guardar la partida).  
R (Rojo), V(Verde), A (Amarillo), P (púrpura): RRVV  
Jugada 1 	RRVV 	● ○   
Introduce jugada o G (guardar la partida).  
R (Rojo), V(Verde), A (Amarillo), P (púrpura): G  
Nombre del archivo: partida1.txt  
Partida guardada. Fin del juego.
```

## 🛠️ **Requisitos**
- **Java Development Kit (JDK) 11 o superior**  
- **IntelliJ IDEA** u otro IDE para Java  

## 🚀 **Cómo ejecutar**
1. 📥 Clona el repositorio.  
2. 🔧 Abre el proyecto en tu IDE.  
3. ▶️ Ejecuta la clase `MasterMind`.  

## 📜 **Licencia**
Este proyecto está bajo la licencia **MIT License**.
