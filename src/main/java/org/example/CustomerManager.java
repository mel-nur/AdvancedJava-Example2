package org.example;

/**
 * Müşteri işlemleri için servis katmanı implementasyonu.
 *
 * Sorumluluklar:
 * - ICustomerDal örneğini yapıcı (constructor) ile alır (dependency injection)
 * - add() içinde iş kurallarını uygular ve kalıcılık (persistence) için ICustomerDal'e devreder
 */
public class CustomerManager implements ICustomerService{
    private ICustomerDal customerDal;

    /**
     * Yapıcı ile bağımlılık enjeksiyonu (constructor injection).
     * IoC konteyneri (Spring) veya çağıran sınıf burada uygun ICustomerDal
     * implementasyonunu sağlar. Bu sayede servis, veri erişim detaylarından
     * bağımsız kalır.
     * @param customerDal veri erişim katmanı implementasyonu
     */
    public CustomerManager(ICustomerDal customerDal){
        this.customerDal = customerDal;
    }

    /**
     * Yeni bir müşteri ekleme işlemi.
     * Burada doğrulama, zenginleştirme veya logging gibi iş kuralları uygulanır
     * ve sonrasında persistence için DAL çağrılır.
     */
    public void add(){
        // iş kuralları burada uygulanır (örn. validasyon, logging)
        customerDal.add();
    }
}
