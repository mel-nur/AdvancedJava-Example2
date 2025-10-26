# Spring IoC / Annotation Örneği

Bu küçük proje, Java ve Spring Framework kullanarak IoC (Inversion of Control) ve Dependency Injection (DI) kavramlarını göstermektedir.

İçerik ve amaç:
- Basit bir servis katmanı (`ICustomerService` / `CustomerManager`) ile bir veri erişim katmanını (`ICustomerDal`, `MsSqlCustomerDal`, `MySqlCustomerDal`) ayrı tutar.
- Java tabanlı Spring konfigürasyonu örneği (`IocConfig`) ve XML tabanlı `applicationContext.xml` referansı içerir.
- Uygulama, Spring'in `AnnotationConfigApplicationContext` kullanılarak çalıştırılır.

Dosya yapısı (önemli dosyalar):
- `src/main/java/org/example/ICustomerDal.java` - Veri erişim arayüzü (DAL).
- `src/main/java/org/example/ICustomerService.java` - Servis arayüzü.
- `src/main/java/org/example/CustomerManager.java` - Servis katmanı, iş kurallarını uygular ve DAL'a delegasyon yapar.
- `src/main/java/org/example/MsSqlCustomerDal.java` - MsSQL için örnek DAL uygulaması.
- `src/main/java/org/example/MySqlCustomerDal.java` - MySQL için örnek DAL uygulaması.
- `src/main/java/org/example/IocConfig.java` - Java tabanlı Spring konfigürasyonu (bean tanımları, property kaynağı).
- `src/main/java/org/example/Main.java` - Uygulamayı çalıştıran küçük runner.
- `src/main/resources/applicationContext.xml` - (Referans) XML tabanlı component-scan örneği.
- `src/main/resources/values.properties` - Uygulama özellikleri (ör. `database.connectionString`).
- `pom.xml` - Maven yapılandırması (sadece `spring-context` bağımlılığı içerir).

Nasıl çalıştırılır (Windows PowerShell):

1) Projeyi derleyin:

```powershell
mvn -DskipTests package
```

2) Çalıştırma (derleme sonrası JAR veya IDE kullanabilirsiniz).
   - IDE içinde `Main` sınıfını çalıştırabilirsiniz.
   - Komut satırından doğrudan çalıştırma için projenin package edilip çalıştırılabilir JAR üretilmesi ve `mainClass` tanımlanması gerekir (şu an `pom.xml` sadece derleme için). 

Örnek çıktı (IDE'de `Main` çalıştırıldığında):

```
Connection String : baglanti metni
MsSQL veri tabanına eklendi.
```

Notlar ve kullanım ipuçları:
- `IocConfig` içinde hangi `ICustomerDal` uygulamasının döndürüleceğini değiştirmek, veri kaynağını değiştirmek için yeterlidir (şu an `MsSqlCustomerDal` dönüyor).
- Alternatif yaklaşım: DAL sınıflarını `@Component` ile işaretleyip `@Profile` veya `@Primary` kullanarak hangi implementasyonun seçileceğini yapılandırabilirsiniz.
- `MsSqlCustomerDal` ve `MySqlCustomerDal` içinde `@Value("${database.connectionString}")` ile properties dosyasından bağlantı dizesi okunması için altyapı bulunur; bu değeri `src/main/resources/values.properties` üzerinden değiştirebilirsiniz.

Önerilen bir sonraki adım (hızlı doğrulama):
- `mvn -DskipTests package` çalıştırılarak derleme doğrulanmalı. Eğer derleme hatası yoksa IDE'de `Main` çalıştırılarak çıktının beklendiği gibi olup olmadığı kontrol edilebilir.

Eğer isterseniz ben:
- `pom.xml`'e `maven-shade-plugin` veya `maven-assembly-plugin` ekleyip çalıştırılabilir JAR oluşturma adımını ekleyebilirim.
- `MsSqlCustomerDal` yerine `MySqlCustomerDal` kullanacak şekilde `IocConfig`'i hızlıca güncelleyebilirim.

---