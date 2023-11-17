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
include(":feature:catalog")
include(":feature:product-details")
include(":common")
include(":common:data")
include(":common:domain")
include(":common:ui")
include(":domain")
