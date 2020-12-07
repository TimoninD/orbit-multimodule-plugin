plugins {
    id(GradlePlugins.gradleIntelliJPlugin)
    kotlin("jvm")
    id(GradlePlugins.setupIdeaPlugin)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":hh-plugins-core"))
    implementation(project(":hh-freemarker-wrapper"))

    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation(Libs.freemarker)
}
