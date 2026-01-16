/**
 * Shared Kotest plugin version override.
 *
 * Overrides the io.kotest Gradle plugin version when KOTEST_VERSION env var is set.
 * Apply after the pluginManagement block:
 *
 *   pluginManagement {
 *      repositories { ... }
 *   }
 *
 *   apply(from = "../kotest-plugin-override.settings.gradle.kts")
 *   apply(from = "../kotest-version-override.settings.gradle.kts")
 */

val kotestVersionOverride: String? = System.getenv("KOTEST_VERSION")
if (kotestVersionOverride != null) {
    settings.pluginManagement {
        resolutionStrategy {
            eachPlugin {
                if (requested.id.id == "io.kotest") {
                    useVersion(kotestVersionOverride)
                }
            }
        }
    }
}

