/**
 * Shared Kotest library version override.
 *
 * Overrides the kotest version in libs.versions.toml when KOTEST_VERSION env var is set.
 * Apply after the pluginManagement block (and after kotest-plugin-override if using both):
 *
 *   pluginManagement {
 *      repositories { ... }
 *   }
 *
 *   apply(from = "../kotest-plugin-override.settings.gradle.kts")
 *   apply(from = "../kotest-version-override.settings.gradle.kts")
 *
 */

val kotestVersionOverride: String? = System.getenv("KOTEST_VERSION")
val catalogFile = file("${settings.rootDir}/gradle/libs.versions.toml")

settings.dependencyResolutionManagement {
    defaultLibrariesExtensionName.set("defaultLibs")
    versionCatalogs {
        create("libs") {
            from(files(catalogFile))
            if (kotestVersionOverride != null) {
                version("kotest", kotestVersionOverride)
            }
        }
    }
}

