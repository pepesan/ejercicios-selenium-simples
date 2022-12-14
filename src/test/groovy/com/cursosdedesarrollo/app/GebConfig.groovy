import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.os.ExecutableFinder


File findDriverExecutable() {
    def defaultExecutable = new ExecutableFinder().find("chromedriver")
    if (defaultExecutable) {
        new File(defaultExecutable)
    } else {
        new File("drivers").listFiles().findAll {
            !it.name.endsWith(".version")
        }.find {
            if (IS_OS_LINUX) {
                it.name.contains("linux")
            } else if (IS_OS_MAC) {
                it.name.contains("mac")
            } else if (IS_OS_WINDOWS) {
                it.name.contains("windows")
            }
        }
    }
}

driver = {
    ChromeDriverService.Builder serviceBuilder = new ChromeDriverService.Builder()
            .usingAnyFreePort()
            .usingDriverExecutable(findDriverExecutable())
    new ChromeDriver(serviceBuilder.build())
}

baseUrl = "https://duckduckgo.com"