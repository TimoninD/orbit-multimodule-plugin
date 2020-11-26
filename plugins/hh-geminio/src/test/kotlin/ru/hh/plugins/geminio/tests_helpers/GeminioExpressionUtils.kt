package ru.hh.plugins.geminio.tests_helpers

import com.android.tools.idea.wizard.template.ApiTemplateData
import com.android.tools.idea.wizard.template.ApiVersion
import com.android.tools.idea.wizard.template.FormFactor
import com.android.tools.idea.wizard.template.Language
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.ProjectTemplateData
import com.android.tools.idea.wizard.template.ThemesData
import com.android.tools.idea.wizard.template.booleanParameter
import com.android.tools.idea.wizard.template.stringParameter
import ru.hh.plugins.geminio.model.GeminioRecipe
import ru.hh.plugins.geminio.model.aliases.AndroidStudioTemplateParameter
import ru.hh.plugins.geminio.model.enums.GeminioRecipeExpressionModifier
import ru.hh.plugins.geminio.model.mapping.evaluateString
import java.io.File


object GeminioExpressionUtils {

    fun List<GeminioRecipe.RecipeExpression.Command>.toExpression(): GeminioRecipe.RecipeExpression {
        return GeminioRecipe.RecipeExpression(this)
    }

    fun createParametersMap(
        includeModule: Boolean = true,
        className: String = "BlankFragment",
    ): Map<String, AndroidStudioTemplateParameter> {
        return mapOf(
            "className" to stringParameter {
                name = "Class name"
                default = className
            },
            "includeModule" to booleanParameter {
                name = "Include module?"
                default = includeModule
            }
        )
    }

    fun createModuleTemplateData(): ModuleTemplateData {
        return ModuleTemplateData(
            projectTemplateData = ProjectTemplateData(
                androidXSupport = true,
                gradlePluginVersion = "6.3",
                javaVersion = "1.8",
                sdkDir = File("/AndroidSdk"),
                language = Language.Kotlin,
                kotlinVersion = "1.4.10",
                buildToolsVersion = "4.1.1",
                rootDir = File("/Project"),
                applicationPackage = "com.example.myapplication",
                includedFormFactorNames = mapOf(
                    FormFactor.Mobile to listOf("mobile")
                ),
                debugKeystoreSha1 = null,
                overridePathCheck = false,
                isNewProject = false
            ),
            srcDir = File("/Project/src/main/kotlin/com/example/mylibrary/"),
            resDir = File("/Project/src/main/res/"),
            manifestDir = File("/Project/src/main/"),
            testDir = File("/Project/src/test/"),
            unitTestDir = File("/Project/src/test/kotlin/"),
            aidlDir = File("/Project/src/main/aidl/"),
            rootDir = File("/Project/"),
            isNewModule = false,
            hasApplicationTheme = false,
            name = "mylibrary",
            isLibrary = true,
            packageName = "com.example.mylibrary",
            formFactor = FormFactor.Mobile,
            themesData = ThemesData(
                appName = "MyApplication"
            ),
            baseFeature = null,
            apis = ApiTemplateData(
                buildApi = ApiVersion(29, "29"),
                targetApi = ApiVersion(29, "29"),
                minApi = ApiVersion(21, "21"),
                appCompatVersion = 21,
                buildApiRevision = null
            )
        )
    }


    fun getEvaluatedValue(className: String, modifier: GeminioRecipeExpressionModifier): String? {
        val expression = listOf(
            GeminioRecipe.RecipeExpression.Command.Dynamic(
                parameterId = "className",
                modifiers = listOf(
                    modifier
                )
            )
        ).toExpression()

        return expression.evaluateString(createModuleTemplateData(), createParametersMap(className = className))
    }

}


