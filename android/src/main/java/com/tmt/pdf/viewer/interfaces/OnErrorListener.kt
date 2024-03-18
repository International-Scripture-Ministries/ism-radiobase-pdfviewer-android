package com.tmt.pdf.viewer.interfaces

import java.io.IOException
import java.lang.Exception

interface OnErrorListener {

    fun onFileLoadError(e : Exception)

    fun onAttachViewError(e : Exception)

    fun onPdfRendererError(e : IOException)
}
