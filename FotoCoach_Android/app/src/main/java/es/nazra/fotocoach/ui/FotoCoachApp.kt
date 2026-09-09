package es.nazra.fotocoach.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import es.nazra.fotocoach.data.ProgressStore
import es.nazra.fotocoach.data.SampleData
import es.nazra.fotocoach.model.*
import androidx.compose.ui.platform.LocalContext

private enum class MainTab(val label: String, val icon: String) {
    HOME("Inicio", "⌂"),
    LEARN("Aprende", "◫"),
    SHOOT("Dispara", "◎"),
    RECIPES("Recetas", "◈"),
    CHALLENGES("Retos", "✓")
}

@Composable
fun FotoCoachApp() {
    val context = LocalContext.current
    val store = remember { ProgressStore(context) }

    var onboardingDone by remember { mutableStateOf(store.onboardingDone()) }
    var completedLessons by remember { mutableStateOf(store.completedLessons()) }
    var completedChallenges by remember { mutableStateOf(store.completedChallenges()) }

    if (!onboardingDone) {
        OnboardingScreen {
            store.setOnboardingDone()
            onboardingDone = true
        }
        return
    }

    var tab by remember { mutableStateOf(MainTab.HOME) }
    var lessonDetail by remember { mutableStateOf<Lesson?>(null) }
    var recipeDetail by remember { mutableStateOf<Recipe?>(null) }
    var challengeDetail by remember { mutableStateOf<Challenge?>(null) }

    when {
        lessonDetail != null -> LessonDetailScreen(
            lesson = lessonDetail!!,
            done = lessonDetail!!.id in completedLessons,
            onBack = { lessonDetail = null },
            onToggleDone = {
                val id = lessonDetail!!.id
                completedLessons = if (id in completedLessons) completedLessons - id else completedLessons + id
                store.saveLessons(completedLessons)
            }
        )

        recipeDetail != null -> RecipeDetailScreen(
            recipe = recipeDetail!!,
            onBack = { recipeDetail = null }
        )

        challengeDetail != null -> ChallengeDetailScreen(
            challenge = challengeDetail!!,
            done = challengeDetail!!.id in completedChallenges,
            onBack = { challengeDetail = null },
            onToggleDone = {
                val id = challengeDetail!!.id
                completedChallenges = if (id in completedChallenges) completedChallenges - id else completedChallenges + id
                store.saveChallenges(completedChallenges)
            }
        )

        else -> Scaffold(
            bottomBar = {
                NavigationBar {
                    MainTab.entries.forEach { item ->
                        NavigationBarItem(
                            selected = tab == item,
                            onClick = { tab = item },
                            icon = { Text(item.icon, style = MaterialTheme.typography.titleLarge) },
                            label = { Text(item.label) }
                        )
                    }
                }
            }
        ) { padding ->
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                when (tab) {
                    MainTab.HOME -> HomeScreen(
                        completedLessons = completedLessons,
                        completedChallenges = completedChallenges,
                        onLearn = { tab = MainTab.LEARN },
                        onShoot = { tab = MainTab.SHOOT },
                        onRecipes = { tab = MainTab.RECIPES },
                        onChallenges = { tab = MainTab.CHALLENGES },
                        onReset = {
                            store.reset()
                            completedLessons = emptySet()
                            completedChallenges = emptySet()
                            onboardingDone = false
                        }
                    )
                    MainTab.LEARN -> LearnScreen(
                        completedLessons = completedLessons,
                        onLesson = { lessonDetail = it }
                    )
                    MainTab.SHOOT -> ShootAssistantScreen()
                    MainTab.RECIPES -> RecipesScreen(onRecipe = { recipeDetail = it })
                    MainTab.CHALLENGES -> ChallengesScreen(
                        completedChallenges = completedChallenges,
                        onChallenge = { challengeDetail = it }
                    )
                }
            }
        }
    }
}

