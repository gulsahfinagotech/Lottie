package com.gulsahozaltun.lottiee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.google.android.material.datepicker.MaterialDatePicker
import com.gulsahozaltun.lottiee.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private val rotateOpenAnimation: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim)}
    private val rotateCloseAnimation: Animation by lazy {AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim)}
    private val fromBottomAnimation: Animation by lazy {AnimationUtils.loadAnimation(this, R.anim.front_bottom_anim)}
    private val toBottomAnimation: Animation by lazy {AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim)}
    private var clicked=false
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.floatingActionButton.setOnClickListener {
            onAddButtonClicked()
        }


        binding.floatingActionButton2.setOnClickListener {
            Toast.makeText(this, "tıklandı", Toast.LENGTH_SHORT).show()
        }

        binding.customButton.setOnClickListener {
            Toast.makeText(this,"buton çalışıyor",Toast.LENGTH_SHORT).show()
        }

    }
    private fun onAddButtonClicked(){
        setVisibility(clicked)
        setAnimation(clicked)
        clicked = !clicked
    }

    private fun setAnimation(clicked:Boolean) {
        if (!clicked){
            binding.floatingActionButton2.visibility= View.VISIBLE
            binding.floatingActionButton3.visibility= View.VISIBLE
        }
        else{
            binding.floatingActionButton2.visibility= View.INVISIBLE
            binding.floatingActionButton3.visibility= View.INVISIBLE
        }

    }

    private fun setVisibility(clicked: Boolean) {
        if (!clicked) {
            binding.floatingActionButton2.startAnimation(fromBottomAnimation)
            binding.floatingActionButton3.startAnimation(fromBottomAnimation)
            binding.floatingActionButton.startAnimation(rotateOpenAnimation)
        }
            else{
            binding.floatingActionButton2.startAnimation(toBottomAnimation)
            binding.floatingActionButton3.startAnimation(toBottomAnimation)
            binding.floatingActionButton.startAnimation(rotateCloseAnimation)
            }
        }
    }
