package com.example.week04day04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView


var bottomNav:BottomNavigationView? = null
var frameLayout:FrameLayout? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        connectVs()
        bottomNavClicks()
    }



    private fun connectVs() {
       bottomNav = findViewById(R.id.bottomNav)
        frameLayout= findViewById(R.id.fcontainer)
    }
    private fun fragmentChoose(fragment:Fragment,tag:String) {
   val fragmentTransaction:FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fcontainer,fragment,tag)
        fragmentTransaction.addToBackStack(tag)
       fragmentTransaction.commit()
    }
    private fun bottomNavClicks() {
        bottomNav?.setOnItemSelectedListener {
         when(it.itemId){
            R.id.home ->{
                fragmentChoose(homeFragment(),"Home")
            }
             R.id.setting ->{
                 fragmentChoose(SettingsFragment(),"Setting")
             }
             R.id.profile ->{
                 fragmentChoose(ProfileFragment(),"Profile")
             }
             R.id.dash ->{
                 fragmentChoose(DashFragment(),"Dash")
             }
         }
            true
        }

    }


}