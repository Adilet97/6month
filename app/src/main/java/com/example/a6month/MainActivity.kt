package com.example.a6month

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.a6month.databinding.ActivityMainBinding
@Suppress("DEPRECATED_IDENTITY_EQUALS")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var launchForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode === RESULT_OK) {
            val text = result.data?.getStringExtra("result")
            binding.editText.setText(text)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            if (binding.editText.text.isNotEmpty()) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("key.fly", binding.editText.text.toString())
                launchForResult.launch(intent)
            } else {
                Toast.makeText(this, "This field can not be empty", Toast.LENGTH_LONG).show()
            }
        }
    }
}