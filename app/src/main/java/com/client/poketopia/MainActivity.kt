package com.client.poketopia

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.client.HomeActivity
import com.client.poketopia.databinding.ActivityMainBinding

class MainActivity : Activity() {
    private lateinit var binding: ActivityMainBinding
    private val TAG = MainActivity::class.java.simpleName
    private val MAX_PROGRESS = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition{false}
        actionBar?.hide()
        simulateProgress()
    }

    private fun simulateProgress(){
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(object: Runnable{
            var currentProgress = 0
            override fun run() {
                currentProgress += 5
                binding.pbStartApp.progress = currentProgress
                if (currentProgress < MAX_PROGRESS){
                    handler.postDelayed(this, 1500)
                }else{
                    moveToHome()
                }
            }

        }, 1500)
    }

    private fun moveToHome(){
        startActivity(
            HomeActivity.newIntent(this@MainActivity)
        )
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
    }
}
