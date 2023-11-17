package ru.maksonic.vimosmarket.feature.catalog.core.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.maksonic.vimosmarket.feature.catalog.core.ProductUiModel
import ru.maksonic.vimosmarket.feature.catalog.databinding.ItemProductBinding

/**
 * @Author maksonic on 16.11.2023
 */
class ProductViewHolder(
    private val view: ItemProductBinding,
    private val imageLoader: RequestManager,
    private val onProductClicked: (ProductUiModel) -> Unit,
) : RecyclerView.ViewHolder(view.root) {

    fun bind(product: ProductUiModel) {
        view.name.text = product.name
        view.price.text = product.price.longValueExact().toString()
        view.code.text = product.name

        view.card.setOnClickListener {
            onProductClicked(product)
        }
    }
}