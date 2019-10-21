package ru.hh.android.plugin.wizard.feature_module

import com.intellij.openapi.project.Project
import com.intellij.ui.wizard.WizardModel
import ru.hh.android.plugin.component.module.ModuleRepository
import ru.hh.android.plugin.model.MainParametersHolder
import ru.hh.android.plugin.wizard.feature_module.steps.choose_apps.ChooseAppModulesWizardStep
import ru.hh.android.plugin.wizard.feature_module.steps.choose_apps.model.AppModuleDisplayableItem
import ru.hh.android.plugin.wizard.feature_module.steps.choose_modules.ChooseModulesWizardStep
import ru.hh.android.plugin.wizard.feature_module.steps.choose_modules.model.ModuleDisplayableItem
import ru.hh.android.plugin.wizard.feature_module.steps.module_params.FeatureModuleParamsWizardStep

class FeatureModuleWizardModel(
        project: Project,
        var params: MainParametersHolder = MainParametersHolder.EMPTY,
        var selectedModules: List<ModuleDisplayableItem> = emptyList(),
        var selectedApps: List<AppModuleDisplayableItem> = emptyList()
) : WizardModel("Feature module wizard") {

    init {
        val moduleInteractor = project.getComponent(ModuleRepository::class.java)

        add(FeatureModuleParamsWizardStep(project, this))
        add(ChooseModulesWizardStep(this, moduleInteractor))
        add(ChooseAppModulesWizardStep(this, moduleInteractor))
    }

}