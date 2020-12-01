package com.platzi.conf.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.platzi.conf.R
import android.content.Intent
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splashscreen.*

class SplashscreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        val animacion = AnimationUtils.loadAnimation(this, R.anim.animacion)
        ivLogo.startAnimation(animacion)

        val intent = Intent(this, MainActivity::class.java)

        animacion.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                startActivity(intent)
                finish()
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

        })
    }
}