@Composable
private fun OnboardingScreen(onStart: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 36.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Spacer(Modifier.height(24.dp))
        Text("FOTOCOACH", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)
        Text(
            "De cero a fotógrafa\nsemi-profesional.",
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold
        )
        Text(
            "Entrenamiento práctico para tu Fujifilm X‑T50 y tu Samsung S25 Ultra. Aprende un concepto, dispara, revisa y repite.",
            style = MaterialTheme.typography.bodyLarge
        )

        FeatureCard("📷", "Dos cámaras, un solo método", "Aprende qué equipo usar, cómo configurarlo y por qué.")
        FeatureCard("🎯", "Ejercicios con ajustes", "Cada lección termina con una misión concreta.")
        FeatureCard("🎨", "Recetas y presets", "Configuraciones listas para Fuji y Samsung, con contexto de uso.")
        FeatureCard("◎", "Asistente de disparo", "Dile qué quieres fotografiar y obtén una configuración de partida.")

        Spacer(Modifier.height(8.dp))
        Button(onClick = onStart, modifier = Modifier.fillMaxWidth()) {
            Text("Empezar desde cero")
        }
        Text(
            "Consejo: deja activado RAW+JPEG cuando practiques algo importante. Así puedes comparar el resultado directo con el revelado posterior.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun FeatureCard(icon: String, title: String, text: String) {
    Card {
        Row(
            Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.Top
        ) {
            Text(icon, style = MaterialTheme.typography.headlineMedium)
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(title, fontWeight = FontWeight.Bold)
                Text(text, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Composable
private fun HomeScreen(
    completedLessons: Set<String>,
    completedChallenges: Set<String>,
    onLearn: () -> Unit,
    onShoot: () -> Unit,
    onRecipes: () -> Unit,
    onChallenges: () -> Unit,
    onReset: () -> Unit
) {
    val total = SampleData.lessons.size + SampleData.challenges.size
    val done = completedLessons.size + completedChallenges.size
    val progress = if (total == 0) 0f else done.toFloat() / total

    LazyColumn(
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text("FotoCoach", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)
            Text("Tu entrenamiento fotográfico", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
            Text("Hoy no necesitas aprenderlo todo. Solo una cosa y una foto mejor.", style = MaterialTheme.typography.bodyLarge)
        }

        item {
            Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)) {
                Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text("Progreso global", fontWeight = FontWeight.Bold)
                    LinearProgressIndicator(progress = { progress }, modifier = Modifier.fillMaxWidth())
                    Text("$done de $total entrenamientos completados")
                }
            }
        }

        item {
            Text("¿Qué quieres hacer?", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        }

        item {
            QuickAction("🎓", "Aprender", "Lecciones de 5–13 min") { onLearn() }
        }
        item {
            QuickAction("◎", "Quiero hacer una foto", "Configuración según escena") { onShoot() }
        }
        item {
            QuickAction("🎨", "Recetas y presets", "Fuji C1–C7 + configuraciones S25") { onRecipes() }
        }
        item {
            QuickAction("✓", "Retos prácticos", "Demuestra que sabes hacerlo") { onChallenges() }
        }

        item {
            Card {
                Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Tu regla de oro", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Text("Si el sujeto se mueve, protege primero la velocidad. Una foto con algo de ruido se puede trabajar; una cara movida no.")
                }
            }
        }

        item {
            TextButton(onClick = onReset) {
                Text("Reiniciar progreso y onboarding")
            }
        }
    }
}

@Composable
private fun QuickAction(icon: String, title: String, subtitle: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            Modifier.padding(18.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(icon, style = MaterialTheme.typography.headlineMedium)
            Column(Modifier.weight(1f)) {
                Text(title, fontWeight = FontWeight.Bold)
                Text(subtitle, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            Text("›", style = MaterialTheme.typography.headlineSmall)
        }
    }
}

@Composable
private fun LearnScreen(
    completedLessons: Set<String>,
    onLesson: (Lesson) -> Unit
) {
    var filter by remember { mutableStateOf(DeviceFilter.ALL) }
    val filtered = SampleData.lessons.filter { lesson ->
        when (filter) {
            DeviceFilter.ALL -> true
            DeviceFilter.FUJI -> lesson.device == null || lesson.device == CameraDevice.FUJI
            DeviceFilter.SAMSUNG -> lesson.device == null || lesson.device == CameraDevice.SAMSUNG
        }
    }

    LazyColumn(
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text("Aprende", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
            Text("Teoría corta. Práctica obligatoria.", style = MaterialTheme.typography.bodyLarge)
        }
        item {
            DeviceFilterRow(filter = filter, onChange = { filter = it })
        }
        items(filtered, key = { it.id }) { lesson ->
            val done = lesson.id in completedLessons
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onLesson(lesson) }
            ) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            lesson.level,
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.weight(1f)
                        )
                        if (done) Text("✓ Hecha", color = MaterialTheme.colorScheme.primary)
                    }
                    Text(lesson.title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Text(lesson.subtitle, maxLines = 2, overflow = TextOverflow.Ellipsis)
                    Text("${lesson.minutes} min", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        }
    }
}

@Composable
private fun DeviceFilterRow(filter: DeviceFilter, onChange: (DeviceFilter) -> Unit) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        DeviceFilter.entries.forEach { item ->
            FilterChip(
                selected = filter == item,
                onClick = { onChange(item) },
                label = { Text(item.label) }
            )
        }
    }
}

