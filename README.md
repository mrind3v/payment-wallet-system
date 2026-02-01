This is how the application.properties file inside resources directory should look liks:
```shell
spring.application.name=DATABASE_NAME

# Database Connection (Using MySQL Driver for MariaDB)
# Note: We use 'jdbc:mysql' because we are using the MySQL driver
spring.datasource.url=jdbc:mysql://localhost:3306/pws
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA / Hibernate Configurations
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```