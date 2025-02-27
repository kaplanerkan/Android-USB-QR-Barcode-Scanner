package com.erkankaplan.qrcode_scanner.ui

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.erkankaplan.qrcode_scanner.R

class BarcodeScannerFragment : Fragment() {

    private var scannedData = ""
    private var tvResult: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_barcode_scanner, container, false)
        tvResult = rootView.findViewById(R.id.tvResult)

        rootView.isFocusableInTouchMode = true
        rootView.requestFocus()
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN) {
                when (keyCode) {
                    KeyEvent.KEYCODE_ENTER -> {
                        handleBarcodeScan(scannedData)
                        scannedData = ""
                        return@setOnKeyListener true
                    }
                    else -> {
                        val keyChar = event.unicodeChar.toChar()
                        scannedData += keyChar
                        return@setOnKeyListener true
                    }
                }
            }
            return@setOnKeyListener false
        }
    }

    private fun handleBarcodeScan(barcodeData: String) {
        // Process the scanned barcode data
        // You can perform actions such as database lookups, API calls, etc.
        // For this example, we'll just print the barcode data
        println("Scanned barcode: $barcodeData")
        tvResult?.text = barcodeData
    }
}