@Composable
private fun LessonDetailScreen(
    lesson: Lesson,
    done: Boolean,
    onBack: () -> Unit,
    onToggleDone: () -> Unit
) {
    Scaffold(
        topBar = {
            DetailTopBar(title = "Lección", onBack = onBack)
        }
    ) { padding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(lesson.level, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
            Text(lesson.title, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
            Text(lesson.subtitle, style = MaterialTheme.typography.bodyLarge)

            lesson.body.forEach { paragraph ->
                Text(paragraph, style = MaterialTheme.typography.bodyLarge)
            }

            Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text("QUÉ DEBES RECORDAR", style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Bold)
                    Text(lesson.remember)
                }
            }

            Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text("EJERCICIO", style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Bold)
                    Text(lesson.practice)
                }
            }

            Button(onClick = onToggleDone, modifier = Modifier.fillMaxWidth()) {
                Text(if (done) "Marcar como pendiente" else "Completar lección")
            }
        }
    }
}

@Composable
private fun ShootAssistantScreen() {
    var device by remember { mutableStateOf(CameraDevice.FUJI) }
    var subject by remember { mutableStateOf(SampleData.subjects.first()) }
    var light by remember { mutableStateOf(SampleData.lights.first()) }
    var location by remember { mutableStateOf(SampleData.locations.first()) }
    var showPlan by remember { mutableStateOf(false) }

    val plan = SampleData.shotPlan(device, subject, light, location)

    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Quiero hacer una foto", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
        Text("Elige la situación. Te doy una configuración de partida y qué debes mirar.")

        ChoiceSection(
            title = "1. Cámara",
            options = CameraDevice.entries.map { it.label },
            selected = device.label,
            onSelect = { label -> device = CameraDevice.entries.first { it.label == label }; showPlan = false }
        )
        ChoiceSection(
            title = "2. Sujeto",
            options = SampleData.subjects,
            selected = subject,
            onSelect = { subject = it; showPlan = false }
        )
        ChoiceSection(
            title = "3. Luz",
            options = SampleData.lights,
            selected = light,
            onSelect = { light = it; showPlan = false }
        )
        ChoiceSection(
            title = "4. Lugar",
            options = SampleData.locations,
            selected = location,
            onSelect = { location = it; showPlan = false }
        )

        Button(onClick = { showPlan = true }, modifier = Modifier.fillMaxWidth()) {
            Text("Dame la configuración")
        }

        if (showPlan) {
            ShotPlanCard(plan)
        }
    }
}

@Composable
private fun ChoiceSection(
    title: String,
    options: List<String>,
    selected: String,
    onSelect: (String) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(title, fontWeight = FontWeight.Bold)
        options.forEach { option ->
            FilterChip(
                selected = option == selected,
                onClick = { onSelect(option) },
                label = { Text(option) }
            )
        }
    }
}

