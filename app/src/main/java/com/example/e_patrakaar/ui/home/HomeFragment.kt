package com.example.e_patrakaar.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.e_patrakaar.R
import com.example.e_patrakaar.adapters.NewsAdapter
import com.example.e_patrakaar.databinding.FragmentHomeBinding
import com.example.e_patrakaar.models.News
import com.example.e_patrakaar.ui.main.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var newsList: ArrayList<News>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val viewPager: ViewPager = binding.viewPager
        val sectionsPagerAdapter = SectionsPagerAdapter(requireContext(), parentFragmentManager)
        viewPager.adapter = sectionsPagerAdapter
        viewPager.isFocusable = true
        val recyclerView = binding.rv
        newsList = ArrayList()
        newsAdapter = NewsAdapter(requireContext(), newsList)
        recyclerView.adapter = newsAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        newsList.add(News("Lashkar terrorist...WANTED!!", "Patna, Bihar", "20-09-2022 12:16", R.drawable.download))
        newsList.add(News("All cases to be heard by HC from tomorrow", "Delhi", "19-09-2022 19:09", R.drawable.n))
        newsList.add(News("Unmatchable World records of Jhulan Goswami", "India", "19-09-2022 17:00", R.drawable.ne))
        newsList.add(News("One more LOCKDOWN????", "Delhi, India", "18-09-2022 21:53", R.drawable.news))
        newsList.add(News("Patna mein bhari hmla", "Patna, Bihar", "raat ko 11 bje", R.drawable.download))

        val tabLayout : TabLayout = binding.tabs
        tabLayout.setScrollPosition(0, 0f, true)
        viewPager.currentItem = 0
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> recyclerView.visibility = View.VISIBLE
                    1 -> recyclerView.visibility = View.GONE
                    2 -> recyclerView.visibility = View.VISIBLE
                    3 -> Toast.makeText(context, "This is international", Toast.LENGTH_SHORT).show()
                    4 -> Toast.makeText(context, "This is sports", Toast.LENGTH_SHORT).show()
                    5 -> Toast.makeText(context, "This is entertainment", Toast.LENGTH_SHORT).show()
                    6 -> Toast.makeText(context, "This is business", Toast.LENGTH_SHORT).show()
                    7 -> Toast.makeText(context, "This is utility", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        return root
    }

    private fun setTabWidth(tabPosition: Int, weight: Float, tabLayout: TabLayout) {
        val layout: LinearLayout =
            (tabLayout.getChildAt(0) as LinearLayout).getChildAt(tabPosition) as LinearLayout
        val layoutParams: LinearLayout.LayoutParams =
            layout.layoutParams as LinearLayout.LayoutParams
        layoutParams.weight = weight
        layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT
        layout.layoutParams = layoutParams

        val tabLayoutParams: ViewGroup.LayoutParams? = tabLayout.layoutParams
        tabLayoutParams?.width = ViewGroup.LayoutParams.MATCH_PARENT
        tabLayout.layoutParams = tabLayoutParams
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}