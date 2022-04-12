package com.gulsahozaltun.lottiee

import android.content.Intent
import android.graphics.drawable.Animatable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.animation.Animation
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import com.airbnb.lottie.Lottie
import com.airbnb.lottie.LottieDrawable
import com.gulsahozaltun.lottiee.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var button=findViewById<Button>(R.id.button)


        button.setOnClickListener{
            //setupAnim()
            showSuccessDialog()
        }
    }

/*

    private fun setupAnim() {
        binding.animationView.setAnimation(R.raw.success)
        binding.animationView.repeatCount = LottieDrawable.INFINITE
        binding.animationView.playAnimation()
    }
*/



    fun showSuccessDialog() {
        val layoutView = LayoutInflater.from(this)
            .inflate(R.layout.success_order, null, false)
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setView(layoutView)
        val alertDialog = dialogBuilder.create()

        val timer = object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                alertDialog.show()
                alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            }

            override fun onFinish() {
                alertDialog.dismiss()
                var gecis=Intent(this@MainActivity,MainActivity2::class.java)
                startActivity(gecis)
            }
        }
        timer.start()
    }
}