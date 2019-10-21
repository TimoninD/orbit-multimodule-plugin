package ru.hh.android.plugin.model

import com.intellij.psi.PsiDirectory
import ru.hh.android.plugin.extensions.EMPTY
import ru.hh.android.plugin.model.enums.FeatureModuleType
import ru.hh.android.plugin.model.enums.PredefinedFeature


data class MainParametersHolder(
        val moduleName: String,
        val packageName: String,
        val moduleType: FeatureModuleType,
        val settingsGradleModulePath: String,
        val rootModuleDirectory: PsiDirectory?,
        val enabledSettings: List<PredefinedFeature>
) {

    companion object {
        val EMPTY = MainParametersHolder(
                moduleName = String.EMPTY,
                packageName = String.EMPTY,
                moduleType = FeatureModuleType.STANDALONE,
                settingsGradleModulePath = String.EMPTY,
                rootModuleDirectory = null,
                enabledSettings = emptyList()
        )
    }

}