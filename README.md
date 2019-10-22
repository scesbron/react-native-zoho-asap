# react-native-zoho-asap

## Getting started

`$ npm install react-native-zoho-asap --save`

### Mostly automatic installation

`$ react-native link react-native-zoho-asap`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-zoho-asap` and add `ZohoAsap.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libZohoAsap.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import fr.wecasa.ZohoAsapPackage;` to the imports at the top of the file
  - Add `new ZohoAsapPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-zoho-asap'
  	project(':react-native-zoho-asap').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-zoho-asap/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      implementation project(':react-native-zoho-asap')
  	```


## Usage

### Proguard setup

Add this to the `proguard-rules.pro` file 

```
-keep class com.zoho.** {*;}
-keep interface android.support.v7.** { *; }
-keep class android.support.v7.** { *; }
-keep interface android.support.v4.** { *; }
-keep class android.support.v4.** { *; }
-keepattributes Signature
-keepattributes Annotation
-keep class okhttp3.* { *; }
-keep interface okhttp3.* { *; }
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn com.zoho.accounts.**
-dontwarn com.squareup.okhttp.**
-dontwarn okio.**
-dontwarn retrofit2.**
```

### Add maven repository

Add in the root `build.gradle` file of the project the repository

```
maven { url 'http://maven.zohodl.com/' }
```


```javascript
import ZohoAsap from 'react-native-zoho-asap';

// Initialize the module
ZohoAsap.init(orgId, appId, dataCenterValue);

// In the screen that shows the dashboard
ZohoAsap.startDeskHomeScreen();
```
