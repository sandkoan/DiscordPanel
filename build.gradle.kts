plugins {
    kotlin("jvm") version "1.3.72"
    id("org.jetbrains.intellij") version "0.6.5"
}


group = "org.dblanovschi.DiscordPanel"
version = "0.1.4"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(group = "junit", name = "junit", version = "4.12")
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version = "2020.3.1"
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "11"
            languageVersion = "1.3"
            apiVersion = "1.3"
        }
    }
    patchPluginXml {
        sinceBuild("202.6397.94")
        changeNotes(
        """
        - Allow plugin to be run in 2020.3(203.* builds) <br/>
        """.trimMargin())
    }

    runPluginVerifier {
        setIdeVersions(listOf("IIC-2020.2.4", "IIC-2020.3.1"))
    }
}
