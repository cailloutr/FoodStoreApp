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
import com.example.foodstoreapp.R
import com.example.foodstoreapp.databinding.FragmentHomeBinding
import com.example.foodstoreapp.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
    }
}