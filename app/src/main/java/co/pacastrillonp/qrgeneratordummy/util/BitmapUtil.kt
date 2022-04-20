package co.pacastrillonp.qrgeneratordummy.util

import android.graphics.Bitmap
import android.graphics.Color
import android.util.Log
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter

interface BitmapUtil {
    fun generateQRCode(width: Int, height: Int, url: String): Bitmap?
}

class DefaultBitmapUtil(private val multiFormatWriter: MultiFormatWriter) : BitmapUtil {

    override fun generateQRCode(width: Int, height: Int, url: String): Bitmap? {
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

        return try {

            multiFormatWriter.encode(url, BarcodeFormat.QR_CODE, width, height).let {
                for (x in 0 until width) {
                    for (y in 0 until height) {
                        bitmap.setPixel(x, y, if (it[x, y]) Color.BLACK else Color.WHITE)
                    }
                }
                return@let bitmap
            }

        } catch (e: Exception) {
            Log.d("⚡", "generated code exception: $e")
            null
        }
    }

}