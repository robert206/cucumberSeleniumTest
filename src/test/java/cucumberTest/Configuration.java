package cucumberTest;

public class Configuration {

    String env;
    String url;
    String browser;
    String browserRes;

    String getEnv() {
        return env;
    }

    void setEnv() {
        this.env = env;
    }


    String getUrl() {
        return url;
    }
    void setUrl(String url) {
            this.url = url;
    }


    String getBrowser() {
        return browser;
    }

    void setBrowser (String browser) {
        this.browser = browser;
    }


    String getBrowserRes () {
        return browserRes;
    }
    void setBrowserRes(String browserRes) {
        this.browserRes = browserRes;
    }


}


