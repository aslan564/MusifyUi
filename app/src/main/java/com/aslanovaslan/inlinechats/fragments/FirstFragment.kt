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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aslanovaslan.inlinechats.R
import com.aslanovaslan.inlinechats.adapter.PlayerItemAdapter
import com.aslanovaslan.inlinechats.adapter.RecyclerViewAdapter
import com.aslanovaslan.inlinechats.model.PlayerModel
import com.aslanovaslan.inlinechats.viewModel.PlayerViewModel
import kotlinx.android.synthetic.main.fragment_first.*


@Suppress("DEPRECATION")
class FirstFragment : Fragment() {
    private lateinit var viewModel: PlayerViewModel
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var playerItemAdapter: PlayerItemAdapter

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
        viewModel = ViewModelProvider(this).get(PlayerViewModel::class.java)
        viewModel.addDummyData()

        viewModel.currentPlayerList.observe(viewLifecycleOwner, Observer {
            if (it == null) return@Observer
            it.let {
                playerItemAdapter = PlayerItemAdapter(it)
                playerCardRecyclerCard.adapter = playerItemAdapter
                playerItemAdapter.notifyDataSetChanged()
            }
        })
        viewModel.currentPlayerMusicList.observe(viewLifecycleOwner, Observer {
            if (it == null) return@Observer
            it.let {
                recyclerViewAdapter = RecyclerViewAdapter(it)
                recyclerView.adapter = recyclerViewAdapter
                recyclerViewAdapter.notifyDataSetChanged()
            }
        })

        playerCardRecyclerCard.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            startNestedScroll(0, ViewCompat.TYPE_NON_TOUCH)
        }


        recyclerView.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            startNestedScroll(0, ViewCompat.TYPE_NON_TOUCH)
        }


       /* recyclerViewAdapter.registerAdapterDataObserver(object :
            RecyclerView.AdapterDataObserver() {
            override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
                super.onItemRangeChanged(positionStart, itemCount)
            }

            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                super.onItemRangeInserted(positionStart, itemCount)

                val msgCount = recyclerViewAdapter.itemCount
                val lastVisiblePosition = LinearLayoutManager(
                    this@FirstFragment.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                    .findLastCompletelyVisibleItemPosition()

                if (lastVisiblePosition == -1 || positionStart >= msgCount - 1 &&
                    lastVisiblePosition == positionStart - 1
                ) {
                    recyclerView.scrollToPosition(positionStart)
                } else {
                    recyclerView.scrollToPosition(recyclerViewAdapter.itemCount - 1);
                }
            }
        })*/


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