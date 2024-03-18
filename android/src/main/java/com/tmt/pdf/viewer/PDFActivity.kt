package com.tmt.pdf.viewer

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.tmt.pdf.viewer.databinding.ActivityPdfBinding
import com.tmt.pdf.viewer.interfaces.OnErrorListener
import com.tmt.pdf.viewer.interfaces.OnPageChangedListener
import com.tmt.pdf.viewer.utils.PdfPageQuality
import kotlinx.coroutines.Dispatchers
import java.io.IOException


class PDFActivity : AppCompatActivity(), OnPageChangedListener , OnErrorListener {
  private val REQUEST_CODE_LOAD = 367
  private lateinit var binding: ActivityPdfBinding
  private var file_url = ""

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityPdfBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val window = window
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    window.statusBarColor = Color.GRAY

    supportActionBar!!.hide()
    val intent = intent
    file_url = intent.getStringExtra("value").toString()

    PdfViewer.Builder(binding.rootView, lifecycleScope)
      .setMaxZoom(3f)
      .setZoomEnabled(true)
      .quality(PdfPageQuality.QUALITY_1080)
      .setOnErrorListener(this)
      .setOnPageChangedListener(this)
      .setRenderDispatcher(Dispatchers.Default)
      .build()
      .load(file_url)
  }


  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == REQUEST_CODE_LOAD && resultCode == Activity.RESULT_OK) {
      data?.data?.let { uri ->
        binding.rootView.removeAllViews()
        PdfViewer.Builder(binding.rootView, lifecycleScope)
          .setMaxZoom(3f)
          .setZoomEnabled(true)
          .quality(PdfPageQuality.QUALITY_1080)
          .setOnErrorListener(this)
          .setOnPageChangedListener(this)
          .setRenderDispatcher(Dispatchers.Default)
          .build()
          .load(uri)
      }
    }
  }

  override fun onPageChanged(page: Int, total: Int) {
    binding.tvCounter.text = getString(R.string.pdf_page_counter, page, total)
    binding.progCircular.visibility = View.GONE
  }

  override fun onFileLoadError(e: Exception) {
    //Handle error ...
    e.printStackTrace()
  }

  override fun onAttachViewError(e: Exception) {
    //Handle error ...
    e.printStackTrace()
  }

  override fun onPdfRendererError(e: IOException) {
    //Handle error ...
    e.printStackTrace()
  }
}
