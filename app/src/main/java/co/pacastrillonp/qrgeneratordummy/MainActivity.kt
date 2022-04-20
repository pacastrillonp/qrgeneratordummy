package co.pacastrillonp.qrgeneratordummy

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import co.pacastrillonp.qrgeneratordummy.databinding.ActivityMainBinding
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
//            val bitmap = generateQR(binding.editText.text.toString())
//            val bitmap = generateQR("https://login.arkbox.co/Spa/login?sc=AC6YE4L3")
            val bitmap = generateQR("LUISA_SE_CASA_CONMIGO?")
            binding.imageView.setImageBitmap(bitmap)
        }
    }

    private fun generateQR(url: String): Bitmap {
        val width = 500
        val height = 500
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

        val codeWriter = MultiFormatWriter()

        try {
            val bitMatrix = codeWriter.encode(url, BarcodeFormat.QR_CODE, width, height)

            for (x in 0 until width) {
                for (y in 0 until height) {
                    bitmap.setPixel(x, y, if (bitMatrix[x, y]) Color.BLACK else Color.WHITE)
                }
            }
        } catch (e: WriterException) {
            Log.d("⚡", "generated code exception")
        }

        return bitmap
    }
}