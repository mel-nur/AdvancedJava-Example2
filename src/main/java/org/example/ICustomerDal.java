package org.example;

/**
 * Veri erişim katmanı (DAL) arayüzü - müşteri operasyonları için.
 * MsSqlCustomerDal veya MySqlCustomerDal gibi implementasyonlar
 * kalıcılık detaylarını (veritabanı işlemleri) sağlar. Servis katmanı
 * bu soyutlama üzerinden veri erişimine bağımlıdır.
 */
public interface ICustomerDal {
    /**
     * Bir müşteriyi kalıcı depolamaya ekle. Somut implementasyonlar
     * nasıl ve nereye ekleneceğini belirler.
     */
    void add();
}
