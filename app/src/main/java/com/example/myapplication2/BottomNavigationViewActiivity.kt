package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.core.view.GravityCompat
import com.example.myapplication2.databinding.ActivityBottomNavigationViewBinding
import com.example.myapplication2.databinding.ActivityMainBinding

class BottomNavigationViewActiivity : AppCompatActivity() {
    lateinit var binding : ActivityBottomNavigationViewBinding
//    val ab: ActionBar? = supportActionBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_menu_24)
        binding = ActivityBottomNavigationViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.search -> {
                    Toast.makeText(applicationContext,"Search",Toast.LENGTH_SHORT).show()
                }
                R.id.save -> {
                    Toast.makeText(applicationContext,"Save",Toast.LENGTH_SHORT).show()
                }
                R.id.sync -> {
                    Toast.makeText(applicationContext,"Sync",Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
        binding.apply {
            navMenu.setNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.item1 -> Toast.makeText(this@BottomNavigationViewActiivity, "Item1", Toast.LENGTH_SHORT).show()
                    R.id.subItem1 -> {
                        drawerL.closeDrawer(GravityCompat.START)
                        Toast.makeText(this@BottomNavigationViewActiivity, "subItem1", Toast.LENGTH_SHORT).show() }
                }
                true
            }
            open.setOnClickListener {
                drawerL.openDrawer(GravityCompat.START)
            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> binding.drawerL.openDrawer(GravityCompat.START)
        }
        return true
    }
}