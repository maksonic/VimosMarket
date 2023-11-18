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
        object Core : AbstractModule(
            path = ":common:core",
            namespace = "ru.maksonic.vimosmarket.common.core"
        )

        object Ui : AbstractModule(
            path = ":common:ui",
            namespace = "ru.maksonic.vimosmarket.common.ui"
        )
    }

    object Data : AbstractModule(
        path = ":data",
        namespace = "ru.maksonic.vimosmarket.data"
    )

    object Domain : AbstractModule(
        path = ":domain",
        namespace = "ru.maksonic.vimosmarket.domain"
    )

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
        object Catalog {
            object Api : AbstractModule(
                path = ":feature:catalog:api",
                namespace = "ru.maksonic.vimosmarket.feature.catalog.api"
            )

            object Core : AbstractModule(
                path = ":feature:catalog:core",
                namespace = "ru.maksonic.vimosmarket.feature.catalog.core"
            )
        }

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