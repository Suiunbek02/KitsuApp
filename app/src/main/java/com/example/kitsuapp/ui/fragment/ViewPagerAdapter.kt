package com.example.kitsuapp.ui.fragment

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kitsuapp.ui.fragment.anime.AnimeFragment
import com.example.kitsuapp.ui.fragment.manga.MangaFragment

class ViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                MangaFragment()
            }
            1 -> {
                AnimeFragment()
            }
            else -> {
                throw  Resources.NotFoundException("Not faunt exeption")
            }
        }
    }
}
