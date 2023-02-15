package com.example.android.islami_app

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import com.example.android.islami_app.Hadeth.HadethFragment
import com.example.android.islami_app.Quran.QuranFragment
import com.example.android.islami_app.Sebha.SebhaFragment
import com.example.android.islami_app.databinding.HomeContentBinding
import com.example.android.islami_app.radio.RadioFragment
import com.example.android.islami_app.setting.SettingsFragment
import java.util.prefs.Preferences

class HomeActivity : AppCompatActivity() {

    lateinit var binding: HomeContentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*

        editor = sp.edit()

        editor.putString("KEY" , "HI")
        */

        val sharedPreferences = getSharedPreferences("sp", Context.MODE_PRIVATE)
        var mode = sharedPreferences.getString("mode", "")






        setCurrentFragment(QuranFragment())

        binding.includ.bottomNavView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.quran_icon -> setCurrentFragment(QuranFragment())
                R.id.hadeth_icon -> setCurrentFragment(HadethFragment())
                R.id.sebha_icon -> setCurrentFragment(SebhaFragment())
                R.id.radio_icon -> setCurrentFragment(RadioFragment())
                R.id.setting_icon -> setCurrentFragment(SettingsFragment())
            }
            true
        }

    }

    private fun setCurrentFragment(firstFragment: Fragment) {

        supportFragmentManager.beginTransaction().replace(R.id.framFragment, firstFragment).commit()

    }


    private fun restartActivity() {
        val i = Intent(baseContext, HomeActivity::class.java)
        startActivity(i)
        finish()
    }

}