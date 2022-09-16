package com.example.foodstoreapp.ui.menu

import android.os.Bundle
import android.view.ContextMenu
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import com.example.foodstoreapp.R
import com.example.foodstoreapp.databinding.FragmentHomeBinding
import com.example.foodstoreapp.databinding.FragmentMenuBinding
import com.example.foodstoreapp.ui.home.*

const val TAG = "MenuFragment"
class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    private var filters = listOf<FilterItem>(
        FilterItem(1, "Pizza", icon = R.drawable.ic_pizza_svgrepo_com),
        FilterItem(2, "Lasagna", icon = R.drawable.ic_lasagna_svgrepo_com),
        FilterItem(3, "Drinks", icon = R.drawable.ic_drink_svgrepo_com),
        FilterItem(4, "More", icon = R.drawable.ic_rice_svgrepo_com),
        FilterItem(5, "Promo")
    )

    private val viewModel: MenuViewModel by lazy {
        val activity = requireNotNull(this.activity)

        ViewModelProvider(
            this,
            MenuViewModelFactory(activity.application))[MenuViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val toolbar: Toolbar = binding.menuToolBar
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.apply {
            title = getString(R.string.title_menu)
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = this@MenuFragment
            menuViewModel = viewModel
            rvMenuItems.adapter = ItemListAdapter( MENU_ITEM, ItemListener { })
        }

        binding.let {
            filters.forEach { filterItem ->
                it.chipGroup.addView(filterItem.toChip(requireContext()))
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

