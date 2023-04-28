package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.myapplication2.databinding.ActivityFragmentBinding
import androidx.fragment.app.Fragment

class Fragment : AppCompatActivity() {
    lateinit var binding : ActivityFragmentBinding
    private val dataModel : DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        openFrag(R.id.place_holder, BlankFragment.newInstance())
        openFrag(R.id.place_holder2, BlankFragment2.newInstance())
        dataModel.messageForActivity.observe(this) { name ->
            binding.textView4.text = name
        }

        //кнопка запуска второго фрагмента
//        binding.bFrag2.setOnClickListener{
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.place_holder, BlankFragment2.newInstance())
//                .commit()
//        }
    }

    private fun openFrag(idHolder: Int, f: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}