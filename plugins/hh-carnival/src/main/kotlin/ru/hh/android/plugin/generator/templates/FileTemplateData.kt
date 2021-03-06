package ru.hh.android.plugin.generator.templates

import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.PsiDirectory


data class FileTemplateData(
        val templateFileName: String,
        val outputFileName: String,
        val outputFileType: FileType,
        val outputFilePsiDirectory: PsiDirectory?
)