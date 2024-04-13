plugins {
    id("java")
}

group = "com.example"
version = "1.1-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    compileOnly("top.leavesmc.leaves:leaves-api:1.20.4-R0.1-SNAPSHOT")
    compileOnly("net.md-5:bungeecord-chat:1.20-R0.2")
}

tasks.test {
    useJUnitPlatform()
}