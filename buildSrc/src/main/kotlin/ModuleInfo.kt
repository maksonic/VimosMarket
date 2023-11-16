import org.gradle.api.JavaVersion

/**
 * @Author maksonic on 27.09.2023
 */
sealed class AbstractModule(val path: String, val namespace: String)

object ModuleInfo {
    object App : AbstractModule(
        path = ":app",
        namespace = "ru.maksonic.vimosmarket"
    )

    object Common {
        object Data : AbstractModule(
            path = ":common:data",
            namespace = "ru.maksonic.vimosmarket.common.data"
        )

        object Domain : AbstractModule(
            path = ":common:domain",
            namespace = "ru.maksonic.vimosmarket.common.domain"
        )

        object Ui : AbstractModule(
            path = ":common:ui",
            namespace = "ru.maksonic.vimosmarket.common.ui"
        )
    }

    object Navigation {
        object Graph : AbstractModule(
            path = ":navigation:graph",
            namespace = "ru.maksonic.vimosmarket.navigation.graph"
        )

        object Router : AbstractModule(
            path = ":navigation:router",
            namespace = "ru.maksonic.vimosmarket.navigation.router"
        )
    }

    object Feature {
        object Catalog : AbstractModule(
            path = ":feature:catalog",
            namespace = "ru.maksonic.vimosmarket.feature.catalog"
        )

        object Onboarding : AbstractModule(
            path = ":feature:onboarding",
            namespace = "ru.maksonic.vimosmarket.feature.onboarding"
        )

        object ProductDetails : AbstractModule(
            path = ":feature:product-details",
            namespace = "ru.maksonic.vimosmarket.feature.product_details"
        )
    }
}