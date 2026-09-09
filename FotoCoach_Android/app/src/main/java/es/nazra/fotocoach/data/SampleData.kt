package es.nazra.fotocoach.data

import es.nazra.fotocoach.model.*

object SampleData {

    val lessons = listOf(
        Lesson(
            id = "basics_exposure",
            title = "La exposición sin dolor",
            subtitle = "ISO, velocidad y apertura explicados con fotos",
            minutes = 8,
            level = "Dummie",
            body = listOf(
                "Una foto se construye con tres controles: apertura, velocidad e ISO. No necesitas memorizarlos de golpe.",
                "La velocidad decide cuánto tiempo entra luz y cuánto movimiento registras. 1/1000 s congela mucho mejor que 1/30 s.",
                "La apertura controla cuánta luz entra por el objetivo y cuánto fondo queda desenfocado. Un número f pequeño suele dar más luz y menos profundidad de campo.",
                "El ISO amplifica la señal. Subirlo ayuda cuando falta luz, pero demasiado ISO puede añadir ruido."
            ),
            remember = "Primero protege la velocidad si el sujeto se mueve. Después decide apertura. Deja que ISO Auto te ayude mientras aprendes.",
            practice = "Fotografía la misma escena a 1/30, 1/125 y 1/500 s. Compara movimiento y luminosidad."
        ),
        Lesson(
            id = "light_direction",
            title = "Aprende a ver la luz",
            subtitle = "La habilidad que más mejora una foto",
            minutes = 7,
            level = "Dummie",
            body = listOf(
                "Antes de tocar la cámara, mira de dónde viene la luz.",
                "La luz frontal reduce textura. La lateral crea volumen. El contraluz puede separar al sujeto del fondo y crear atmósfera.",
                "Una ventana grande funciona como una fuente de luz suave excelente para retratos, comida y producto."
            ),
            remember = "Muévete tú antes de cambiar diez parámetros.",
            practice = "Haz tres retratos junto a una ventana: luz frontal, lateral y contraluz. Elige cuál da más volumen al rostro."
        ),
        Lesson(
            id = "composition",
            title = "Composición que funciona",
            subtitle = "Encuadre, capas, líneas y espacio",
            minutes = 9,
            level = "Dummie",
            body = listOf(
                "La regla de tercios es un punto de partida, no una ley.",
                "Busca un sujeto claro, elimina distracciones de los bordes y utiliza líneas para dirigir la mirada.",
                "Añadir primer plano, sujeto y fondo crea profundidad."
            ),
            remember = "Antes de disparar, revisa las cuatro esquinas del encuadre.",
            practice = "Haz cinco fotos del mismo lugar cambiando solo tu posición: alto, bajo, cerca, lejos y lateral."
        ),
        Lesson(
            id = "fuji_controls",
            title = "X-T50: controles esenciales",
            subtitle = "Qué tocar y qué ignorar durante el primer mes",
            minutes = 12,
            level = "X-T50",
            device = CameraDevice.FUJI,
            body = listOf(
                "Empieza dominando cuatro cosas: velocidad, apertura, compensación de exposición y modo de enfoque.",
                "AF-S sirve para sujetos quietos. AF-C es la elección habitual para movimiento.",
                "El modo A es excelente para aprender: eliges apertura y la cámara calcula velocidad, aunque debes vigilar que no baje demasiado.",
                "Auto ISO con una velocidad mínima razonable permite concentrarte en luz y composición."
            ),
            remember = "Para personas quietas intenta no bajar de 1/125 s; si hay movimiento, sube a 1/250–1/1000 s según la acción.",
            practice = "Configura una sesión sencilla en modo A, Auto ISO y detección de ojo. Haz 20 retratos variando solo apertura y encuadre."
        ),
        Lesson(
            id = "fuji_af",
            title = "X-T50: domina el autofocus",
            subtitle = "AF-S, AF-C, áreas y detección de sujeto",
            minutes = 10,
            level = "X-T50",
            device = CameraDevice.FUJI,
            body = listOf(
                "AF-S bloquea foco y funciona muy bien con escenas quietas.",
                "AF-C actualiza el enfoque continuamente y es preferible para personas, animales o vehículos en movimiento.",
                "Una zona pequeña da control; una zona amplia facilita seguir acción. La detección de cara y ojo es muy útil en retrato.",
                "No confundas un problema de enfoque con trepidación: una velocidad demasiado lenta también produce falta de nitidez."
            ),
            remember = "Sujeto quieto: AF-S. Sujeto que cambia de distancia: AF-C.",
            practice = "Pide a alguien que camine hacia ti. Usa AF-C y una velocidad de 1/500 s. Haz una ráfaga corta y revisa cuántas fotos tienen el ojo nítido."
        ),
        Lesson(
            id = "fuji_film",
            title = "Simulaciones y recetas Fuji",
            subtitle = "Color con intención, no filtros al azar",
            minutes = 11,
            level = "X-T50",
            device = CameraDevice.FUJI,
            body = listOf(
                "Las simulaciones de película cambian la interpretación de color y contraste del JPEG.",
                "Una receta puede combinar simulación, rango dinámico, balance de blancos, altas luces, sombras, color, grano y otros ajustes.",
                "Disparar RAW+JPEG es una gran estrategia mientras aprendes: disfrutas el JPEG y conservas margen de revelado."
            ),
            remember = "Elige una receta por intención visual y luz, no porque sea popular.",
            practice = "Fotografía la misma escena con REALA ACE, Classic Chrome y Classic Neg. Escribe qué cambia en piel, verdes, cielo y contraste."
        ),
        Lesson(
            id = "samsung_lenses",
            title = "S25 Ultra: elige la lente correcta",
            subtitle = "0.6x, 1x, 3x y 5x con intención",
            minutes = 9,
            level = "S25 Ultra",
            device = CameraDevice.SAMSUNG,
            body = listOf(
                "La lente importa tanto como los ajustes. Cambiar focal cambia la perspectiva y la relación entre sujeto y fondo.",
                "0.6x es útil para espacios y dramatismo, pero puede deformar personas cerca de los bordes.",
                "1x es la opción general. 3x favorece retratos y detalle. 5x permite aislar sujetos lejanos y comprimir el fondo.",
                "Acercarte físicamente suele producir mejor resultado que abusar del zoom digital."
            ),
            remember = "Para retratos naturales empieza probando 3x y aléjate del sujeto.",
            practice = "Haz el mismo retrato con 0.6x, 1x, 3x y 5x manteniendo el tamaño de la persona parecido. Compara el fondo y el rostro."
        ),
        Lesson(
            id = "samsung_pro",
            title = "S25 Ultra: modo Pro",
            subtitle = "Controla ISO, velocidad, enfoque y WB",
            minutes = 12,
            level = "S25 Ultra",
            device = CameraDevice.SAMSUNG,
            body = listOf(
                "El modo Pro te permite decidir parámetros que la cámara automática normalmente escoge por ti.",
                "Fija balance de blancos cuando quieras consistencia entre varias fotos.",
                "Usa ISO bajo siempre que haya luz suficiente y aumenta ISO cuando necesites mantener una velocidad segura.",
                "El enfoque manual tiene usos concretos, pero para la mayoría de escenas el autofocus será más rápido."
            ),
            remember = "No uses manual por orgullo. Úsalo cuando necesites consistencia o el automático esté tomando una decisión equivocada.",
            practice = "En una habitación, haz tres fotos en Pro manteniendo 1/125 s y cambiando ISO. Observa ruido y exposición."
        ),
        Lesson(
            id = "raw",
            title = "RAW: tu red de seguridad",
            subtitle = "Qué conserva y cuándo merece la pena",
            minutes = 10,
            level = "Intermedio",
            body = listOf(
                "Un archivo RAW conserva más información de captura que un JPEG terminado y permite un revelado más flexible.",
                "Es especialmente útil cuando hay contraste fuerte, color difícil o cuando la foto es importante.",
                "RAW no convierte una mala foto en buena. El foco, el momento y la composición siguen teniendo que estar bien."
            ),
            remember = "Usa RAW cuando esperes editar. Usa JPEG cuando velocidad y simplicidad sean prioritarias.",
            practice = "Haz una escena de alto contraste en RAW y JPEG. En tu editor, intenta recuperar cielo y sombras y compara."
        ),
        Lesson(
            id = "portrait",
            title = "Retrato: de foto correcta a retrato",
            subtitle = "Distancia, focal, luz y fondo",
            minutes = 12,
            level = "Intermedio",
            body = listOf(
                "Un retrato mejora cuando controlas la relación entre rostro, luz y fondo.",
                "Separa al sujeto del fondo y evita elementos que parezcan salir de la cabeza.",
                "La luz lateral suave suele modelar mejor el rostro que una luz cenital dura.",
                "Enfoca el ojo más cercano a cámara cuando la profundidad de campo sea pequeña."
            ),
            remember = "Un fondo limpio y una buena luz hacen más por el retrato que un preset.",
            practice = "Haz una mini sesión de 12 fotos con una sola ventana y un fondo sencillo. Cambia únicamente distancia y ángulo."
        ),
        Lesson(
            id = "night",
            title = "Fotografía nocturna",
            subtitle = "Ruido, movimiento y luces",
            minutes = 11,
            level = "Intermedio",
            body = listOf(
                "De noche debes decidir qué sacrificas: movimiento, ruido o profundidad de campo.",
                "Para personas, protege velocidad. Para ciudad estática con trípode, puedes bajar ISO y alargar exposición.",
                "Las luces puntuales engañan fácilmente a la exposición automática; revisa altas luces."
            ),
            remember = "Con personas de noche: una foto ligeramente ruidosa pero nítida suele ser mejor que una limpia y movida.",
            practice = "Haz una escena urbana a pulso y otra con apoyo/trípode. Compara la estrategia de ISO y velocidad."
        ),
        Lesson(
            id = "video",
            title = "Vídeo desde fotografía",
            subtitle = "FPS, obturación, WB y movimiento",
            minutes = 13,
            level = "Intermedio",
            body = listOf(
                "En vídeo necesitas consistencia entre fotogramas. Por eso conviene fijar parámetros que en foto pueden variar.",
                "A 25 fps, 1/50 s es un punto de partida habitual para movimiento natural. A 50/60 fps se usa una velocidad aproximadamente doble del frame rate como referencia.",
                "Fijar balance de blancos evita cambios de color durante una toma.",
                "Muévete despacio y con intención: la estabilización ayuda, pero no sustituye una técnica limpia."
            ),
            remember = "Para empezar: resolución moderada, 25/30 fps, WB fijo y movimientos simples.",
            practice = "Graba cinco clips de 5 segundos: plano general, medio, detalle, movimiento y cierre. Móntalos como una secuencia."
        )
    )

