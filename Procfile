web: java $JAVA_OPTS -Dserver.port=$PORT -jar target/*.jar --spring.config.location=classpath:heroku-db.properties

server:
    context-path: /rest

spring: 
    main:
        banner-mode: "off"       

logging: 
    level: 
        org: 
            springframework: ERROR