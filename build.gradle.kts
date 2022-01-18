plugins {
    java
}
// ???
group = "one.empty3"
version = "1.0-SNAPSHOT"
repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    // https://mvnrepository.com/artifact/one.empty3/features
    implementation ("one.empty3:features:2022.1.3")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}