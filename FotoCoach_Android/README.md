# FotoCoach — Android nativo

MVP de entrenamiento fotográfico para aprender desde cero con:

- Fujifilm X-T50
- Samsung Galaxy S25 Ultra

## Incluye

- Onboarding para principiantes.
- 12 lecciones prácticas.
- Guías específicas de X-T50 y S25 Ultra.
- Asistente "Quiero hacer una foto".
- Recetas Fujifilm C1–C7.
- Presets/configuraciones Samsung.
- 10 retos fotográficos.
- Progreso persistente en el dispositivo.
- Modo claro/oscuro siguiendo el sistema.
- Funcionamiento completamente offline.

## Stack

- Kotlin
- Jetpack Compose
- Material 3
- Android Gradle Plugin 9.4.0
- Compose BOM 2026.08.00
- compileSdk 37
- targetSdk 36
- minSdk 26
- JDK 17

## Abrir en Android Studio

1. Descomprime el ZIP.
2. Abre la carpeta `FotoCoach_Android` en Android Studio.
3. Deja que Android Studio sincronice Gradle.
4. Si te pide instalar Android SDK 37 o Build Tools, acepta la instalación.
5. Selecciona tu Samsung S25 Ultra como dispositivo físico, con depuración USB activada, o un emulador.
6. Pulsa Run.

> Este paquete contiene el proyecto fuente. No incluye un APK precompilado.

## Si Android Studio pide Gradle Wrapper

El proyecto fija AGP 9.4.0, que requiere Gradle 9.6.0. Android Studio Quail 4 (2026.1.4) es una base adecuada. Si el IDE pregunta por Gradle, selecciona 9.6.0 o permite que lo descargue.

## Arquitectura del MVP

`MainActivity.kt`
- Punto de entrada.

`ui/FotoCoachApp.kt`
- Navegación local.
- Home.
- Cursos.
- Asistente.
- Recetas.
- Retos.
- Detalles.

`data/SampleData.kt`
- Todo el contenido pedagógico.
- Motor de recomendaciones del asistente.

`data/ProgressStore.kt`
- Guarda progreso en SharedPreferences.

`model/Models.kt`
- Modelos de datos.

## Siguiente iteración recomendada

1. Manual visual interactivo de botones y diales de la X-T50.
2. Fotografías de ejemplo y comparador antes/después.
3. Importación de una foto y lectura EXIF.
4. Evaluación asistida de exposición, foco, composición y color.
5. Módulo Lightroom Mobile.
6. Vídeo avanzado: F-Log2 / Samsung Log.
7. Retos de 60 días.
8. Perfil de aprendizaje y niveles.
9. Cámara integrada para ejercicios del S25 Ultra.
10. Backend opcional para sincronizar el progreso.

## Nota pedagógica

Los ajustes incluidos son puntos de partida. La fotografía depende de luz, movimiento, focal, apertura disponible y distancia al sujeto. El objetivo del producto es enseñar a decidir, no memorizar números.
