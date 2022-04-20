package co.pacastrillonp.qrgeneratordummy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.pacastrillonp.qrgeneratordummy.databinding.ActivityMainBinding
import co.pacastrillonp.qrgeneratordummy.util.DefaultBitmapUtil
import com.google.zxing.MultiFormatWriter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bitmapUtil = DefaultBitmapUtil(MultiFormatWriter())

        binding.button.setOnClickListener {

            val width = 500
            val height = 500

            val bitmap = bitmapUtil.generateQRCode(width, height, binding.editText.text.toString())

            binding.imageView.setImageBitmap(bitmap)
        }
    }

}