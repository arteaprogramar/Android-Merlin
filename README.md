![Merlin header image](https://github.com/novoda/merlin/blob/release/header.png)

Merlin aims to simplify network monitoring. Providing 3 registerable callbacks for network connectivity changes.
`onConnect()` , `onDisconnect()` and `onBind(NetworkStatus networkStatus)`.

## Adding to your project

To start using Merlin, add these lines to your module's `build.gradle`:

```groovy
repositories {
    jcenter()
}

dependencies {
    implementation 'com.novoda:merlin:1.2.0'
}
```

### Optional steps

**Note:** these steps should _not_ be necessary as the Manifest Merger should be taking care of this for you!

If for some reason your app's manifest doesn't end up containing the required entries, and you encounter issues, you might need to manually add a few things to your `AndroidManifest.xml`:

 1. These permissions:

    ```xml
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    ```

 2. This service:

    ```xml
    <service
      android:exported="false"
      android:name="com.novoda.merlin.MerlinService" />
    ```

## Sample usage

Create Merlin:

```java
merlin = new Merlin.Builder().withConnectableCallbacks().build(context);
```

Bind and unbind the service in your activity:

```java
@Override
protected void onResume() {
    super.onResume();
    merlin.bind();
}

@Override
protected void onPause() {
    merlin.unbind();
    super.onPause();
}
```

Register for callbacks:

```java
merlin.registerConnectable(new Connectable() {
    @Override
    public void onConnect() {
        // Do something you haz internet!
    }
});
```
