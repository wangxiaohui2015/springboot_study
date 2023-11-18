## Spring Boot Restful Service Example

This is an example of how to implement a restful service based on spring boot framework, and how to test CRUD operations by curl command, this sample code can be used to quickly setup spring boot restful service.

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
cd springboot_study/springboot-restful/
git checkout -b support_jdk_17 remotes/origin/support_jdk_17
mvn clean package
```
After building, "restful-service-0.0.1-RELEASE.jar" will be generated under target folder.

### Start restful service
```
sunny@sunny-virtual-machine:~/work/git/springboot_study/springboot-restful$ cd target/
sunny@sunny-virtual-machine:~/work/git/springboot_study/springboot-restful/target$ java -jar restful-service-0.0.1-RELEASE.jar 

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.1.5)

2023-11-18T11:21:29.119+08:00  INFO 9382 --- [           main] com.my.study.restful.Main                : Starting Main v0.0.1-RELEASE using Java 17.0.7 with PID 9382 (/home/sunny/work/git/springboot_study/springboot-restful/target/restful-service-0.0.1-RELEASE.jar started by sunny in /home/sunny/work/git/springboot_study/springboot-restful/target)
2023-11-18T11:21:29.121+08:00  INFO 9382 --- [           main] com.my.study.restful.Main                : No active profile set, falling back to 1 default profile: "default"
2023-11-18T11:21:29.723+08:00  INFO 9382 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2023-11-18T11:21:29.730+08:00  INFO 9382 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-11-18T11:21:29.731+08:00  INFO 9382 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.15]
2023-11-18T11:21:29.822+08:00  INFO 9382 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-11-18T11:21:29.823+08:00  INFO 9382 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 651 ms
2023-11-18T11:21:30.087+08:00  INFO 9382 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-11-18T11:21:30.098+08:00  INFO 9382 --- [           main] com.my.study.restful.Main                : Started Main in 1.244 seconds (process running for 1.518)

