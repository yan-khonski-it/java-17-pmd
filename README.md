# pmd-java-17
It could be used as a starter project to build with **Java 17**, **maven**, **pmd**, **log4j2**.
You can re-use it in other projects.

Feel free to contribute and improve it.

It uses [Google Style formatting](https://github.com/google/styleguide/blob/gh-pages/intellij-java-google-style.xml).

I used category **category/java/bestpractices.xml**
from https://github.com/pmd/pmd/blob/master/pmd-java/src/main/resources/rulesets/java/imports.xml

To run it, build with maven and then run the main class `DemoApp`. 
```
mvn clean install
```

You can play with the java code, for example uncomment different sections and run PMD and see the errors.
PMD check is the part of the **package** stage.

### Example
If you rename the method and its argument into
```java
public final class NumberUtils {

  // try to rename it to fo(n)
  public static String fo(int n) {
    return "[" + n + "]";
  }
}
```
The PMD result will be
```text
[INFO] PMD Failure: com.yk.utils.java17pmd.app.utils.NumberUtils:10 Rule:ShortMethodName Priority:3 Avoid using short method names.
[INFO] PMD Failure: com.yk.utils.java17pmd.app.utils.NumberUtils:10 Rule:ShortVariable Priority:3 Avoid variables with short names like n.
```

## Problems I faced.

### Warning about deprecated rules
There was a warning when I tried to use a specific rule.
I found this comment:
```commandline
 <!-- Rules, that have been moved into a category -->
```
in the [source code](https://github.com/pmd/pmd/blob/master/pmd-java/src/main/resources/rulesets/java/junit.xml)
So instead of using a specific rule, I would use a category.

```xml
<ruleset>category/java/bestpractices.xml</ruleset>
```
instead of
```xml
<ruleset>rulesets/java/imports.xml</ruleset>
```

The warning text:

> [WARNING] Use Rule name category/java/bestpractices.xml/UnusedImports instead of the deprecated Rule name 
> C:\Dev\workspaces\utils\java-17-pmd\target\pmd\rulesets\imports.xml/UnusedImports. 
> PMD 7.0.0 will remove support for this deprecated Rule name usage.

### PMD was not run
Added the execution configuration and explicitly use goal **check** in the **package** phase.
```xml
<executions>
  <execution>
    <id>check pmd and fail</id>
    <phase>package</phase>
    <goals>
      <goal>check</goal>
    </goals>
  </execution>
</executions>
```

### Unit test was not run
I added **maven-surefire-plugin**.
https://stackoverflow.com/questions/53433663/maven-not-running-junit-5-tests


## Old versions reference (archived).
- https://github.com/yan-khonski-it/pmd-java-14
- https://github.com/yan-khonski-it/mvn-pmd-java11

## References
- https://pmd.github.io/pmd/pmd_rules_java_codestyle.html#shortvariable
- https://pmd.github.io/latest/pmd_userdocs_suppressing_warnings.html
- https://www.baeldung.com/pmd
- https://maven.apache.org/plugins/maven-pmd-plugin/usage.html
- https://github.com/google/styleguide
- https://github.com/pmd/pmd/blob/master/pmd-java/src/main/resources/rulesets/java/imports.xml
- https://github.com/apache/maven-surefire