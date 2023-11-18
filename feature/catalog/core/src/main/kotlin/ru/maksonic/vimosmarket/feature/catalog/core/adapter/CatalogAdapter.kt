package ru.maksonic.vimosmarket.feature.catalog.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.RequestManager
import ru.maksonic.vimosmarket.feature.catalog.api.ProductUiModel
import ru.maksonic.vimosmarket.feature.catalog.core.databinding.ItemProductBinding

/**
 * @Author maksonic on 16.11.2023
 */
class CatalogAdapter(
    private val onProductClicked: (ProductUiModel) -> Unit,
    private val imageLoader: RequestManager
) : ListAdapter<ProductUiModel, ProductViewHolder>(CatalogItemDiffUtil()) {

    class CatalogItemDiffUtil : DiffUtil.ItemCallback<ProductUiModel>() {
        override fun areItemsTheSame(oldItem: ProductUiModel, newItem: ProductUiModel): Boolean {
            return oldItem.code == newItem.code
        }

        override fun areContentsTheSame(oldItem: ProductUiModel, newItem: ProductUiModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun submitList(list: List<ProductUiModel>?) {
        super.submitList(list ?: emptyList())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(
            view = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onProductClicked = onProductClicked,
            imageLoader = imageLoader
        )

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(this.currentList[position])
    }
}



