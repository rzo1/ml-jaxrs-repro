# Case 2

```java
package com.github.rzo1;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("myapp")
public class MyApp extends Application {
}
```

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

with **no** `web.xml`

yields log output:

```bash
02-Apr-2024 20:20:20.096 INFORMATION [main] org.apache.openejb.server.cxf.rs.CxfRsHttpListener.logEndpoints REST Application: http://localhost:8282/myapp                -> com.github.rzo1.MyApp@5b160208
02-Apr-2024 20:20:20.098 INFORMATION [main] org.apache.openejb.server.cxf.rs.CxfRsHttpListener.logEndpoints      Service URI: http://localhost:8282/myapp/health         -> Pojo org.apache.tomee.microprofile.health.MicroProfileHealthChecksEndpoint
02-Apr-2024 20:20:20.098 INFORMATION [main] org.apache.openejb.server.cxf.rs.CxfRsHttpListener.logEndpoints               GET http://localhost:8282/myapp/health         ->      Response getChecks()       
02-Apr-2024 20:20:20.098 INFORMATION [main] org.apache.openejb.server.cxf.rs.CxfRsHttpListener.logEndpoints               GET http://localhost:8282/myapp/health/live    ->      Response getLiveChecks()   
02-Apr-2024 20:20:20.098 INFORMATION [main] org.apache.openejb.server.cxf.rs.CxfRsHttpListener.logEndpoints               GET http://localhost:8282/myapp/health/ready   ->      Response getReadyChecks()  
02-Apr-2024 20:20:20.098 INFORMATION [main] org.apache.openejb.server.cxf.rs.CxfRsHttpListener.logEndpoints               GET http://localhost:8282/myapp/health/started ->      Response getStartedChecks()
02-Apr-2024 20:20:20.099 INFORMATION [main] org.apache.openejb.server.cxf.rs.CxfRsHttpListener.logEndpoints      Service URI: http://localhost:8282/myapp/myresource     -> Pojo com.github.rzo1.MyResource                                           
02-Apr-2024 20:20:20.099 INFORMATION [main] org.apache.openejb.server.cxf.rs.CxfRsHttpListener.logEndpoints               GET http://localhost:8282/myapp/myresource     ->      Response test()
02-
```