    val recipes = listOf(
        Recipe(
            id = "fuji_everyday",
            title = "C1 · Everyday Clean",
            subtitle = "Natural, flexible y fácil de corregir",
            device = CameraDevice.FUJI,
            useFor = "Viaje, personas, calle y uso diario",
            settings = listOf(
                "Film Simulation" to "REALA ACE",
                "Dynamic Range" to "DR200",
                "White Balance" to "Auto",
                "Highlight" to "-1",
                "Shadow" to "0",
                "Color" to "+1",
                "Sharpness" to "0",
                "Clarity" to "0"
            ),
            tip = "Úsala como referencia neutra para aprender a reconocer qué cambios te gustan."
        ),
        Recipe(
            id = "fuji_street",
            title = "C2 · Street Documentary",
            subtitle = "Color sobrio y contraste contenido",
            device = CameraDevice.FUJI,
            useFor = "Calle, arquitectura, reportaje",
            settings = listOf(
                "Film Simulation" to "Classic Chrome",
                "Dynamic Range" to "DR400",
                "White Balance" to "Auto",
                "Highlight" to "-1",
                "Shadow" to "+1",
                "Color" to "-1",
                "Grain" to "Weak / Small",
                "Clarity" to "0"
            ),
            tip = "Funciona especialmente bien cuando quieres que el color acompañe sin dominar la escena."
        ),
        Recipe(
            id = "fuji_warm",
            title = "C3 · Warm Summer",
            subtitle = "Cálida, viva y con carácter analógico",
            device = CameraDevice.FUJI,
            useFor = "Viaje, terrazas, verano, lifestyle",
            settings = listOf(
                "Film Simulation" to "Classic Neg.",
                "Dynamic Range" to "DR200",
                "White Balance" to "Daylight",
                "WB Shift" to "R +2 / B -3",
                "Highlight" to "-1",
                "Shadow" to "+1",
                "Color" to "+2",
                "Grain" to "Weak"
            ),
            tip = "Si la piel se vuelve demasiado naranja, reduce el desplazamiento cálido del balance de blancos."
        ),
        Recipe(
            id = "fuji_portrait",
            title = "C4 · Portrait Soft",
            subtitle = "Piel suave sin dejarla plana",
            device = CameraDevice.FUJI,
            useFor = "Retratos, familia, eventos tranquilos",
            settings = listOf(
                "Film Simulation" to "ASTIA / Soft",
                "Dynamic Range" to "DR200",
                "White Balance" to "Auto",
                "Highlight" to "-1",
                "Shadow" to "-1",
                "Color" to "+1",
                "Sharpness" to "-1",
                "Clarity" to "-1"
            ),
            tip = "La receta ayuda, pero prioriza una luz suave y exposición correcta en el rostro."
        ),
        Recipe(
            id = "fuji_landscape",
            title = "C5 · Landscape Pop",
            subtitle = "Color intenso para naturaleza",
            device = CameraDevice.FUJI,
            useFor = "Paisaje, costa, vegetación",
            settings = listOf(
                "Film Simulation" to "Velvia / VIVID",
                "Dynamic Range" to "DR200",
                "White Balance" to "Daylight",
                "Highlight" to "-1",
                "Shadow" to "0",
                "Color" to "+1",
                "Color Chrome" to "Strong",
                "Color Chrome FX Blue" to "Strong"
            ),
            tip = "Con luz dura puede saturar demasiado. Reduce Color si la escena ya es muy intensa."
        ),
        Recipe(
            id = "fuji_cinema",
            title = "C6 · Cinematic Base",
            subtitle = "Contraste bajo para una estética de cine",
            device = CameraDevice.FUJI,
            useFor = "Vídeo, escenas urbanas, mood",
            settings = listOf(
                "Film Simulation" to "ETERNA / CINEMA",
                "Dynamic Range" to "DR400",
                "White Balance" to "Fijo según escena",
                "Highlight" to "-1",
                "Shadow" to "-1",
                "Color" to "-1",
                "Sharpness" to "-1"
            ),
            tip = "Fija el balance de blancos en vídeo para evitar saltos de color."
        ),
        Recipe(
            id = "fuji_bw",
            title = "C7 · B&W Street",
            subtitle = "Blanco y negro con textura",
            device = CameraDevice.FUJI,
            useFor = "Calle, retrato, arquitectura",
            settings = listOf(
                "Film Simulation" to "ACROS + R",
                "Dynamic Range" to "DR200",
                "Highlight" to "+1",
                "Shadow" to "+1",
                "Sharpness" to "0",
                "Grain" to "Strong / Small"
            ),
            tip = "En blanco y negro piensa más en luz, forma y textura que en el color original."
        ),
        Recipe(
            id = "s25_portrait",
            title = "Retrato natural 3x",
            subtitle = "Perspectiva favorecedora y fondo limpio",
            device = CameraDevice.SAMSUNG,
            useFor = "Retrato exterior o interior con buena luz",
            settings = listOf(
                "Lente" to "3x",
                "Modo" to "Foto o Pro",
                "Velocidad mínima" to "1/125 s",
                "ISO" to "Lo más bajo posible",
                "WB" to "Auto o fijo si la luz no cambia",
                "Encuadre" to "Aléjate y evita fondo pegado"
            ),
            tip = "Si falta luz, vuelve a 1x antes de forzar demasiado el ISO."
        ),
        Recipe(
            id = "s25_street",
            title = "Street rápido",
            subtitle = "Respuesta inmediata para calle",
            device = CameraDevice.SAMSUNG,
            useFor = "Calle, viaje, escenas espontáneas",
            settings = listOf(
                "Lente" to "1x o 3x",
                "Modo" to "Foto",
                "Movimiento" to "Prioriza sujetos bien iluminados",
                "Exposición" to "-0.3 EV si hay luces muy fuertes",
                "Composición" to "Usa cuadrícula"
            ),
            tip = "En calle, perder el momento por configurar demasiado es peor que una pequeña imperfección técnica."
        ),
        Recipe(
            id = "s25_night_people",
            title = "Noche con personas",
            subtitle = "Nitidez antes que obsesión por ISO bajo",
            device = CameraDevice.SAMSUNG,
            useFor = "Restaurantes, calle nocturna, eventos",
            settings = listOf(
                "Lente" to "1x",
                "Modo" to "Pro",
                "Velocidad" to "1/125–1/250 s",
                "ISO" to "Auto/ajusta hasta exponer bien",
                "WB" to "Fijo si la luz es estable",
                "RAW" to "Sí si vas a editar"
            ),
            tip = "No bajes demasiado la velocidad para conseguir ISO bajo: las caras movidas no se arreglan en edición."
        ),
        Recipe(
            id = "s25_food",
            title = "Food editorial",
            subtitle = "Textura, volumen y color limpio",
            device = CameraDevice.SAMSUNG,
            useFor = "Restaurantes, producto, redes sociales",
            settings = listOf(
                "Lente" to "1x o 3x",
                "Luz" to "Ventana lateral",
                "Modo" to "Foto / Pro",
                "ISO" to "Bajo",
                "WB" to "Fijo si haces una serie",
                "Ángulo" to "45° o cenital"
            ),
            tip = "Apaga luces de techo verdosas si puedes y trabaja con una fuente lateral dominante."
        ),
        Recipe(
            id = "s25_landscape",
            title = "Paisaje limpio",
            subtitle = "Detalle sin exagerar el procesamiento",
            device = CameraDevice.SAMSUNG,
            useFor = "Paisaje, arquitectura, costa",
            settings = listOf(
                "Lente" to "1x; 0.6x solo si aporta composición",
                "Modo" to "Foto / Expert RAW",
                "ISO" to "Bajo",
                "Exposición" to "Protege el cielo",
                "RAW" to "Sí si hay alto contraste"
            ),
            tip = "Evita usar el ultra gran angular por costumbre: úsalo cuando la perspectiva tenga una razón."
        ),
        Recipe(
            id = "s25_long",
            title = "Larga exposición",
            subtitle = "Luces y movimiento con apoyo",
            device = CameraDevice.SAMSUNG,
            useFor = "Ciudad nocturna, estelas, agua",
            settings = listOf(
                "Modo" to "Pro / Expert RAW",
                "Soporte" to "Trípode o apoyo firme",
                "ISO" to "50–100",
                "Velocidad" to "Empieza en 2 s y ajusta",
                "Temporizador" to "2 s para no mover el móvil",
                "RAW" to "Recomendado"
            ),
            tip = "Si la foto queda demasiado clara, acorta exposición; si queda oscura, alárgala antes de subir ISO."
        )
    )

