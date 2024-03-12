package com.tmt.pdf.viewer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tmt.pdf.viewer.util.saveTo


class MainActivity : AppCompatActivity() {
    private var download_file_url = "https://css4.pub/2015/usenix/example.pdf"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        window.requestFeature(Window.FEATURE_NO_TITLE)

        setContentView(R.layout.activity_main)

        launchPdfFromUrl(download_file_url)


    }


    private fun launchPdfFromUrl(url: String) {

//        Headers can be passed like this, be default header will be empty.
//        val url = "http://10.0.2.2:5000/download_pdf" // Use 10.0.2.2 for Android emulator to access localhost
//        val headers = mapOf("Authorization" to "123456789")

        startActivity(
            PdfViewerActivity.launchPdfFromUrl(
                context = this,
                pdfUrl = url,
                pdfTitle = "PDF Title",
                saveTo = saveTo.ASK_EVERYTIME,
                enableDownload = true
            )
        )

        finish()
    }
}
