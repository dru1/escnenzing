plugins {
    java
    id("maven-publish")
    war
    id("org.springframework.boot") version "2.2.4.RELEASE"
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://repo.spring.io/libs-release")
}

dependencies {
    // Wicket
    implementation("org.apache.wicket:wicket-core:8.7.0")
    implementation("org.apache.wicket:wicket-auth-roles:8.7.0")
    implementation("org.apache.wicket:wicket-spring:8.7.0")
    implementation("org.apache.wicket:wicket-extensions:8.7.0")
    implementation("org.apache.wicket:wicket-devutils:8.7.0")

    // Spring
    implementation("org.springframework.boot:spring-boot-starter-web:2.2.4.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.2.4.RELEASE")

    // Databases
    implementation("org.hsqldb:hsqldb:2.5.0")
    implementation("mysql:mysql-connector-java:8.0.19")

    // Utils
    implementation("com.google.code.findbugs:jsr305:3.0.2")
    implementation("com.google.guava:guava:28.2-jre")
    implementation("org.apache.commons:commons-lang3:3.9")

    // Tests
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.2.4.RELEASE")

    // Spring Boot
    providedCompile("org.springframework.boot:spring-boot-starter-tomcat:2.2.4.RELEASE")

    // JPA
    annotationProcessor("org.hibernate:hibernate-jpamodelgen:5.4.10.Final")
}

group = "at.dru"
version = "0.0.1-SNAPSHOT"
description = "at.dru.wicketblog"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["web"])
        }
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.bootRun {
    main = "at.dru.wicketblog.WebApplication"
}
