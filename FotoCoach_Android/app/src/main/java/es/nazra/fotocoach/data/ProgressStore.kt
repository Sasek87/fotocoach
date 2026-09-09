package es.nazra.fotocoach.data

import android.content.Context

class ProgressStore(context: Context) {
    private val prefs = context.getSharedPreferences("fotocoach_progress", Context.MODE_PRIVATE)

    fun onboardingDone(): Boolean = prefs.getBoolean("onboarding_done", false)

    fun setOnboardingDone() {
        prefs.edit().putBoolean("onboarding_done", true).apply()
    }

    fun completedLessons(): Set<String> =
        prefs.getStringSet("completed_lessons", emptySet())?.toSet() ?: emptySet()

    fun completedChallenges(): Set<String> =
        prefs.getStringSet("completed_challenges", emptySet())?.toSet() ?: emptySet()

    fun saveLessons(ids: Set<String>) {
        prefs.edit().putStringSet("completed_lessons", ids).apply()
    }

    fun saveChallenges(ids: Set<String>) {
        prefs.edit().putStringSet("completed_challenges", ids).apply()
    }

    fun reset() {
        prefs.edit().clear().apply()
    }
}
