import java.util.Properties

plugins {
    id("java-library")
    id("eclipse")
    id("idea")
    id("maven-publish")
    id("net.neoforged.gradle.userdev") version "7.0.97"
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.serialization") version "1.9.23"
}

val mod_version: String by project
val mod_group_id: String by project
val mod_id: String by project

project.version = mod_version
project.group = mod_group_id

repositories {
    mavenLocal()
    maven {
        name = "Kotlin for Forge"
        setUrl("https://thedarkcolour.github.io/KotlinForForge/")
    }
    maven { setUrl("https://maven.shedaniel.me") }
    maven {
        name = "GeckoLib"
        setUrl("https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/")
        content {
            includeGroupByRegex("software\\.bernie.*")
            includeGroup("com.eliotlash.mclib")
        }
    }
    exclusiveContent {
        forRepository {
            maven {
                name = "Modrinth"
                setUrl("https://api.modrinth.com/maven")
            }
        }
        filter {
            includeGroup("maven.modrinth")
        }
    }
}

base {
    archivesName.set(mod_id)
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

//minecraft.accessTransformers.file rootProject.file("src/main/resources/META-INF/accesstransformer.cfg")
//minecraft.accessTransformers.entry public net.minecraft.client.Minecraft textureManager # textureManager

runs {
    configureEach {
        systemProperty("forge.logging.markers", "REGISTRIES")
        systemProperty("forge.logging.console.level", "debug")

        modSource(project.sourceSets.getByName("main"))
    }

    register("client") {
        systemProperty("forge.enabledGameTestNamespaces", mod_id)
    }

    register("server") {
        systemProperty("forge.enabledGameTestNamespaces", mod_id)
        programArgument("--nogui")
    }

    register("gameTestServer") {
        systemProperty("forge.enabledGameTestNamespaces", mod_id)
    }

    register("data") {
        programArguments.addAll(listOf("--mod", mod_id, "--all", "--output", file("src/generated/resources/").absolutePath, "--existing", file("src/main/resources/").absolutePath))
    }
}

sourceSets {
    main {
        resources.srcDir("src/generated/resources")
    }
}


dependencies {
    val minecraft_version: String by project
    val neo_version: String by project
    val kff_version: String by project
    val rei_version: String by project
    val jade_version: String by project
    val geckolib_version: String by project

    implementation("net.neoforged:neoforge:$neo_version")
    implementation("thedarkcolour:kotlinforforge-neoforge:$kff_version")
    implementation("software.bernie.geckolib:geckolib-neoforge-$minecraft_version:$geckolib_version")

    runtimeOnly("me.shedaniel:RoughlyEnoughItems-neoforge:$rei_version")
    runtimeOnly("maven.modrinth:nvQzSEkH:$jade_version")
}

tasks.withType<ProcessResources>().configureEach {
    val loadedProperties = Properties().apply {
        load(project.rootProject.file("gradle.properties").inputStream())
    }.toMutableMap() as MutableMap<String, Any>

    inputs.properties(loadedProperties)

    filesMatching("META-INF/mods.toml") {
        expand(loadedProperties)
        expand(mutableMapOf("project" to project))
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
    repositories {
        maven(url = "file://${project.projectDir}/repo")
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
