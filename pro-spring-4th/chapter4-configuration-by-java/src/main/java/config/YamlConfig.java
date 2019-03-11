package config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrii Sysoiev
 */
@Component
@ConfigurationProperties(prefix="my")
public class YamlConfig {

    private List<String> servers = new ArrayList<String>();

    public List<String> getServers() {
        return this.servers;
    }

    public void setServers(List<String> servers) {
        this.servers = servers;
    }
}
