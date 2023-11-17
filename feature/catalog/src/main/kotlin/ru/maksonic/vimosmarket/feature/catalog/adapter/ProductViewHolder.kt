package ru.maksonic.vimosmarket.feature.catalog.adapter

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
        with(view) {
            name.text = product.name
            price.text = product.price.toString()
            code.text = product.code.toString()
            imageLoader.load(product.imageLink).into(productImage)

            card.setOnClickListener { onProductClicked(product) }
        }
    }
}