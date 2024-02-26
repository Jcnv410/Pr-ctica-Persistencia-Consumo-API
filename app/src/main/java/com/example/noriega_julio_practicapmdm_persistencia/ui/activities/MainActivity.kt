package com.example.noriega_julio_practicapmdm_persistencia.ui.activities


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.noriega_julio_practicapmdm_persistencia.R
import com.example.noriega_julio_practicapmdm_persistencia.ui.fragments.AllTasksFragment
import com.example.noriega_julio_practicapmdm_persistencia.ui.fragments.ModuleTasksFragment
import com.example.noriega_julio_practicapmdm_persistencia.ui.fragments.HomeFragment
import com.example.noriega_julio_practicapmdm_persistencia.ui.fragments.AddTasksFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    HomeFragment()
                ).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_all_tasks -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    AllTasksFragment()
                ).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_modules -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    ModuleTasksFragment()
                ).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_add_tasks -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    AddTasksFragment()
                ).commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        // Muestra el fragmento de tareas al inicio
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            HomeFragment()
        ).commit()
    }
}
