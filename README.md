# openehr-term-4j [![Stability: Experimental](https://masterminds.github.io/stability/experimental.svg)](https://masterminds.github.io/stability/experimental.html)

This repository contains the source code for Maven packages with Java interface declarations for the classes defined by the respective specification of the openEHR TERM component.

## Dependencies

- [JRE](https://en.wikipedia.org/wiki/Java_(software_platform)#Java_Runtime_Environment) 8+

## Usage

The "openehr-term-4j" packages are published to [GitHub Packages](https://github.com/features/packages).
So, even though they are publicly available, projects that want to apply those packages need a GitHub access token with the "read:packages" scope.
How to create such an access token is described here: [docs.github.com](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token).

### Maven

For projects that use Maven as build management tool, the personal GitHub access token and "openehr-term-4j" GitHub package repository should be added to the global Maven settings.

<details>
  <summary><code>~/.m2/settings.xml</code></summary>
<br>

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd">
  <activeProfiles>
    <activeProfile>github</activeProfile>
  </activeProfiles>
  <profiles>
    <profile>
      <id>github</id>
      <repositories>
        <repository>
          <id>central</id>
          <url>https://repo1.maven.org/maven2</url>
        </repository>
        <repository>
          <id>github</id>
          <url>https://maven.pkg.github.com/openehr4j/openehr-term-4j</url>
          <snapshots>
            <enabled>true</enabled>
          </snapshots>
        </repository>
      </repositories>
    </profile>
  </profiles>
  <servers>
    <server>
      <id>github</id>
      <username>USERNAME</username>
      <password>TOKEN</password>
    </server>
  </servers>
</settings>
```

</details> 

Then the dependencies to the "openehr-term-4j" packages can be declared inside the Project Object Model.

<details>
  <summary><code>/path/to/project/pom.xml</code></summary>
<br>

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <properties>
        <openehr.term.version>2.4.0-alpha-5</openehr.term.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>com.experimental-software.term</groupId>
            <artifactId>support-terminology-api</artifactId>
            <version>${openehr.term.version}</version>
        </dependency>
    </dependencies>

</project>
```

</details> 

**Also see**

- [Working with the Apache Maven registry | docs.github.com](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry)

### Gradle

For projects that use Gradle as build management tool, the personal GitHub username and access token should be added to the global Gradle properties.

<details>
  <summary><code>~/.gradle/gradle.properties</code></summary>
<br>

```properties
gpr.user=USERNAME
gpr.key=TOKEN
```

</details> 

After the registration of the GitHub Maven repository, the dependency on the required package can be declared as for any other Maven package.

<details>
  <summary><code>/path/to/project/build.gradle</code></summary>
<br>

```groovy
repositories {
    maven {
        url = uri('https://maven.pkg.github.com/openehr4j/openehr-term-4j')
        credentials {
            username = project.findProperty('gpr.user')
            password = project.findProperty('gpr.key')
        }
    }
}

ext['openehrTermVersion'] = '2.4.0-alpha-5'

dependencies {
    implementation "com.experimental-software.term:support-terminology-api:${openehrTermVersion}"
}
```

</details> 

**Also see**

- [Working with the Gradle registry | docs.github.com](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-gradle-registry)

### Version number scheme

The "openehr-term-4j" package version number consists of two parts: (1) the version number of the corresponding openEHR component and (2) a package-specific suffix. Those two parts are separated by the first hyphen.

The suffix has four different types:

1. `alpha`: releases for development tests
2. `beta`: release candidates for system tests
3. `RELEASE`: official Package for corresponding openEHR component version
4. `RELEASE-patch`: if necessary, bug fixes for the released package

Except for the `RELEASE` which is terminal, each type is followed by another hyphen and then an integer number that gets incremented with every new release.

## Development

### Publish to Maven Local

```
./gradlew publishToMavenLocal
find ~/.m2/repository/com/experimental-software
```

## Maintenance

### Publish to GitHub Packages

The packages are automatically published after the creation of a new GitHub release.

## References

- https://specifications.openehr.org/releases/TERM
- https://github.com/openEHR/specifications-TERM
