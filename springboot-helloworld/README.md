## Spring Boot Hello World Example

This is a hello world example of how to implement spring boot restful API server.

### Environment
- JDK: 17
- SpringBoot: 3.1.5
- Maven: 3.8.1
- STS: 4.18.1.RELEASE
- OS: Ubuntu 21.04

### Configure maven mirror
```
cd ~/.m2/settings.xml
```
Note: If cannot find above file, copy it from maven installation folder, then add below configurations in settings.xml,

```
<mirror>
  <id>aliyunmaven</id>
  <mirrorOf>*</mirrorOf>
  <name>aliyunmaven</name>
  <url>https://maven.aliyun.com/repository/public</url>
</mirror>
```

### Build
```
git clone git@github.com:wangxiaohui2015/springboot_study.git
cd springboot_study/springboot-helloworld/
git checkout -b support_jdk_17 remotes/origin/support_jdk_17
mvn clean package
```
After building, "restful-service-0.0.1-RELEASE.jar" will be generated under target folder.

### Start restful service
```
sunny@sunny-virtual-machine:~/work/git/springboot_study/springboot-restful$ cd target/
sunny@sunny-virtual-machine:~/work/git/springboot_study/springboot-helloworld/target$ java -jar hello-world-0.0.1-RELEASE.jar 

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.1.5)

2023-11-18T13:19:40.275+08:00  INFO 13191 --- [           main] c.my.study.springboot.helloworld.Main    : Starting Main v0.0.1-RELEASE using Java 17.0.7 with PID 13191 (/home/sunny/work/git/springboot_study/springboot-helloworld/target/hello-world-0.0.1-RELEASE.jar started by sunny in /home/sunny/work/git/springboot_study/springboot-helloworld/target)
2023-11-18T13:19:40.279+08:00  INFO 13191 --- [           main] c.my.study.springboot.helloworld.Main    : No active profile set, falling back to 1 default profile: "default"
2023-11-18T13:19:40.907+08:00  INFO 13191 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2023-11-18T13:19:40.914+08:00  INFO 13191 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-11-18T13:19:40.914+08:00  INFO 13191 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.15]
2023-11-18T13:19:40.992+08:00  INFO 13191 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-11-18T13:19:40.993+08:00  INFO 13191 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 624 ms
2023-11-18T13:19:41.257+08:00  INFO 13191 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-11-18T13:19:41.266+08:00  INFO 13191 --- [           main] c.my.study.springboot.helloworld.Main    : Started Main in 1.283 seconds (process running for 1.554)
```

### Test restful API
### Test hello world
```
sunny@sunny-virtual-machine:~$ curl localhost:8080
hello worldsunny@sunny-virtual-machine:~$ 
```