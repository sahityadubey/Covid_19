package com.techienest.who.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.techienest.who.adapters.ViewPagerAdapter
import com.techienest.who.constants.StringConstant
import com.techienest.who.databinding.ActivityHomeBinding
import com.techienest.who.fragments.FirstViewFragment
import com.techienest.who.fragments.SecondViewFragment


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewPager(binding.viewPager)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FirstViewFragment())
        adapter.addFragment(SecondViewFragment())

        viewPager.pageMargin = 30
        viewPager.adapter = adapter

        binding.tabLayout.setupWithViewPager(viewPager, true)
    }
}
