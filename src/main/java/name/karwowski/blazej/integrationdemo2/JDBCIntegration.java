package name.karwowski.blazej.integrationdemo2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.jdbc.store.JdbcChannelMessageStore;
import org.springframework.integration.jdbc.store.channel.ChannelMessageStoreQueryProvider;
import org.springframework.integration.jdbc.store.channel.H2ChannelMessageStoreQueryProvider;
import org.springframework.integration.store.ChannelMessageStore;
import org.springframework.messaging.PollableChannel;

import javax.sql.DataSource;

@Configuration
public class JDBCIntegration {
    @Bean
    public PollableChannel  firstJDBCChannel(ChannelMessageStore messageStore) {
        PollableChannel pc = MessageChannels.queue("firstJDBCChannel" , messageStore, "first").get();
        return pc;
    }

    @Bean
    public PollableChannel secondJDBCChannel(ChannelMessageStore messageStore) {
        PollableChannel pc = MessageChannels.queue("secondJDBCChannel" , messageStore, "second").get();
        return pc;
    }

    @Bean
    public JdbcChannelMessageStore messageStore(DataSource dataSource,ChannelMessageStoreQueryProvider queryProvider) {
        JdbcChannelMessageStore store = new JdbcChannelMessageStore(dataSource);
        store.setChannelMessageStoreQueryProvider(queryProvider);
        store.setPriorityEnabled(true);
        return store;
    }

    @Bean
    public ChannelMessageStoreQueryProvider queryProvider() {
        return new H2ChannelMessageStoreQueryProvider();
    }
}
