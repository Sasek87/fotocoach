package es.nazra.fotocoach.model

enum class CameraDevice(val label: String, val shortLabel: String) {
    FUJI("Fujifilm X-T50", "X-T50"),
    SAMSUNG("Samsung S25 Ultra", "S25 Ultra")
}

enum class DeviceFilter(val label: String) {
    ALL("Ambas"),
    FUJI("X-T50"),
    SAMSUNG("S25 Ultra")
}

data class Lesson(
    val id: String,
    val title: String,
    val subtitle: String,
    val minutes: Int,
    val level: String,
    val device: CameraDevice? = null,
    val body: List<String>,
    val remember: String,
    val practice: String
)

data class Recipe(
    val id: String,
    val title: String,
    val subtitle: String,
    val device: CameraDevice,
    val useFor: String,
    val settings: List<Pair<String, String>>,
    val tip: String
)

data class Challenge(
    val id: String,
    val title: String,
    val goal: String,
    val device: CameraDevice?,
    val setup: List<String>,
    val mission: String,
    val success: String
)

data class ShotPlan(
    val title: String,
    val explanation: String,
    val settings: List<Pair<String, String>>,
    val steps: List<String>,
    val warning: String
)
