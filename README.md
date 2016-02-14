# Tamber Java Bindings

You can sign up for a Tamber account at https://tamber.com.

Requirements
============

Java 1.7 and later.

Installation
============

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.tamber</groupId>
  <artifactId>tamber-java</artifactId>
  <version>0.1.0</version>
</dependency>
```

### Manual

Install the following JARs:

* The Tamber JAR from https://github.com/tamber/tamber-java/builds
* [JSON Simple](https://code.google.com/p/json-simple/) from <http://json-simple.googlecode.com/files/json-simple-1.1.1.jar>
* [JSON](http://www.json.org/java/) from <https://code.google.com/p/org-json-java/downloads/list>
* [Apache HTTP Components](https://hc.apache.org/) from <https://hc.apache.org/downloads.cgi>.

Usage
=====

Example.java

```java
import com.tamber.Tamber;
import com.tamber.exception.TamberException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class TamberExample {

    public static void main(String[] args) {
        Tamber tamber = new Tamber("key_H4y13AJ1QMlgzOqZ0sib");

        //Create Event
        HashMap<String,Object> eventParams = new HashMap<String,Object>();
        eventParams.put("user", "user_rlox8k927z7p");
        eventParams.put("item", "item_wmt4fn6o4zlk");
        eventParams.put("behavior", "like");

        //Set getRecs to return fresh suggestions for the user [Optional]
        eventParams.put("getRecs", new HashMap<String,Object>());

        JSONObject resp = new JSONObject();
        try{
            JSONObject resp = tamber.event.track(eventParams);
        } catch(TamberException e) {
            e.printStackTrace();
        }
    }
}
```

See [Tests](https://github.com/tamber/tamber-java/tree/master/src/test/java/com/tamber) for more examples.

