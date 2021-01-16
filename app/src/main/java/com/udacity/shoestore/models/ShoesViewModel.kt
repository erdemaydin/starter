package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R

class ShoesViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _shoeAdded = MutableLiveData<Boolean>()
    val shoeAdded: LiveData<Boolean>
        get() = _shoeAdded

    init {
        val items = mutableListOf<Shoe>(
            Shoe(
                "Continental", 44.5, "Adidas", """
            Revel in the nostalgia.
            These adidas Continental 80 shoes capture all the retro vibes of the classic '80s leather trainers.
            The split rubber cupsole and swooping two-tone stripe nail the look.French terry lining completes the throwback feel.
            """.trimIndent(), listOf(R.drawable.adidas_continental)
            ),
            Shoe(
                "AirMax", 44.5, "Nike", """
            The iconic Air Max 90 in a white colourway, featuring a classic running silhouette as well as signature swoosh on the side.
            Complete with a visible AirSole unit and rubber outsole with ribbed pattern for traction.
            """.trimIndent(), listOf(R.drawable.nike_air_max)
            ),
            Shoe(
                "AllStar", 44.5, "Converse", """
            A staple in any wardrobe, the All Star Lo has been low-cut legend since ’57. The Chuck Taylor All Star Low Top trainer keeps it classic. 
            Featuring all the iconic elements like a canvas upper, diamond outsole tread and moulded OrthoLite insole. You got it.
            """.trimIndent(), listOf(R.drawable.converse_all_star)
            ),
            Shoe(
                "Classic", 44.5, "Reebok", """
            Never go out of style. Soft leather upper gives you superior comfort. 
            Die-cut EVA midsole provides lightweight cushioning. Molded PU sockliner adds comfort and durability.
            """.trimIndent(), listOf(R.drawable.reebok_classic)
            )
        )
        _shoeList.value = items
    }

    fun addShoe(shoe: Shoe) {
        _shoeList.value?.add(shoe)
        _shoeAdded.value = true
    }

    fun finish() {
        _shoeAdded.value = false
    }


}