package com.example.kitsuapp.ui.fragment.manga

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapp.R
import com.example.kitsuapp.base.BaseFragment
import com.example.kitsuapp.databinding.FragmentKitsuBinding
import com.example.kitsuapp.ui.adapter.MangaAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MangaFragment : BaseFragment<FragmentKitsuBinding, MangaViewModel>(R.layout.fragment_kitsu) {

    override val binding by viewBinding(FragmentKitsuBinding::bind)
    override val viewModel: MangaViewModel by viewModels()
    private val mangaAdapter = MangaAdapter()

    override fun initialize() {
        binding.KitsuRecView.apply {
            binding.KitsuRecView.layoutManager = GridLayoutManager(requireContext(), 3)
            binding.KitsuRecView.layoutManager = layoutManager
            adapter = mangaAdapter
        }
    }

    override fun setupSubscribes() {
        viewModel.fetchKitsu().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                mangaAdapter.submitData(it)
            }
        }
    }
}