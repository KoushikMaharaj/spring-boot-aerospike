package example.springbootaerospikedemo.configuration;

import com.aerospike.client.Host;
import example.springbootaerospikedemo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.aerospike.config.AbstractAerospikeDataConfiguration;
import org.springframework.data.aerospike.config.AerospikeDataSettings;
import org.springframework.data.aerospike.convert.AerospikeTypeAliasAccessor;
import org.springframework.stereotype.Component;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;

import java.util.Collection;
import java.util.Collections;

@Component
@Configuration
@EnableConfigurationProperties(AerospikeConfigurationProperties.class)
@EnableAerospikeRepositories(basePackageClasses = EmployeeRepo.class)
public class AerospikeConfiguration extends AbstractAerospikeDataConfiguration {

    @Autowired
    AerospikeConfigurationProperties aerospikeConfigurationProperties;

    @Override
    protected Collection<Host> getHosts() {
        return Collections.singleton(new Host(aerospikeConfigurationProperties.getHost(),
                aerospikeConfigurationProperties.getPort()));
    }

    @Override
    protected String nameSpace() {
        return aerospikeConfigurationProperties.getNamespace();
    }

    @Bean
    public AerospikeDataSettings aerospikeDataSettings() {
        return AerospikeDataSettings.builder().scansEnabled(true).build();
    }

    @Bean
    public AerospikeTypeAliasAccessor aerospikeTypeAliasAccessor() {
        return new AerospikeTypeAliasAccessor(null);
    }
}
