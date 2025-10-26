package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * MySQL için veri erişim katmanı implementasyonu (örnek).
 * Gerçek uygulamada burada MySQL sürücüsü/JDBC/ORM kodu olur.
 */
//@Component("database") // component-scan ile otomatik yazmak isterseniz aktifleştirin
public class MySqlCustomerDal implements ICustomerDal{

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
        // Gerçek uygulamada veritabanına ekleme burada yapılır
        System.out.println("Connection String : " + this.connectionString);
        System.out.println("MySQL veri tabanına eklendi");
    }
}
