package ru.hh.android.plugin.services

import com.intellij.openapi.project.DumbService
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity
import ru.hh.android.plugin.config.PluginConfig
import ru.hh.plugins.logger.HHLogger
import ru.hh.plugins.logger.HHNotifications

class CarnivalStartupActivity : StartupActivity {

    override fun runActivity(project: Project) {
        DumbService.getInstance(project).runWhenSmart {
            setupLogger(project)
            setupNotifications(project)
        }
    }

    private fun setupLogger(project: Project) {
        val config = PluginConfig.getInstance(project)
        HHLogger.plant(project, config.isDebugEnabled)
    }

    private fun setupNotifications(project: Project) {
        HHNotifications.plant(project)
    }

}