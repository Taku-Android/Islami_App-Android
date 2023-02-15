package com.example.android.islami_app.setting

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.android.islami_app.HomeActivity
import com.example.android.islami_app.R
import com.example.android.islami_app.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    lateinit var binding: FragmentSettingsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        switchModeLogic()
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    fun switchModeLogic() {

        binding.activeDarkMode.isChecked =
            AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES

        val sharedPreferences = requireContext().getSharedPreferences("sp", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()



        binding.activeDarkMode.setOnClickListener {

            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.activeDarkMode.text = "Light"
                editor.putString("mode", "light")
                editor.apply()
//                restartActivity()
            } else {
                binding.activeDarkMode.text = "Dark"
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                editor.putString("mode", "dark")
                editor.apply()
//                restartActivity()
            }
//            requireActivity().supportFragmentManager.beginTransaction()
//                .replace(R.id.framFragment, SettingsFragment()).commit()
            restartActivity()
        }
    }


    private fun restartActivity() {
        val i = Intent(requireContext(), HomeActivity::class.java)
        startActivity(i)
        requireActivity().finish()

    }

}