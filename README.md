# Case 1

```java
package com.github.rzo1;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("myresource")
public class MyResource {

    @GET
    public Response test() {
        return Response.ok("yolo").build();
    }
}
```

with `web.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="3.0" xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd">

    <display-name>demo-jaxrs</display-name>

    <servlet>

        <servlet-name>jakarta.ws.rs.core.Application</servlet-name>

    </servlet>

    <servlet-mapping>

        <servlet-name>jakarta.ws.rs.core.Application</servlet-name>

        <url-pattern>/myapp/*</url-pattern>

    </servlet-mapping>
</web-app>

```

yields log output:

```bash
02-Apr-2024 20:16:38.994 INFORMATION [main] org.apache.openejb.server.cxf.rs.CxfRsHttpListener.logEndpoints REST Application: http://localhost:8282/myapp                -> org.apache.openejb.config.AnnotationDeployer$ProvidedJAXRSApplication@7a023e34
02-Apr-2024 20:16:38.996 INFORMATION [main] org.apache.openejb.server.cxf.rs.CxfRsHttpListener.logEndpoints      Service URI: http://localhost:8282/myapp/health         -> Pojo org.apache.tomee.microprofile.health.MicroProfileHealthChecksEndpoint
02-Apr-2024 20:16:38.997 INFORMATION [main] org.apache.openejb.server.cxf.rs.CxfRsHttpListener.logEndpoints               GET http://localhost:8282/myapp/health         ->      Response getChecks()       
02-Apr-2024 20:16:38.997 INFORMATION [main] org.apache.openejb.server.cxf.rs.CxfRsHttpListener.logEndpoints               GET http://localhost:8282/myapp/health/live    ->      Response getLiveChecks()   
02-Apr-2024 20:16:38.997 INFORMATION [main] org.apache.openejb.server.cxf.rs.CxfRsHttpListener.logEndpoints               GET http://localhost:8282/myapp/health/ready   ->      Response getReadyChecks()  
02-Apr-2024 20:16:38.997 INFORMATION [main] org.apache.openejb.server.cxf.rs.CxfRsHttpListener.logEndpoints               GET http://localhost:8282/myapp/health/started ->      Response getStartedChecks()
02-Apr-2024 20:16:38.997 INFORMATION [main] org.apache.openejb.server.cxf.rs.CxfRsHttpListener.logEndpoints      Service URI: http://localhost:8282/myapp/myresource     -> Pojo com.github.rzo1.MyResource                                           
02-Apr-2024 20:16:38.997 INFORMATION [main] org.apache.openejb.server.cxf.rs.CxfRsHttpListener.logEndpoints               GET http://localhost:8282/myapp/myresource     ->      Response test()

```

