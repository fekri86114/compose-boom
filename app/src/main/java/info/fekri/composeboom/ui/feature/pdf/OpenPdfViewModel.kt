package info.fekri.composeboom.ui.feature.pdf

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class OpenPdfViewModel : ViewModel() {
    val pdfUrl = mutableStateOf("")

    fun getPdfUrl(url: String) {
        pdfUrl.value = url
    }

}