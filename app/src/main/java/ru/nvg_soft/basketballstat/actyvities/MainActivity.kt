package ru.nvg_soft.basketballstat.actyvities


import android.content.pm.ActivityInfo
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.nvg_soft.basketballstat.R
import ru.nvg_soft.basketballstat.fragments.ReportFragment
import ru.nvg_soft.basketballstat.fragments.SettingsFragment
import ru.nvg_soft.basketballstat.fragments.EventFragment
import ru.nvg_soft.basketballstat.fragments.PersonFragment


class MainActivity : AppCompatActivity() {
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_event -> {
                val fragment =
                    EventFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true

            }
            R.id.navigation_person -> {
                val fragment =
                    PersonFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_reports -> {
                val fragment =
                    ReportFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {
                val fragment =
                    SettingsFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        val fragment = EventFragment()
        addFragment(fragment)
    }
   private fun addFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.simpleName)
            .commit()
    }



}
