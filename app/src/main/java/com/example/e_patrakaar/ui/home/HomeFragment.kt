package com.example.e_patrakaar.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.e_patrakaar.databinding.FragmentHomeBinding
import com.example.e_patrakaar.ui.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

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
//        val sectionsPagerAdapter = SectionsPagerAdapter(requireContext(), parentFragmentManager)
//        viewPager.adapter = sectionsPagerAdapter
        viewPager.isFocusable = true

        val tabLayout : TabLayout = binding.tabs
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> Toast.makeText(context, "This is home", Toast.LENGTH_SHORT).show()
                    1 -> Toast.makeText(context, "This is sports", Toast.LENGTH_SHORT).show()
                    2 -> Toast.makeText(context, "This is health", Toast.LENGTH_SHORT).show()
                    3 -> Toast.makeText(context, "This is science", Toast.LENGTH_SHORT).show()
                    4 -> Toast.makeText(context, "This is entertainment", Toast.LENGTH_SHORT).show()
                    5 -> Toast.makeText(context, "This is technology", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })


        //To set different width for a tab.
        setTabWidth(0, 0.7f, tabLayout)
        setTabWidth(1, 0.7f, tabLayout)
        setTabWidth(2, 0.7f, tabLayout)
        setTabWidth(3, 0.7f, tabLayout)
        setTabWidth(4, 1.0f, tabLayout)
        setTabWidth(5, 1.0f, tabLayout)

        return root
    }


    //Function to set different width for a tab.
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