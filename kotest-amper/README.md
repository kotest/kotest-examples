# kotest-amper

Example project showing how to use [Kotest](https://kotest.io) with
[Amper](https://github.com/JetBrains/amper) instead of Gradle or Maven.

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
    release: 17
  junit: junit-5

test-dependencies:
  - io.kotest:kotest-runner-junit5:6.1.10
  - io.kotest:kotest-assertions-core:6.1.10
  - io.kotest:kotest-framework-engine:6.1.10
```

This example targets Kotlin **2.3.20** and Amper **0.10.0**.

## Running tests

```
./amper test
```

The first invocation downloads the Amper distribution into a local cache.
