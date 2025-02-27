pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        jcenter()
        maven {
            url = uri("http://maven.aliyun.com/nexus/content/repositories/jcenter")
            isAllowInsecureProtocol = true
        }
        maven { url = uri("https://jitpack.io") }

        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven {
            url = uri("http://maven.aliyun.com/nexus/content/repositories/jcenter")
            isAllowInsecureProtocol = true
        }
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "USB-BarcodeQRCODE-Scanner"
include(":app")
 