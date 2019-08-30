# m3u-parser

[![GitHub (pre-)release](https://img.shields.io/github/release/BjoernPetersen/m3u-parser/all.svg)](https://github.com/BjoernPetersen/m3u-parser/releases) [![GitHub license](https://img.shields.io/github/license/BjoernPetersen/m3u-parser.svg)](https://github.com/BjoernPetersen/m3u-parser/blob/master/LICENSE) [![FOSSA Status](https://app.fossa.com/api/projects/custom%2B10281%2Fgit%40github.com%3ABjoernPetersen%2Fm3u-parser.git.svg?type=shield)](https://app.fossa.com/projects/custom%2B10281%2Fgit%40github.com%3ABjoernPetersen%2Fm3u-parser.git?ref=badge_shield) [![CircleCI branch](https://img.shields.io/circleci/project/github/BjoernPetersen/m3u-parser/master.svg)](https://circleci.com/gh/BjoernPetersen/m3u-parser/tree/master) [![codebeat badge](https://codebeat.co/badges/1c70981c-b6c5-4829-8fcc-2d3e00738a96)](https://codebeat.co/projects/github-com-bjoernpetersen-m3u-parser-master) [![codecov](https://codecov.io/gh/BjoernPetersen/m3u-parser/branch/develop/graph/badge.svg)](https://codecov.io/gh/BjoernPetersen/m3u-parser)

A M3U parser written in Kotlin.

## Dependency configuration

### Gradle

#### Kotlin DSL

`build.gradle.kts`

```kotlin
dependencies {
    // ...
    implementation("com.github.bjoernpetersen:musicbot:${Lib.M3U_PARSER}")
    // or
    implementation(
        group = "com.github.bjoernpetersen",
        name = "m3u-parser",
        version = Lib.M3U_PARSER)
}
```

#### Groovy DSL

`build.gradle`

```groovy
dependencies {
    // ...
    implementation 'com.github.bjoernpetersen:m3u-parser:$m3uParserVersion'
}
```

### Maven

`pom.xml`

```xml
<dependency>
    <groupId>com.github.bjoernpetersen</groupId>
    <artifactId>m3u-parser</artifactId>
    <version>${m3uParser.version}</version>
</dependency>
```
