pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "employee list app exmaple"
include(":app")
include(":core-domain-employee-list")
include(":core-domain")
include(":core-unit-tests-employee-list-sample-data")
include(":core-domain-employee-list-entities")
