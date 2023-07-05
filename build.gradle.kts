plugins {
	id("java")
	id("org.springframework.boot") version "3.1.0"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.cgi"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	testImplementation("org.mockito:mockito-core:5.2.0")
	implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
	/* implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.2") */
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude("org.junit.vintage:junit-vintage-engine")
	}

	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-actuator")

	implementation("io.rest-assured:rest-assured:5.3.0")


	// OpenApi/Swagger documentation
	implementation("org.springdoc:springdoc-openapi-ui:1.6.15")

	runtimeOnly("com.h2database:h2")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
