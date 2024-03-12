package com.tmt.pdf.viewer

import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethods
import com.getcapacitor.annotation.CapacitorPlugin
import com.tmt.pdf.viewer.util.saveTo

@CapacitorPlugin(name = "PDFView")
class PDFViewPlugin : Plugin() {
    private lateinit var url: String

    @PluginMethod
    fun preview(call: PluginCall) {

        url = call.data.getString("value") as String
        launchPdfFromUrl(url)

        call.resolve()
    }

    private fun launchPdfFromUrl(url: String) {
        activity.startActivity(
            PdfViewerActivity.launchPdfFromUrl(
                context = activity.applicationContext,
                pdfUrl = url,
                pdfTitle = "PDF Title",
                saveTo = saveTo.ASK_EVERYTIME,
                enableDownload = true
            )
        )

    }
}
