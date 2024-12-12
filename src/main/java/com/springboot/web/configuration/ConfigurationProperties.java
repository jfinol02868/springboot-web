package com.springboot.web.configuration;

import com.springboot.web.repositories.ProductRepository;
import com.springboot.web.repositories.impl.ProductRepositoryJson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration
@PropertySources({
        @PropertySource(value = "classpath:values.properties", encoding = "UTF-8")
})
public class ConfigurationProperties {

    @Value("classpath:products.json")
    private Resource resource;

    @Bean
    @Primary
    ProductRepository productRepositoryJson() throws IOException {
        return new ProductRepositoryJson(resource);
    }
}
