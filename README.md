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
  <version>1.0.0</version>
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
        Tamber tamber = new Tamber("H4y13AJ1QMlgzOqZ0sib");
        HashMap<String,Object> actorParams = new HashMap<String,Object>();
        actorParams.put("id", "2197054087");
        List<HashMap<String,Object>> behaviors = new ArrayList<HashMap<String,Object>>();
        HashMap<String,Object> b1 = new HashMap<String,Object>();
        b1.put("behavior", "like");
        b1.put("item", "HZNP");
        b1.put("value", 1.0);
        behaviors.add(b1);
        actorParams.put("behaviors", behaviors);

        JSONObject resp = new JSONObject();
        try{
            JSONObject resp = tamber.actor.create(actorParams);
        } catch(TamberException e) {
            e.printStackTrace();
        }
    }
}
```

See [Tests](https://github.com/tamber/tamber-java/tree/master/src/test/java/com/tamber) for more examples.

