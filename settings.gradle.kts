pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "VimosMarket"
include(":app")
include(":navigation")
include(":navigation:router")
include(":navigation:graph")
include(":feature")
include(":feature:onboarding")
include(":feature:catalog:api")
include(":feature:catalog:core")
include(":feature:product-details")
include(":common:core")
include(":common:ui")
include(":domain")
include(":data")
