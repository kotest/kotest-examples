# kotest-kotlin-toolchain

Example project showing how to use [Kotest](https://kotest.io) with the
[Kotlin Toolchain](https://github.com/JetBrains/kotlin-toolchain) (formerly Amper) instead of Gradle or Maven.

## Configuration

The whole build is described by a single [`module.yaml`](./module.yaml). Kotest is
wired in through `test-dependencies`, and the JUnit 5 platform is enabled via
`settings.junit: junit-5` so the Kotest JUnit5 runner can discover tests.

```yaml
product: jvm/lib

settings:
  kotlin:
    version: 2.3.20
  jvm:
    release: 21
  junit: junit-5

test-dependencies:
  - io.kotest:kotest-runner-junit5:6.2.3
  - io.kotest:kotest-assertions-core:6.2.3
  - io.kotest:kotest-framework-engine:6.2.3
  - org.junit.jupiter:junit-jupiter:6.0.3
```

This example targets Kotlin **2.3.20** and Kotlin Toolchain **0.13.0**.

## Running tests

```
./kotlin test
```

The first invocation downloads the Kotlin Toolchain distribution into a local cache.

## Migrating from Amper

Amper was renamed to the Kotlin Toolchain in 0.11. The `module.yaml` format is unchanged; only the wrapper
scripts changed, from `amper` / `amper.bat` to `kotlin` / `kotlin.bat`. Use `./kotlin update` to move to a
newer Kotlin Toolchain version.
