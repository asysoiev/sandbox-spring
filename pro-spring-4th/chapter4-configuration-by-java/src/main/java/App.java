import com.sandbox.spring.chapter3.dependency.services.MessageRenderer;
import config.PropertiesConfig;
import config.YamlConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        MessageRenderer messageRenderer = context.getBean("messageRenderer", MessageRenderer.class);
        messageRenderer.render();



        YamlConfig yamlConfig = (YamlConfig) context.getBean("yamlConfig");
        List<String> servers = yamlConfig.getServers();
        servers.size();

        PropertiesConfig propertiesConfig = (PropertiesConfig) context.getBean("propertiesConfig");
        Map<String, PropertiesConfig.Menu> menus = propertiesConfig.getMenus();
        menus.size();
        System.out.println();
    }

}
