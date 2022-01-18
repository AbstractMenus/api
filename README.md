# AbstractMenus API

API for AbstractMenus plugin.

## Usage

**Docs:** https://abstractmenus.github.io/docs/dev/general.html

Note, that latest API version is not the latest version of AbstractMenus plugin. 
Several AM version can use same API. 
You can check last version in [releases section on jitpack](https://jitpack.io/#AbstractMenus/api)

### Gradle

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    compileOnly 'com.github.AbstractMenus:api:1.14'
}
```

### Maven

```xml
<repositories>
    <repository>
        <id>jitpack</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.AbstractMenus</groupId>
        <artifactId>api</artifactId>
        <version>1.14</version>
    </dependency>
</dependencies>
```