@Composable
private fun ShotPlanCard(plan: ShotPlan) {
    Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)) {
        Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(plan.title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Text(plan.explanation)

            Text("CONFIGURACIÓN", style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Bold)
            plan.settings.forEach { (key, value) ->
                SettingRow(key, value)
            }

            HorizontalDivider()
            Text("PASOS", style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Bold)
            plan.steps.forEachIndexed { index, step ->
                Text("${index + 1}. $step")
            }

            Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)) {
                Text(
                    "⚠ ${plan.warning}",
                    modifier = Modifier.padding(14.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
private fun RecipesScreen(onRecipe: (Recipe) -> Unit) {
    var device by remember { mutableStateOf(CameraDevice.FUJI) }
    val recipes = SampleData.recipes.filter { it.device == device }

    LazyColumn(
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text("Recetas y presets", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
            Text("Guarda configuraciones que resuelvan una intención, no filtros al azar.")
        }
        item {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                CameraDevice.entries.forEach {
                    FilterChip(
                        selected = device == it,
                        onClick = { device = it },
                        label = { Text(it.shortLabel) }
                    )
                }
            }
        }
        items(recipes, key = { it.id }) { recipe ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onRecipe(recipe) }
            ) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(recipe.title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Text(recipe.subtitle)
                    Text("Para: ${recipe.useFor}", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        }
    }
}

@Composable
private fun RecipeDetailScreen(recipe: Recipe, onBack: () -> Unit) {
    Scaffold(topBar = { DetailTopBar("Receta", onBack) }) { padding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(recipe.device.label, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
            Text(recipe.title, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
            Text(recipe.subtitle, style = MaterialTheme.typography.bodyLarge)
            Text("Úsala para: ${recipe.useFor}")

            Card {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    recipe.settings.forEach { (key, value) -> SettingRow(key, value) }
                }
            }

            Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)) {
                Text("Consejo: ${recipe.tip}", modifier = Modifier.padding(16.dp))
            }

            Text(
                "Los valores son puntos de partida. La luz, el objetivo y la escena pueden exigir cambios.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun SettingRow(key: String, value: String) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(key, modifier = Modifier.weight(0.42f), fontWeight = FontWeight.SemiBold)
        Text(value, modifier = Modifier.weight(0.58f))
    }
}

@Composable
private fun ChallengesScreen(
    completedChallenges: Set<String>,
    onChallenge: (Challenge) -> Unit
) {
    var filter by remember { mutableStateOf(DeviceFilter.ALL) }

    val filtered = SampleData.challenges.filter { challenge ->
        when (filter) {
            DeviceFilter.ALL -> true
            DeviceFilter.FUJI -> challenge.device == null || challenge.device == CameraDevice.FUJI
            DeviceFilter.SAMSUNG -> challenge.device == null || challenge.device == CameraDevice.SAMSUNG
        }
    }

    LazyColumn(
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text("Retos", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
            Text("No subes de nivel por leer. Subes cuando eres capaz de hacerlo.")
        }
        item { DeviceFilterRow(filter, onChange = { filter = it }) }

        items(filtered, key = { it.id }) { challenge ->
            val done = challenge.id in completedChallenges
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onChallenge(challenge) }
            ) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Row {
                        Text(challenge.goal, color = MaterialTheme.colorScheme.primary, modifier = Modifier.weight(1f))
                        if (done) Text("✓")
                    }
                    Text(challenge.title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Text(challenge.mission, maxLines = 2, overflow = TextOverflow.Ellipsis)
                }
            }
        }
    }
}

@Composable
private fun ChallengeDetailScreen(
    challenge: Challenge,
    done: Boolean,
    onBack: () -> Unit,
    onToggleDone: () -> Unit
) {
    Scaffold(topBar = { DetailTopBar("Reto", onBack) }) { padding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(challenge.goal, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
            Text(challenge.title, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)

            Card {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("CONFIGURA", style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Bold)
                    challenge.setup.forEach { Text("• $it") }
                }
            }

            Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("MISIÓN", style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Bold)
                    Text(challenge.mission)
                }
            }

            Text("Sabes que lo has conseguido cuando:", fontWeight = FontWeight.Bold)
            Text(challenge.success)

            Button(onClick = onToggleDone, modifier = Modifier.fillMaxWidth()) {
                Text(if (done) "Marcar como pendiente" else "Reto superado")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DetailTopBar(title: String, onBack: () -> Unit) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            TextButton(onClick = onBack) {
                Text("‹ Volver")
            }
        }
    )
}
