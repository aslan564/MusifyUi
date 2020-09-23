package com.aslanovaslan.inlinechats.fragments

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aslanovaslan.inlinechats.R
import com.aslanovaslan.inlinechats.adapter.RecyclerViewAdapter
import com.aslanovaslan.inlinechats.model.PlayerModel
import kotlinx.android.synthetic.main.fragment_first.*


@Suppress("DEPRECATION")
class FirstFragment : Fragment() {

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
   // private lateinit var sharedpreferences: SharedPreferences.Editor
    private lateinit var playerModel: ArrayList<PlayerModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        playerModel = arrayListOf()
        for (i in 0 until 50) {
            if (i % 2 == 0) {
                playerModel.add(PlayerModel("Guitar", R.drawable.ic_guitar,R.drawable.ic_guitar_background_last))
            } else {
                playerModel.add(PlayerModel("Violin", R.drawable.ic_violin,R.drawable.ic_violin_background))
            }
        }
        recyclerViewAdapter = RecyclerViewAdapter(playerModel)
        val layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = recyclerViewAdapter
        recyclerViewAdapter.notifyDataSetChanged()
        recyclerView.startNestedScroll(0,ViewCompat.TYPE_NON_TOUCH)
        //recyclerView.smoothScrollBy(scroll.pos(),0,scroll.delay());

        recyclerViewAdapter.registerAdapterDataObserver(object :RecyclerView.AdapterDataObserver(){
            override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
                super.onItemRangeChanged(positionStart, itemCount)
            }
            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                super.onItemRangeInserted(positionStart, itemCount)

                val msgCount = recyclerViewAdapter.itemCount
                val lastVisiblePosition =
                    layoutManager.findLastCompletelyVisibleItemPosition()

                if (lastVisiblePosition == -1 || positionStart >= msgCount - 1 &&
                    lastVisiblePosition == positionStart - 1) {
                    recyclerView.scrollToPosition(positionStart)
                } else {
                    recyclerView.scrollToPosition(recyclerViewAdapter.itemCount - 1);
                }
            }
        })
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    @SuppressLint("CommitPrefEdits")
    override fun onDestroy() {
        super.onDestroy()

      /*  val editor = sharedpreferences.edit()
        editor!!.putInt(LAST_POSITION, last_position)
        editor.apply()*/
    }
}