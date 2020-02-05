package cucumberTest;

import org.junit.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Configuration {

    public String env;
    public String url;
    public String browser;
    public String browserRes;

    public String getEnv() {
        return env;
    }
    void setEnv(String env) {
        this.env = env;
    }

    public String getUrl() {
        return url;
    }
    void setUrl(String url) {
            this.url = url;
    }

    public String getBrowser() {
        return browser;
    }
    void setBrowser (String browser) {
        this.browser = browser;
    }

    public String getBrowserRes () {
        return browserRes;
    }
    void setBrowserRes(String browserRes) {
        this.browserRes = browserRes;
    }


    /** Read configuration file located under resources project dir **/
    public Configuration readConfigFile (String envName) throws IOException, SAXException, ParserConfigurationException {
        // new instance of Config. and read file
        Configuration reqCfg = new Configuration();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("config.xml").getFile());
        Assert.assertTrue("File not found",file.exists());
        // DOM inits
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("env");
        for (int i =0;i < nList.getLength(); i++) {
            Node node = nList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                String env = eElement.getAttribute("name");
                // if it matches env name then save into configuration
                if (env.matches(envName)) {
                    reqCfg.setEnv(eElement.getAttribute("name"));
                    reqCfg.setUrl(eElement.getElementsByTagName("url").item(0).getTextContent());
                    reqCfg.setBrowser(eElement.getElementsByTagName("browser").item(0).getTextContent());
                    reqCfg.setBrowserRes(eElement.getElementsByTagName("browserRes").item(0).getTextContent());
                }
            }
        }
        return reqCfg;
    }

}


