package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * MsSQL için veri erişim katmanı implementasyonu.
 * Bu sınıf örnek amaçlıdır ve gerçek bir veritabanı bağlantısı yerine
 * sadece console çıktısı üretir. @Value ile properties dosyasından
 * bağlantı dizesi okunabilir.
 */
//@Component("database") // Eğer component-scan ile otomatik register isterseniz açın
public class MsSqlCustomerDal implements ICustomerDal{

    // values.properties içindeki database.connectionString değeri buraya inject edilir
    @Value("${database.connectionString}")
    String connectionString;

    public String getConnectionString(){
        return connectionString;
    }

    public void setConnectionString(String connectionString){
        this.connectionString=connectionString;
    }

    @Override
    public void add() {
        // Gerçek uygulamada burada JDBC/ORM ile veritabanına ekleme yapılır
        System.out.println("Connection String : " + this.connectionString);
        System.out.println("MsSQL veri tabanına eklendi.");
    }
}
