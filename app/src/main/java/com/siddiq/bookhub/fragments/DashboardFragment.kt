package com.siddiq.bookhub.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.siddiq.bookhub.R
import com.siddiq.bookhub.adapter.DashboardRecyclerAdapter
import com.siddiq.bookhub.model.Book

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class DashboardFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    lateinit var recyclerDashboard: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager


    lateinit var recyclerAdapter: DashboardRecyclerAdapter

    val bookInfoList = arrayListOf<Book>(
        Book("Don Quixote"," Miguel de Cervantes", "4.5", "Rs 799"),
        Book("Lord of the Rings", "J.R.R. Tolkien", "4.3", "Rs 499"),
        Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "4.8", "Rs 999"),
        Book("And Then There Were None", "Agatha Christie", "4.6", "Rs 599"),
        Book("Alice's Adventures in Wonderland", "Lewis Carroll", "4.2", "Rs 399"),
        Book("The Lion, the Witch, and the Wardrobe", " C.S. Lewis", "4.4", "Rs 490"),
        Book("Pinocchio", "Carlo Collodi", "4.6", "Rs 699"),
        Book("Catcher in the Rye", "J.D. Salinger", "4.2", "Rs 299"),
        Book("Anne of Green Gables", " L. M. Montgomery", "4.4", "599"),
        Book("Twenty Thousand Leagues Under the Sea", "Jules Verne", "4.8", "899")
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        recyclerDashboard = view.findViewById(R.id.recyclerDashboard)

        layoutManager = LinearLayoutManager(activity)//activity is context here

        recyclerAdapter = DashboardRecyclerAdapter(activity as Context, bookInfoList)

        recyclerDashboard.adapter = recyclerAdapter
        recyclerDashboard.layoutManager = layoutManager

        return view
    }


}