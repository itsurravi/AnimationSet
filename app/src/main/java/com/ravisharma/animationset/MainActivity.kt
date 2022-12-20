package com.ravisharma.animationset

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.ravisharma.animationset.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val animatorSet = AnimatorSet().apply {
            playSequentially(
                slideUpFadeInAnimation(binding.text1),
                slideUpFadeInAnimation(binding.text2, false),
                slideUpFadeInAnimation(binding.text3),
                slideUpFadeInAnimation(binding.text4),
            )
        }
        animatorSet.start()
    }

    private fun slideUpFadeInAnimation(v: View, shouldShow: Boolean = true): ValueAnimator {
        val fadeInProperty = PropertyValuesHolder.ofFloat("alpha", 0f, 1f)
        val slideUpProperty = PropertyValuesHolder.ofFloat("translationY", 60f, 0f)

        val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(
            v,
            fadeInProperty,
            slideUpProperty
        )
        objectAnimator.duration = 250
        objectAnimator.interpolator = LinearInterpolator()

        return objectAnimator
    }
}