package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Küçük bir çalıştırıcı (runner) - IoC konteyner kullanımını gösterir.
 *
 * Notlar:
 * - Bu örnek Java tabanlı konfigürasyon (IocConfig.class) ile AnnotationConfigApplicationContext
 *   kullanır. workspace içinde XML konfigürasyon (applicationContext.xml) bulunsa da
 *   burada kullanılmamaktadır.
 */
public class Main {
    public static void main(String[] args) {

        // try-with-resources ile context'i kapatıyoruz; aksi halde kaynak sızıntısı olur
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IocConfig.class)) {

            // "service" isimli bean'i al ve add() çağır
            ICustomerService customerService = context.getBean("service", ICustomerService.class);
            customerService.add();

            /*
             Alternatif: Veri erişim (DAL) bean'ini doğrudan al ve çağır.
             Bu, herhangi bir bean'i isim veya tipe göre çekebileceğinizi gösterir.
            ICustomerDal customerDal = context.getBean("database", ICustomerDal.class);
            customerDal.add();
             */
        }

    }
    // IoC - Inversion of Control (Kontrolün Tersine Çevrilmesi)
    // Dependency Injection örneği
    // SOLID: Single Responsibility ve Dependency Inversion ilkeleri örneği
}