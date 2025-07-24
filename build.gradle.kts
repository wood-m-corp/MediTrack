plugins {
    java
    application
    id("org.javamodularity.moduleplugin") version "1.8.12"
    id("org.openjfx.javafxplugin") version "0.0.13"
    id("org.beryx.jlink") version "3.0.1"
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val junitVersion = "5.10.2"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

application {
    mainModule.set("com.example.code")
    mainClass.set("com.example.code.Main")
}

javafx {
    version = "21"
    modules = listOf("javafx.controls", "javafx.fxml")
}

dependencies {
    implementation("org.controlsfx:controlsfx:11.2.1")
    implementation("org.kordamp.bootstrapfx:bootstrapfx-core:0.4.0")
    implementation("org.xerial:sqlite-jdbc:3.50.3.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

jlink {
    imageZip.set(layout.buildDirectory.file("distributions/app-${javafx.platform.classifier}.zip"))
    options.set(listOf("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages"))

    launcher {
        name = "MediTrack"
    }

    jpackage {
        installerType = "msi" // Or "dmg", "pkg", "msi", "deb", "rpm", etc.
        installerName = "MediTrack-Installer"
        appVersion = "1.0.0"
        vendor = "Group7"
        installerOptions.addAll(listOf(
        "--win-dir-chooser",    // lets user pick install dir
        "--win-menu",           // adds Start Menu shortcut
        "--win-shortcut"        // creates desktop shortcut
    ))
        // icon = "src/main/resources/icon.ico"
    }
}