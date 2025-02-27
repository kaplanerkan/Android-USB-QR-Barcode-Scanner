package com.erkankaplan.qrcode_scanner.ui

import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import com.erkankaplan.qrcode_scanner.databinding.ActivityMainBinding

/*

USB Barcode/QR-Code Scanner Integration in Android App
https://stackoverflow.com/questions/34411919/android-and-external-usb-barcode-scanner-how-catch-the-enter

Hem Activity hemde Fragment içerisinde USB barkod okuyucu entegrasyonu yapılabilir.

 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var scannedData = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnTemizle.setOnClickListener{
            binding.tvResult.text = ""
        }

        binding.tvResult.requestFocus()



    }



     override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        if (event.action == KeyEvent.ACTION_DOWN) {
            when (event.keyCode) {
                KeyEvent.KEYCODE_ENTER -> {
                    handleBarcodeScan(scannedData)
                    scannedData = ""
                    return true
                }

                else -> {
                    val keyChar = event.unicodeChar.toChar()
                    scannedData += keyChar
                    return true
                }
            }
        }
        return super.dispatchKeyEvent(event)
    }


    private fun handleBarcodeScan(barcodeData: String) {
        // Process the scanned barcode data
        // You can perform actions such as database lookups, API calls, etc.
        // For this example, we'll just print the barcode data
        println("Scanned barcode: $barcodeData")
        binding.tvResult.text = barcodeData
    }






}