package com.example.myapplication2

import android.media.AudioAttributes
import android.media.SoundPool
import android.util.Log
import android.view.View
import android.view.animation.RotateAnimation
import android.widget.Button
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var soundPool: SoundPool
    var soundYa = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var flag = false
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
            .build()

        soundPool = SoundPool.Builder()
            .setAudioAttributes(audioAttributes)
            .setMaxStreams(1)
            .build()

        soundYa = soundPool.load(this, R.raw.ya,1)

        soundPool.setOnLoadCompleteListener{
            soundPool, sampleId, status ->
            Log.d("debug", "sampleId=$sampleId")
            Log.d("debug", "status=$status")
        }

        button.setOnClickListener {

            soundPool.play(soundYa,1.0f,1.0f,0,0,1.0f)

            if (flag) {
                textview.setText(getString(R.string.hello))
                flag = false
            } else {
                textview.setText(getString(R.string.world))
                flag = true

            }
        }
    }
}

//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//}
