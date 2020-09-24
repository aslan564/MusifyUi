package com.aslanovaslan.inlinechats.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aslanovaslan.inlinechats.R
import com.aslanovaslan.inlinechats.model.PlayerCardModel
import com.aslanovaslan.inlinechats.model.PlayerModel

class PlayerViewModel : ViewModel() {
    private val playerCardModel = ArrayList<PlayerCardModel>()
    private var playerModel = ArrayList<PlayerModel>()
    val currentPlayerList = MutableLiveData<ArrayList<PlayerCardModel>>()
    val currentPlayerMusicList = MutableLiveData<ArrayList<PlayerModel>>()
    fun addDummyData() {
        for (i in 0 until 50) {
            if (i % 2 == 0) {
                playerCardModel.add(
                    PlayerCardModel("Ladas", "Dan Broownn", "30")
                )
                playerModel.add(
                    PlayerModel(
                        "Guitar", R.drawable.ic_guitar, R.drawable.ic_guitar_background_last
                    )
                )
            } else {
                playerCardModel.add(
                    PlayerCardModel("Lunnaya Sonata", "Motsart or Bethowen", "30")
                )
                playerModel.add(
                    PlayerModel(
                        "Violin",
                        R.drawable.ic_violin,
                        R.drawable.ic_violin_background
                    )
                )
            }
            currentPlayerList.value = playerCardModel
            currentPlayerMusicList.value = playerModel
        }
    }

}