    val challenges = listOf(
        Challenge(
            id = "freeze_walk",
            title = "Congela a una persona caminando",
            goal = "Entender velocidad de obturación",
            device = null,
            setup = listOf("Empieza en 1/500 s", "Usa AF continuo si está disponible", "Mantén ISO automático al principio"),
            mission = "Haz 10 fotos de alguien caminando lateralmente y hacia ti.",
            success = "Al menos 8 de 10 deben tener rostro y ojos nítidos."
        ),
        Challenge(
            id = "window_portrait",
            title = "Retrato con una ventana",
            goal = "Aprender dirección y suavidad de luz",
            device = null,
            setup = listOf("Coloca al sujeto a 1 m de la ventana", "Apaga luces de techo si mezclan colores", "Fondo separado"),
            mission = "Haz una foto frontal, una lateral y una a contraluz.",
            success = "Debes poder explicar qué dirección de luz favorece más el volumen del rostro."
        ),
        Challenge(
            id = "fuji_afc",
            title = "Seguimiento AF-C",
            goal = "Dominar enfoque continuo en la X-T50",
            device = CameraDevice.FUJI,
            setup = listOf("AF-C", "Detección de cara/ojo", "1/500 s o más", "Ráfaga corta"),
            mission = "Fotografía a una persona caminando hacia cámara durante 5 segundos.",
            success = "Consigue una secuencia con varios fotogramas consecutivos nítidos."
        ),
        Challenge(
            id = "film_compare",
            title = "Tres películas, una escena",
            goal = "Reconocer color Fuji",
            device = CameraDevice.FUJI,
            setup = listOf("Misma luz", "Mismo encuadre", "Misma exposición"),
            mission = "Compara REALA ACE, Classic Chrome y Classic Neg.",
            success = "Escribe qué simulación usarías para retrato, calle y viaje y por qué."
        ),
        Challenge(
            id = "s25_lenses",
            title = "Una persona, cuatro focales",
            goal = "Entender perspectiva en el S25 Ultra",
            device = CameraDevice.SAMSUNG,
            setup = listOf("0.6x", "1x", "3x", "5x"),
            mission = "Mantén el tamaño del rostro parecido moviéndote físicamente entre fotos.",
            success = "Identifica cuál de las focales deforma menos el rostro y cuál cambia más el fondo."
        ),
        Challenge(
            id = "s25_pro_iso",
            title = "ISO bajo presión",
            goal = "Ver el coste real del ISO",
            device = CameraDevice.SAMSUNG,
            setup = listOf("Modo Pro", "1/125 s fija", "Mismo encuadre"),
            mission = "Haz fotos con ISO creciente en una habitación poco iluminada.",
            success = "Detecta en qué punto el ruido empieza a molestarte en pantalla grande."
        ),
        Challenge(
            id = "panning",
            title = "Barrido de movimiento",
            goal = "Combinar sujeto relativamente nítido y fondo movido",
            device = null,
            setup = listOf("Prueba 1/30–1/60 s", "Sigue al sujeto con el cuerpo", "Dispara durante el movimiento"),
            mission = "Haz 20 intentos con una bici, coche o persona caminando rápido.",
            success = "Consigue al menos una foto donde el sujeto domine claramente sobre un fondo barrido."
        ),
        Challenge(
            id = "night_city",
            title = "Ciudad nocturna",
            goal = "Decidir entre ISO y exposición larga",
            device = null,
            setup = listOf("Haz una versión a pulso", "Haz otra con apoyo", "Protege luces"),
            mission = "Fotografía la misma escena con dos estrategias diferentes.",
            success = "Explica cuál tiene menos ruido y cuál habría funcionado si hubiera personas en movimiento."
        ),
        Challenge(
            id = "food_story",
            title = "Mini historia de comida",
            goal = "Crear una serie coherente",
            device = null,
            setup = listOf("Luz lateral", "Plano general", "Plano medio", "Detalle"),
            mission = "Crea una serie de 5 imágenes de un plato o preparación.",
            success = "Las cinco fotos deben parecer parte de la misma historia y mantener color consistente."
        ),
        Challenge(
            id = "final_story",
            title = "Proyecto: 12 fotos que cuentan algo",
            goal = "Unir técnica y narrativa",
            device = null,
            setup = listOf("Elige un tema pequeño", "Planifica inicio, desarrollo y cierre", "Mantén una estética coherente"),
            mission = "Crea una historia fotográfica de 12 imágenes sobre una persona, lugar o actividad.",
            success = "Otra persona debe entender la historia sin que tengas que explicarla."
        )
    )

