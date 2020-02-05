package cucumberTest;

import org.junit.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import sun.security.krb5.Config;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Utils {

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
                    System.out.println ("env" + reqCfg.env);
                    reqCfg.setUrl(eElement.getElementsByTagName("url").item(0).getTextContent());
                    reqCfg.setBrowser(eElement.getElementsByTagName("browser").item(0).getTextContent());
                }
            }
        }
        return reqCfg;
    }

    public static void main (String argv[]) throws ParserConfigurationException, SAXException, IOException {
        Utils ut = new Utils();
        Configuration cfg = new Configuration();
        cfg = ut.readConfigFile("Test02");
    }

/*    // reads config.file parameters into class
    public Configuration readXmlConfig (String fileName,String envName) {
        // conf.data is parsed from xml and stored in Class
        Configuration reqCfg = new Configuration;
        ClassLoader classLoader = getClass().getClassLoader()
        File file = new File(classLoader.getResource(fileName).getFile());

        assert file.exists() : "Configuration file $file not found";
        assert file.canRead() : "Configuration file $file has no read permission";
        //parse Xml file and store the specified envType config into class structure

        def config = new XmlSlurper().parse(file)
        for(def i=0;i<config.env.size();i++) {
            if (config.env[i].@name == envName) {
                reqCfg.setUrl((String)config.env[i].url)
                reqCfg.setBrowser((String)config.env[i].browser)
                reqCfg.setBrowserRes((String)config.env[i].browserRes)
            }
        }
        return reqCfg
    }*/

}

