package com.siddiq.bookhub.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.siddiq.bookhub.R
import com.siddiq.bookhub.activity.DescriptionActivity
import com.siddiq.bookhub.model.Book
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class DashboardRecyclerAdapter(val context: Context, val itemList: ArrayList<Book>) :
    RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>() {

    class DashboardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtBookName: TextView = view.findViewById(R.id.txtBookName)
        val txtAuthor: TextView = view.findViewById(R.id.txtAuthor)
        val txtPrice: TextView = view.findViewById(R.id.txtPrice)
        val txtRating: TextView = view.findViewById(R.id.txtRating)
        val rlContent: RelativeLayout = view.findViewById(R.id.rlContent)
        val imgBook: ImageView = view.findViewById(R.id.imgBook)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_dashboard_single_row, parent, false)
        return DashboardViewHolder(view)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val book = itemList[position]
        holder.txtBookName.text = book.bookName
        holder.txtAuthor.text = book.bookAuthor
        holder.txtPrice.text = book.bookPrice
        holder.txtRating.text = book.bookRating
        Picasso.get().load(book.bookImage).error(R.drawable.book).into(holder.imgBook)

        holder.rlContent.setOnClickListener {
            val intent = Intent(context, DescriptionActivity::class.java)
            intent.putExtra("book_id", book.bookId)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}