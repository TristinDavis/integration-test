package name.karwowski.blazej.integrationdemo2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;

@Configuration
public class DemoIntegration {
    @Bean
    public IntegrationFlow flow(MessageChannel firstJDBCChannel,
                                MessageChannel secondJDBCChannel) {
        return IntegrationFlows.from(firstJDBCChannel)
                .bridge(bridgeHandler -> bridgeHandler.poller(p -> p.fixedDelay(100L)))
                .handle(secondJDBCChannel)
                .get();
    }
}
