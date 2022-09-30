package com.siddiq.bookhub.adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.siddiq.bookhub.R
import com.siddiq.bookhub.database.BookEntity
import com.squareup.picasso.Picasso

class FavouritesRecyclerAdapter(val context: Context, val bookList: List<BookEntity>) :
    RecyclerView.Adapter<FavouritesRecyclerAdapter.FavouritesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouritesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_favourite_single_row, parent, false)

        return FavouritesViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavouritesViewHolder, position: Int) {
        val book = bookList[position]

        holder.txtBookName.text = book.bookName
        holder.txtBookAuthor.text = book.bookAuthor
        holder.txtBookPrice.text=book.bookPrice
        holder.txtBookRating.text=book.bookRating
        Picasso.get().load(book.bookImage).error(R.drawable.book_two).into(holder.imgBookImage)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    class FavouritesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txtBookName: TextView = view.findViewById(R.id.txtBookNameFav)
        val txtBookAuthor: TextView = view.findViewById(R.id.txtAuthorNameFav)
        val txtBookPrice: TextView = view.findViewById(R.id.txtPriceFav)
        val txtBookRating: TextView = view.findViewById(R.id.txtBookRatingFav)
        val imgBookImage: ImageView = view.findViewById(R.id.imgBookFav)
        val llContent: LinearLayout = view.findViewById(R.id.llFavContent)
    }


}