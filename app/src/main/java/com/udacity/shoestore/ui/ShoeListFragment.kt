package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeItemBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.ShoesViewModel

class ShoeListFragment : Fragment() {

    private val shoesViewModel: ShoesViewModel by activityViewModels()
    private lateinit var shoeListBinding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shoeListBinding = FragmentShoeListBinding.inflate(inflater, container, false)

        shoesViewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            shoeList.forEach { shoe ->
                val shoeItemBinding = FragmentShoeItemBinding.inflate(inflater, container, false)
                shoeItemBinding.shoe = shoe
                shoeListBinding.shoeList.addView(shoeItemBinding.root)
            }
        })

        shoeListBinding.addShoe.setOnClickListener { navigateDetailScreen() }

        setHasOptionsMenu(true)

        return shoeListBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    private fun navigateDetailScreen() {
        findNavController()
            .navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.logout_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
        return super.onOptionsItemSelected(item)
    }

}