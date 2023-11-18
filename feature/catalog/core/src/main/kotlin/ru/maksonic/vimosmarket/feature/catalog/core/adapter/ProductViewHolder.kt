package ru.maksonic.vimosmarket.feature.catalog.core.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.maksonic.vimosmarket.feature.catalog.api.ProductUiModel
import ru.maksonic.vimosmarket.feature.catalog.core.R
import ru.maksonic.vimosmarket.common.ui.R.string.title_product_price
import ru.maksonic.vimosmarket.feature.catalog.core.databinding.ItemProductBinding

/**
 * @Author maksonic on 16.11.2023
 */
class ProductViewHolder(
    private val view: ItemProductBinding,
    private val imageLoader: RequestManager,
    private val onProductClicked: (ProductUiModel) -> Unit,
) : RecyclerView.ViewHolder(view.root) {

    fun bind(product: ProductUiModel) = with(view) {
        name.text = product.name
        price.text = root.context.getString(title_product_price, product.price)
        code.text = root.context.getString(R.string.title_product_code, product.code)
        imageLoader.load(product.imageLink).into(image)

        card.setOnClickListener { onProductClicked(product) }
    }
}