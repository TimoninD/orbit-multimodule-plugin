package ru.hh.plugins.garcon.extensions.psi

import com.android.SdkConstants
import com.android.tools.idea.util.androidFacet
import com.intellij.psi.PsiClass
import com.intellij.psi.xml.XmlTag
import org.jetbrains.android.facet.LayoutViewClassUtils
import org.jetbrains.kotlin.idea.util.module


fun XmlTag.toPsiClass(): PsiClass? {
    return module?.androidFacet?.let { facet ->
        LayoutViewClassUtils.findClassByTagName(
            facet,
            localName,
            SdkConstants.CLASS_VIEW
        )
    }
}