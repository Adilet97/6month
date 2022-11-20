package com.example.a6month

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a6month.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val text = intent.getStringExtra("key.fly")
        binding.editText.setText(text)
        initListeners()
    }
    private fun initListeners() {
        binding.button.setOnClickListener {
            val intent = Intent()
            intent.putExtra("result",binding.editText.text.toString())
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}