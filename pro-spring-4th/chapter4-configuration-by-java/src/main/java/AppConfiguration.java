import com.sandbox.spring.chapter3.dependency.services.MessageProvider;
import com.sandbox.spring.chapter3.dependency.services.MessageRenderer;
import com.sandbox.spring.chapter3.dependency.services.StandardMessageOutRenderer;
import model.PropertyMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author Andrii Sysoiev
 */
@Configuration
@PropertySource("classpath:props.properties")
public class AppConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public MessageProvider messageProvider() {
//        MessageProvider messageProvider = new HelloWorldMessageProvider();
        PropertyMessageProvider messageProvider = new PropertyMessageProvider();
        messageProvider.setMessage(environment.getProperty("msg"));
        return messageProvider;
    }

    @Bean
    @DependsOn("messageProvider")
    public MessageRenderer messageRenderer() {
        StandardMessageOutRenderer standardMessageOutRenderer = new StandardMessageOutRenderer();
        standardMessageOutRenderer.setMessageProvider(messageProvider());
        return standardMessageOutRenderer;
    }

}
