package org.example;

/**
 * Servis katmanı sözleşmesi (interface) - müşteri işlemleri için.
 * CustomerManager bu arayüzü implement eder ve iş kurallarını içerir.
 */
public interface ICustomerService {
    /**
     * Servis seviyesinde müşteri ekleme işlemini başlatır.
     */
    void add();
}
