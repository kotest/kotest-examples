# kotest-examples

This repo contains multiple examples of how to use Kotest.

## Projects

* [JVM](./kotest-jvm) &mdash; example of a JVM project
* [Multiplatform](./kotest-multiplatform) &mdash; example of a multiplatform project with JVM, JS and Native modules
* [Javscript](./kotest-javascript) &mdash; example of a JavaScript project
* [Native](./kotest-native) &mdash; example of a native project with Linux, Windows and Mac targets
* [Spring Webflux](./kotest-spring-webflux) &mdash; example of a JVM project using Spring Webflux
* [Allure](./kotest-allure) &mdash; example of a JVM project using Allure test reporting
* [Wasm](./kotest-wasm) &mdash; example of a Wasm project
* [Android](./kotest-android) &mdash; example of an Android project
* [Gradle-test-retry](./kotest-gradle-retry) &mdash; example of a project using the [Gradle test retry](https://github.com/gradle/test-retry-gradle-plugin) plugin.

## Overriding Kotest Version

All modules support overriding the Kotest version via the `KOTEST_VERSION` environment variable. 
This is useful for CI workflows that need to test against a specific or newly-built Kotest version.

```bash
# Run tests with a specific Kotest version
cd kotest-jvm
KOTEST_VERSION=6.0.3 ./gradlew test

# Or for any other module
cd kotest-multiplatform
KOTEST_VERSION=6.1.0 ./gradlew test
```

When no override is provided, each module uses the version from its `gradle/libs.versions.toml`.

