plugins {
    id("java")
    id("io.freefair.lombok") version "8.14"
    id("io.quarkus") version "3.22.2"
}

val quarkusVersion = "3.22.2"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    //---------------------------------------------------------------------------------
    //Nivel Avanzado - reto 2
    implementation(enforcedPlatform("io.quarkus.platform:quarkus-bom:${quarkusVersion}"))
    implementation("io.quarkus:quarkus-arc") //CDI
    implementation("io.quarkus:quarkus-rest") //REST
    implementation("io.quarkus:quarkus-rest-jsonb")
    implementation("io.quarkus:quarkus-hibernate-orm-panache") //JPA
    implementation("io.quarkus:quarkus-jdbc-postgresql")

    //---------------------------------------------------------------------------------
    //Nivel Medio - reto 3
    implementation("org.xerial:sqlite-jdbc:3.50.2.0")
    implementation("commons-beanutils:commons-beanutils:1.11.0")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}

