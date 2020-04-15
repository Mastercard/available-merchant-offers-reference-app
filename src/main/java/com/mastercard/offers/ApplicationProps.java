package  com.mastercard.offers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationProps {

    @Autowired
    private Environment env;

    public String getProperty(String pPropertyKey) {
        return env.getProperty(pPropertyKey);
    }

    public String getP12FilePath(String signingKeyFilePath) {
        return System.getProperty("user.dir") +
                System.getProperty("file.separator")+ "src" +
                System.getProperty("file.separator")+ "main" +
                System.getProperty("file.separator")+ "resources" +
                System.getProperty("file.separator")+
                getProperty("signingKeyFilePath");
    }
} 