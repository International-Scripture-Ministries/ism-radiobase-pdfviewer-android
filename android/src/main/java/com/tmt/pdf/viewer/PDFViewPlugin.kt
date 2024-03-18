package com.tmt.pdf.viewer

import android.content.Intent
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin

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
    val mIntent: Intent = Intent(activity.applicationContext, PDFActivity::class.java)
    mIntent.putExtra("value", url)
    activity.startActivity(mIntent)
  }
}
