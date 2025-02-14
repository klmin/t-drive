rootProject.name = "t-drive"

include(
    "drive-bootstrap",
    "drive-api",
    "drive-domain",
    "drive-application",
    "drive-infra:persistence",
    "drive-infra:storage"
)

pluginManagement {

    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings

    plugins {
        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version springDependencyManagementVersion
    }
}