```

### Test restful API
### Query all employees
```
sunny@sunny-virtual-machine:~$ curl localhost:8080/employee/
[{"id":0,"name":"user0","age":20,"desc":"desc 0."},{"id":1,"name":"user1","age":21,"desc":"desc 1."},{"id":2,"name":"user2","age":22,"desc":"desc 2."}]sunny@sunny-virtual-machine:~$ 
sunny@sunny-virtual-machine:~$ 
```

Add '-v' to show more details,

```
sunny@sunny-virtual-machine:~$ curl -v localhost:8080/employee/
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /employee/ HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.74.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
< Vary: Origin
< Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
< Content-Type: application/json
< Transfer-Encoding: chunked
< Date: Sat, 18 Nov 2023 03:25:34 GMT
< 
* Connection #0 to host localhost left intact
[{"id":0,"name":"user0","age":20,"desc":"desc 0."},{"id":1,"name":"user1","age":21,"desc":"desc 1."},{"id":2,"name":"user2","age":22,"desc":"desc 2."}]sunny@sunny-virtual-machine:~$ 
```

### Query employee by ID

If query successfully, then return employee JSON data and return code is 200,

```
sunny@sunny-virtual-machine:~$ curl -v localhost:8080/employee/1
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /employee/1 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.74.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
< Vary: Origin
< Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
< Content-Type: application/json
< Transfer-Encoding: chunked
< Date: Sat, 18 Nov 2023 04:11:56 GMT
< 
* Connection #0 to host localhost left intact
{"id":1,"name":"user1","age":21,"desc":"desc 1."}sunny@sunny-virtual-machine:~$ 
```

If employee doesn't exist, then return code is 404,

```
sunny@sunny-virtual-machine:~$ curl -v localhost:8080/employee/4
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /employee/4 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.74.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 404 
< Vary: Origin
< Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
< Content-Length: 0
< Date: Sat, 18 Nov 2023 04:13:50 GMT
< 
* Connection #0 to host localhost left intact
sunny@sunny-virtual-machine:~$ 
```

### Add new employee

Add successfully, return code is 201, means created,

```
sunny@sunny-virtual-machine:~$ curl -v -X POST -H "Content-Type: application/json" -d '{"id":3,"name":"user3","age":23,"desc":"desc 3."}' localhost:8080/employee/
Note: Unnecessary use of -X or --request, POST is already inferred.
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> POST /employee/ HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.74.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 49
> 
* upload completely sent off: 49 out of 49 bytes
* Mark bundle as not supporting multiuse
< HTTP/1.1 201 
< Vary: Origin
< Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
< Location: http://localhost:8080/employee/3
< Content-Length: 0
< Date: Sat, 18 Nov 2023 03:37:04 GMT
< 
* Connection #0 to host localhost left intact
sunny@sunny-virtual-machine:~$ 
```

Query all employees,

```
sunny@sunny-virtual-machine:~$ curl localhost:8080/employee/
[{"id":0,"name":"user0","age":20,"desc":"desc 0."},{"id":1,"name":"user1","age":21,"desc":"desc 1."},{"id":2,"name":"user2","age":22,"desc":"desc 2."},{"id":3,"name":"user3","age":23,"desc":"desc 3."}]sunny@sunny-virtual-machine:~$ 
```

Add an existing user, return code will be 409, means conflict and user already exists,

```
sunny@sunny-virtual-machine:~$ curl -v -X POST -H "Content-Type: application/json" -d '{"id":3,"name":"user3","age":23,"desc":"desc 3."}' localhost:8080/employee/
Note: Unnecessary use of -X or --request, POST is already inferred.
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> POST /employee/ HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.74.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 49
> 
* upload completely sent off: 49 out of 49 bytes
* Mark bundle as not supporting multiuse
< HTTP/1.1 409 
< Vary: Origin
< Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
< Content-Length: 0
< Date: Sat, 18 Nov 2023 03:41:33 GMT
< 
* Connection #0 to host localhost left intact
sunny@sunny-virtual-machine:~$
```

### Update employee by ID

Employee exists, update successfully, return code is 200, and updated user information also returned.

```
sunny@sunny-virtual-machine:~$ curl -v -X PUT -H "Content-Type: application/json" -d '{"id":3,"name":"user3_new_name","age":25,"desc":"New desc 3."}' localhost:8080/employee/
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> PUT /employee/ HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.74.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 62
> 
* upload completely sent off: 62 out of 62 bytes
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
< Vary: Origin
< Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
< Content-Type: application/json
< Transfer-Encoding: chunked
< Date: Sat, 18 Nov 2023 03:52:48 GMT
< 
* Connection #0 to host localhost left intact
{"id":3,"name":"user3_new_name","age":25,"desc":"New desc 3."}sunny@sunny-virtual-machine:~$ 
```

Then query all employees, we can get a new user with id 3 which is created at previous step,

```
sunny@sunny-virtual-machine:~$ curl localhost:8080/employee/
[{"id":0,"name":"user0","age":20,"desc":"desc 0."},{"id":1,"name":"user1","age":21,"desc":"desc 1."},{"id":2,"name":"user2","age":22,"desc":"desc 2."},{"id":3,"name":"user3_new_name","age":25,"desc":"New desc 3."}]sunny@sunny-virtual-machine:~$
```

If employee doesn't exist, then return code is 404,

```
sunny@sunny-virtual-machine:~$ curl -v -X PUT -H "Content-Type: application/json" -d '{"id":4,"name":"user3_new_name","age":25,"desc":"New desc 3."}' localhost:8080/employee/
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> PUT /employee/ HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.74.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 62
> 
* upload completely sent off: 62 out of 62 bytes
* Mark bundle as not supporting multiuse
< HTTP/1.1 404 
< Vary: Origin
< Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
< Content-Length: 0
< Date: Sat, 18 Nov 2023 03:54:19 GMT
< 
* Connection #0 to host localhost left intact
sunny@sunny-virtual-machine:~$ 
```

### Delete employee by ID

If delete successfully, then return code is 204

```
sunny@sunny-virtual-machine:~$ curl -v -X DELETE localhost:8080/employee/3
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> DELETE /employee/3 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.74.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 204 
< Vary: Origin
< Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
< Date: Sat, 18 Nov 2023 04:03:14 GMT
< 
* Connection #0 to host localhost left intact
sunny@sunny-virtual-machine:~$ 
```

If employee doesn't exist, then return code is 404,

```
sunny@sunny-virtual-machine:~$ curl -v -X DELETE localhost:8080/employee/3
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> DELETE /employee/3 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.74.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 404 
< Vary: Origin
< Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
< Content-Length: 0
< Date: Sat, 18 Nov 2023 04:04:31 GMT
< 
* Connection #0 to host localhost left intact
sunny@sunny-virtual-machine:~$ 
```

Query all employees,

```
sunny@sunny-virtual-machine:~$ curl localhost:8080/employee/
[{"id":0,"name":"user0","age":20,"desc":"desc 0."},{"id":1,"name":"user1","age":21,"desc":"desc 1."},{"id":2,"name":"user2","age":22,"desc":"desc 2."}]sunny@sunny-virtual-machine:~$ 
sunny@sunny-virtual-machine:~$ 
```

### Delete all employees

Delete successfully, return code is 204,

```
sunny@sunny-virtual-machine:~$ curl -v -X DELETE localhost:8080/employee/
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> DELETE /employee/ HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.74.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 204 
< Vary: Origin
< Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
< Date: Sat, 18 Nov 2023 04:06:39 GMT
< 
* Connection #0 to host localhost left intact
sunny@sunny-virtual-machine:~$ 
```

Query all employees, return code is 204 if no any employees returned,

```
sunny@sunny-virtual-machine:~$ curl -v localhost:8080/employee/
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /employee/ HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.74.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 204 
< Vary: Origin
< Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
< Date: Sat, 18 Nov 2023 04:08:24 GMT
< 
* Connection #0 to host localhost left intact
sunny@sunny-virtual-machine:~$ 
```