    val subjects = listOf("Retrato", "Calle", "Paisaje", "Comida", "Noche", "Movimiento")
    val lights = listOf("Mucha luz", "Poca luz")
    val locations = listOf("Exterior", "Interior")

    fun shotPlan(
        device: CameraDevice,
        subject: String,
        light: String,
        location: String
    ): ShotPlan {
        val lowLight = light == "Poca luz"

        val basePlan = when (device) {
            CameraDevice.FUJI -> when (subject) {
                "Retrato" -> ShotPlan(
                    "Retrato con X-T50",
                    "Prioriza ojo nítido, una velocidad segura y separación del fondo.",
                    listOf(
                        "Modo" to "A (prioridad apertura)",
                        "Apertura" to if (lowLight) "La más abierta disponible" else "f/2–f/4 aprox.",
                        "Velocidad mínima" to if (lowLight) "1/125 s" else "1/250 s",
                        "ISO" to "Auto",
                        "AF" to "AF-S quieto / AF-C si se mueve",
                        "Detección" to "Cara/Ojo",
                        "Simulación" to "ASTIA o REALA ACE"
                    ),
                    listOf(
                        "Busca luz lateral suave.",
                        "Separa a la persona del fondo.",
                        "Enfoca el ojo más cercano.",
                        "Comprueba el fondo antes de disparar."
                    ),
                    "Si la persona se mueve, sube velocidad antes de preocuparte por el ISO."
                )
                "Movimiento" -> ShotPlan(
                    "Acción con X-T50",
                    "La prioridad absoluta es congelar o controlar el movimiento.",
                    listOf(
                        "Velocidad" to "1/1000 s para acción rápida",
                        "ISO" to "Auto",
                        "AF" to "AF-C",
                        "Área AF" to "Zona",
                        "Ráfaga" to "Corta",
                        "Apertura" to "Abierta/moderada"
                    ),
                    listOf("Anticipa por dónde pasará el sujeto.", "Empieza a seguir antes de disparar.", "Haz ráfagas cortas.", "Revisa foco, no solo exposición."),
                    "Para barrido creativo cambia a 1/30–1/60 s y acompaña el movimiento."
                )
                "Paisaje" -> ShotPlan(
                    "Paisaje con X-T50",
                    "Busca máxima calidad, composición y control del cielo.",
                    listOf(
                        "Modo" to "A",
                        "Apertura" to "f/5.6–f/8",
                        "ISO" to "Base / Auto bajo",
                        "AF" to "AF-S",
                        "Simulación" to "REALA ACE o Velvia",
                        "RAW" to "RAW+JPEG si el contraste es alto"
                    ),
                    listOf("Busca primer plano.", "Revisa horizonte.", "Protege las altas luces.", "No uses f/16 por sistema."),
                    "Si hay viento, vigila hojas o vegetación: quizá necesites más velocidad."
                )
                "Comida" -> ShotPlan(
                    "Comida con X-T50",
                    "Textura y luz importan más que una apertura extrema.",
                    listOf(
                        "Modo" to "A",
                        "Apertura" to "f/2.8–f/5.6",
                        "Velocidad mínima" to "1/125 s",
                        "ISO" to "Auto",
                        "WB" to "Fijo si haces una serie",
                        "Simulación" to "REALA ACE / ASTIA"
                    ),
                    listOf("Usa una ventana lateral.", "Prueba 45° y cenital.", "Quita objetos que no aportan.", "Acércate para detalles."),
                    "Evita mezclar luz de ventana azul con bombillas cálidas si buscas color limpio."
                )
                "Noche" -> ShotPlan(
                    "Noche con X-T50",
                    "Decide si hay personas o si la escena es estática.",
                    listOf(
                        "Personas" to "1/125–1/250 s",
                        "Escena estática con apoyo" to "1–8 s según luz",
                        "ISO" to "Auto con personas / bajo con trípode",
                        "Apertura" to "Abierta a pulso",
                        "RAW" to "Recomendado",
                        "IBIS" to "Activo a pulso"
                    ),
                    listOf("Expón para las luces importantes.", "Revisa histograma.", "Apóyate si la escena es estática.", "Haz una toma de seguridad."),
                    "IBIS reduce tu movimiento, no congela a una persona que se mueve."
                )
                else -> ShotPlan(
                    "Calle con X-T50",
                    "Necesitas rapidez y una configuración que no te haga perder el momento.",
                    listOf(
                        "Modo" to "A",
                        "Apertura" to "f/4–f/8",
                        "Velocidad mínima" to "1/250 s",
                        "ISO" to "Auto",
                        "AF" to "AF-C si hay movimiento",
                        "Simulación" to "Classic Chrome / REALA ACE"
                    ),
                    listOf("Busca capas y gestos.", "Mantén la cámara preparada.", "Acércate.", "Dispara secuencias cortas cuando ocurra algo."),
                    "No cambies receta cada dos minutos: la consistencia ayuda a construir una serie."
                )
            }

            CameraDevice.SAMSUNG -> when (subject) {
                "Retrato" -> ShotPlan(
                    "Retrato con S25 Ultra",
                    "Usa focal y distancia para favorecer el rostro.",
                    listOf(
                        "Lente" to if (lowLight) "1x" else "3x",
                        "Modo" to "Foto / Pro",
                        "Velocidad" to if (lowLight) "≥ 1/125 s" else "≥ 1/250 s",
                        "ISO" to "Lo necesario para mantener velocidad",
                        "WB" to "Auto; fijo si la luz es estable",
                        "RAW" to "Opcional si editarás"
                    ),
                    listOf("Aléjate del fondo.", "Evita 0.6x cerca del rostro.", "Busca luz lateral.", "Toca el rostro para confirmar foco/exposición."),
                    "En poca luz, 1x suele ser una opción más segura que forzar teleobjetivos."
                )
                "Movimiento" -> ShotPlan(
                    "Acción con S25 Ultra",
                    "Congela primero; experimenta después.",
                    listOf(
                        "Lente" to "1x",
                        "Modo" to "Pro si necesitas fijar velocidad",
                        "Velocidad" to "1/1000 s acción rápida",
                        "ISO" to "Auto/ajusta para exponer",
                        "Ráfaga" to "Úsala cuando sea útil"
                    ),
                    listOf("Mantén al sujeto con buena luz.", "Sigue el movimiento.", "Dispara antes del instante perfecto.", "Revisa nitidez al 100%."),
                    "Si la luz cae mucho, 1/1000 puede obligarte a ISO muy alto; decide cuánto movimiento necesitas congelar."
                )
                "Paisaje" -> ShotPlan(
                    "Paisaje con S25 Ultra",
                    "La composición manda; el ultra gran angular no siempre es mejor.",
                    listOf(
                        "Lente" to "1x; 0.6x con intención",
                        "Modo" to "Foto / Expert RAW",
                        "ISO" to "Bajo",
                        "Exposición" to "Protege altas luces",
                        "RAW" to "Sí en alto contraste"
                    ),
                    listOf("Mantén verticales limpias.", "Añade primer plano.", "Evita zoom digital.", "Haz una versión 1x aunque uses 0.6x."),
                    "El borde del 0.6x puede estirar objetos y personas; úsalo conscientemente."
                )
                "Comida" -> ShotPlan(
                    "Comida con S25 Ultra",
                    "Busca textura, volumen y coherencia de color.",
                    listOf(
                        "Lente" to "1x o 3x",
                        "Modo" to "Foto / Pro",
                        "ISO" to "Bajo",
                        "WB" to "Fijo si haces varias fotos",
                        "Luz" to "Ventana lateral",
                        "Ángulo" to "45° / cenital"
                    ),
                    listOf("Acerca la comida a la luz.", "Elimina luces de techo feas.", "Haz detalle y contexto.", "Revisa reflejos en platos y cubiertos."),
                    "No uses modo retrato si el desenfoque artificial recorta mal platos, vasos o cubiertos."
                )
                "Noche" -> ShotPlan(
                    "Noche con S25 Ultra",
                    "Separa estrategia para personas y escena estática.",
                    listOf(
                        "Personas" to "1x · 1/125 s o más",
                        "Estática" to "Pro / Expert RAW con apoyo",
                        "ISO" to "Bajo con trípode",
                        "Temporizador" to "2 s con apoyo",
                        "RAW" to "Recomendado"
                    ),
                    listOf("Busca superficies donde apoyar.", "Protege neones.", "Haz una toma automática y otra manual.", "Compara ruido y movimiento."),
                    "Una exposición larga solo sirve si lo que quieres nítido permanece quieto."
                )
                else -> ShotPlan(
                    "Calle con S25 Ultra",
                    "Rapidez, discreción y focal adecuada.",
                    listOf(
                        "Lente" to "1x o 3x",
                        "Modo" to "Foto",
                        "EV" to "-0.3 si hay luces fuertes",
                        "Cuadrícula" to "Activa",
                        "RAW" to "Solo si la escena merece edición"
                    ),
                    listOf("Previsualiza el encuadre.", "Evita zoom digital.", "Busca gestos.", "Haz series con focal consistente."),
                    "El móvil es muy rápido: úsalo para momentos espontáneos, no para quedarte atrapada configurando."
                )
            }
        }

        val placeHint = if (location == "Interior") {
            "En interior, vigila la mezcla de luces y busca una ventana o una fuente dominante."
        } else {
            "En exterior, revisa contraluz, sombras duras y dirección del sol antes de cambiar parámetros."
        }

        return basePlan.copy(warning = "${basePlan.warning} $placeHint")
    }
}
