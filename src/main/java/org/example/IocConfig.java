package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Java tabanlı Spring konfigürasyonu (IoC container yapılandırması).
 * - @Configuration sınıfı bean tanımlarının kaynağı olduğunu belirtir
 * - @ComponentScan paketteki @Component/@Service/@Repository anotasyonlarını tarar
 * - @PropertySource sınıfpath'ten properties dosyasını yükler (ör. @Value için)
 */
@Configuration
@ComponentScan("org.example")
@PropertySource("classpath:values.properties")
public class IocConfig {

    /**
     * Veri erişim (DAL) bean'i tanımı. Şu an MsSqlCustomerDal döndürülüyor.
     * MySQL kullanmak isterseniz burada döndürülen implementasyonu değiştirin
     * veya bileşen taraması ile @Profile / properties üzerinden yönetin.
     */
    @Bean
    public ICustomerDal database(){
        return new MsSqlCustomerDal();
    }

    /**
     * Servis bean'i tanımı. Servis, database bean'ine bağımlıdır.
     * Spring, konteyneri oluştururken bağımlılıkları enjekte eder.
     */
    @Bean
    public ICustomerService service(){
        return new CustomerManager(database());
    }
}
