package com.example.resources

import android.graphics.drawable.Animatable2
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var flag = RIGHT_SHARE_FLAG

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_animation.setOnClickListener {
            imageViewAnimation.animationStart()
        }
    }

    private fun ImageView.animationStart() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            (background as Animatable2).apply {
                start()
                registerAnimationCallback(object : Animatable2.AnimationCallback(){
                    override fun onAnimationEnd(drawable: Drawable?) {
                        if (flag == RIGHT_SHARE_FLAG) {
                            background = getDrawable(R.drawable.avd_share_right)
                            flag = SHARE_RIGHT_FLAG
                        } else if (flag == SHARE_RIGHT_FLAG) {
                            background = getDrawable(R.drawable.avd_right_share)
                            flag = RIGHT_SHARE_FLAG
                        }
                    }
                })
            }
        }
    }

    companion object {
        private const val RIGHT_SHARE_FLAG = 0
        private const val SHARE_RIGHT_FLAG = 1
    }
}

