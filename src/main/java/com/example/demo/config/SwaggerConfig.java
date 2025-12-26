# ===============================
# Application
# ===============================
spring.application.name=multi-branch-academic-calendar-harmonizer
server.port=9001

# ===============================
# MySQL Database
# ===============================
spring.datasource.url=jdbc:mysql://localhost:3306/Academic_Calendar?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=Amypo
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# ===============================
# JPA / Hibernate
# ===============================
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.open-in-view=false

# ===============================
# Swagger / OpenAPI
# ===============================
springdoc.api-docs.path=/v3/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.operationsSorter=method
springdoc.swagger-ui.tagsSorter=alpha

# ===============================
# Logging (optional but useful)
# ===============================
logging.level.org.springframework.security=INFO
logging.level.org.hibernate.SQL=DEBUG
