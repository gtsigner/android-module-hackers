## 包装一些android常用工具


## gradle

dev
``` gradle
    //xposed 库
    compileOnly 'de.robv.android.xposed:api:82'
    compileOnly 'de.robv.android.xposed:api:82:sources'
    //    //bugly
    //    implementation 'com.tencent.bugly:crashreport:2.8.6'
    //    implementation 'com.tencent.bugly:nativecrashreport:3.6.0.1'
    implementation 'com.bugfender.sdk:android:1.1.4'
    //socket.io
    implementation('io.socket:socket.io-client:1.0.0') {
        // excluding org.json which is provided by Android
        exclude group: 'org.json', module: 'json'
    }
    //socket.io 服务端
    //    implementation 'com.corundumstudio.socketio:netty-socketio:1.7.17'
    //老版本，新版本支持N 24+
    implementation 'com.squareup.okhttp3:okhttp:2.6.0'
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
```