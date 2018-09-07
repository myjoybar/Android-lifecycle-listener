# Android-lifecycle-listener
Monitor the life cycle of Activity，FragmentActivity，Fragment，v4.app.Fragment

传入Activity，FragmentActivity的上下文，Fragment 或者 v4.app.Fragment的引用

## Features
 - Monitor the life cycle of Activity，FragmentActivity，Fragment，v4.app.Fragment



 ![image](https://github.com/myjoybar/Android-lifecycle-listener/blob/master/screenshots/screenshot1.jpeg) 
 
  ![image](https://github.com/myjoybar/Android-lifecycle-listener/blob/master/screenshots/screenshot2.jpeg) 
  
# Installation

####  Maven:
```gradle
 <dependency>
  <groupId>com.joybar.lifecycle</groupId>
  <artifactId>lifecyclelistener</artifactId>
  <version>1.0.1</version>
  <type>pom</type>
</dependency>
```

####  Gradle:
```gradle
  compile 'com.joybar.lifecycle:lifecyclelistener:1.0.4'
```
## Sample Usage


```java
   LifecycleManager lifecycleManager = new LifecycleManager(fragmentTagName);
		lifecycleManager.registerLifecycleListener(context, new LifecycleListener() {
			@Override
			public void onStart() {
				Log.d(TAG, fragmentTagName+"_"+"onStart");
			}

			@Override
			public void onResume() {
				Log.d(TAG, fragmentTagName+"_"+"onResume");
			}

			@Override
			public void onPause() {
				Log.d(TAG, fragmentTagName+"_"+"onPause");
			}

			@Override
			public void onStop() {
				Log.d(TAG, fragmentTagName+"_"+"onStop");
			}

			@Override
			public void onDestroy() {
				Log.d(TAG, fragmentTagName+"_"+"onDestroy");
			}
		});

```


## License

    Copyright 2017 MyJoybar

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


