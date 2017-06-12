## Minimum
This is minimal Android application written without IDE, in a simple text editor and compiled in command line.
It's goal is to understand how to create Android application from scratch, its structure, and necessary tools.

The project is based on [this article on Russian](https://habrahabr.ru/post/210584/) and [this article on English](http://geosoft.no/development/android.html).

Steps to repeat the project goal.

1. Install JDK and Android SDK.

2. Create folder structure for the project.
```
│   AndroidManifest.xml
├───bin
├───obj
├───res
│   └───values
│           strings.xml
│
└───src
    └───com
        └───example
            └───testapp
                    MainActivity.java
```

3. Create AndroidManifest file.
```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android" package="ru.coffeeplanter.minimum">
	<uses-sdk android:targetSdkVersion="25"/>
	<application android:label="Minimum">
		<activity android:name=".MainActivity">
			<intent-filter>
				<action android:name="android.intent.action.MAIN"/>
				<category android:name="android.intent.category.LAUNCHER"/>
			</intent-filter>
		</activity>
	</application>
</manifest>
```

4. Create resources file.
```xml
<resources>
	<string name="text_label">This is an app written in a simple text editor, without IDE.</string>
</resources>
```

5. Write Java code.
```java
package ru.coffeeplanter.minimum;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		textView.setText(getString(R.string.text_label));
		setContentView(textView);
	}

}
```

6. Choose platform and tools version. This project uses 25.0.2 version.

7. Create R.java class file by this command.
```bash
<PATH_TO_YOUR_ANDROID_SDK>/build-tools/25.0.2/aapt
	package
	-f
	-m
	-S <PATH_TO_YOUR_PROJECT>/res
	-J <PATH_TO_YOUR_PROJECT>/src
	-M <PATH_TO_YOUR_PROJECT>/AndroidManifest.xml
	-I <PATH_TO_YOUR_ANDROID_SDK>/platforms/android-25/android.jar
```

8. Compile the project to java binary files.
```bash
javac
	-source 7
	-target 7
	-verbose
	-d <PATH_TO_YOUR_PROJECT>/obj
	-classpath <PATH_TO_YOUR_ANDROID_SDK>/platforms/android-25/android.jar:<PATH_TO_YOUR_PROJECT>/obj
	-sourcepath <PATH_TO_YOUR_PROJECT>/src
	<PATH_TO_YOUR_PROJECT>/src/ru/coffeeplanter/minimum/*.java
```

9. Create dex file for Android Java machine. Use here absolute path, otherwise it can an error occur.
```bash
<PATH_TO_YOUR_ANDROID_SDK>/build-tools/25.0.2/dx
	--dex
	--verbose
	--output=<PATH_TO_YOUR_PROJECT>/bin/classes.dex
	<PATH_TO_YOUR_PROJECT>/obj
```

10. Make ansigned apk file.
```bash
<PATH_TO_YOUR_ANDROID_SDK>/build-tools/25.0.2/aapt
	package
	-f
	-M <PATH_TO_YOUR_PROJECT>/AndroidManifest.xml
	-S <PATH_TO_YOUR_PROJECT>/res
	-I <PATH_TO_YOUR_ANDROID_SDK>/platforms/android-25/android.jar
	-F <PATH_TO_YOUR_PROJECT>/bin/AndroidTest.unsigned.apk
	<PATH_TO_YOUR_PROJECT>/bin
```

11. Generate keystore file, if you don't have it.
```bash
keytool
	-genkey
	-validity 10000
	-dname "CN=AndroidDebug, O=Android, C=US"
	-keystore <PATH_TO_YOUR_KEYSTORE>/AndroidTest.keystore
	-storepass <YOUR_STORE_PASSWORD>
	-keypass <YOUR_KEY_PASSWORD>
	-alias <YOUR_KEY_NAME>
	-keyalg RSA
	-v
	-keysize 2048
```

12. Sign your project with the keystore file.
```bash
jarsigner
	-sigalg SHA1withRSA
	-digestalg SHA1
	-keystore <PATH_TO_YOUR_KEYSTORE>/AndroidTest.keystore
	-storepass <YOUR_STORE_PASSWORD>
	-keypass <YOUR_KEY_PASSWORD>
	-signedjar %DEV_HOME%/bin/AndroidTest.signed.apk
	<PATH_TO_YOUR_PROJECT>/bin/AndroidTest.unsigned.apk
	<YOUR_KEY_NAME>
```

13. Install the compiled and signed app on a phone or emulator.
```bash
<PATH_TO_YOUR_ANDROID_SDK>/platform-tools/adb uninstall ru.coffeeplanter.minimum
<PATH_TO_YOUR_ANDROID_SDK>/platform-tools/adb install <PATH_TO_YOUR_PROJECT>/bin/AndroidTest.signed.apk
<PATH_TO_YOUR_ANDROID_SDK>/platform-tools/adb shell am start ru.coffeeplanter.minimum/ru.coffeeplanter.minimum.MainActivity
```

![Screenshot](/screenshot.png?raw=true "Screenshot")
