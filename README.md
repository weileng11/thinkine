implementation "net.qiujuer.genius:ui:$rootProject.ext.geniusVersion"
    implementation "net.qiujuer.genius:res:$rootProject.ext.geniusVersion"
    implementation "com.squareup.retrofit2:retrofit:$rootProject.ext.retrofitVersion"
    implementation "com.squareup.retrofit2:converter-gson:$rootProject.ext.retrofitVersion"
    implementation "com.squareup.retrofit2:adapter-rxjava2:$rootProject.ext.retrofitVersion"
    implementation "io.reactivex.rxjava2:rxjava:$rootProject.ext.rxjavaVersion"
    implementation "io.reactivex.rxjava2:rxandroid:$rootProject.ext.rxAndroidVersion"
    implementation "com.google.code.gson:gson:$rootProject.ext.gsonVersion"
    implementation "com.jakewharton:butterknife:$rootProject.ext.butterknifeVersion"
    annotationProcessor "com.jakewharton:butterknife-compiler:$rootProject.ext.butterknifeVersion"
    // Glide 包
    implementation "com.github.bumptech.glide:glide:$rootProject.ext.glideVersion"
    implementation "org.greenrobot:eventbus:$rootProject.ext.eventbusVersion"
    implementation "com.github.zyyoona7:EasyPopup:$rootProject.ext.easyPopupVersion"
    implementation "com.yanzhenjie:recyclerview-swipe:$rootProject.ext.recyclerviewSwipeVersion"
    implementation "com.lijunguan:imageseletor:$rootProject.ext.imageseletorVersion"
    implementation "com.android.support.constraint:constraint-layout:$rootProject.ext.constraintLayoutVersion"

    implementation "com.makeramen:roundedimageview:$rootProject.ext.roundedimageviewVersion"

    implementation "com.github.LuckSiege.PictureSelector:picture_library:$rootProject.ext.pictureLibraryVersion"
    api "com.qiniu:qiniu-android-sdk:$rootProject.ext.qiniuAndroidSdkVersion"

    implementation "com.github.ihsg:PatternLocker:$rootProject.ext.PatternLockerVersion"

    implementation "com.kyleduo.switchbutton:library:$rootProject.ext.switchbuttonVersion"

    implementation "com.uber.autodispose:autodispose:$rootProject.ext.autodisposeVersion"
    implementation "com.uber.autodispose:autodispose-android:$rootProject.ext.autodisposeVersion"
    implementation "com.uber.autodispose:autodispose-android-archcomponents:$rootProject.ext.autodisposeVersion"

    implementation "cn.yipianfengye.android:zxing-library:$rootProject.ext.zxinglibraryVersion"
    implementation "pub.devrel:easypermissions:$rootProject.ext.easyPMVersion"

    implementation "com.shizhefei:ViewPagerIndicator:$rootProject.ext.viewPagerIndicatorVersion"
    implementation "com.scwang.smartrefresh:SmartRefreshLayout:$rootProject.ext.SmartRefreshLayoutVersion"

    implementation "com.tencent.bugly:crashreport_upgrade:$rootProject.ext.Bugly_crashreport_upgrade_Version"
    implementation "com.tencent.bugly:nativecrashreport:$rootProject.ext.Bugly_nativecrashreport_Version"

    implementation 'com.aliyun.ams:alicloud-android-push:3.1.3@aar'
    implementation 'com.aliyun.ams:alicloud-android-utils:1.1.3'
    implementation 'com.aliyun.ams:alicloud-android-beacon:1.0.1'

    implementation "com.hjq:toast:$rootProject.ext.ToastVersion"

    implementation "com.tencent:mmkv:$rootProject.ext.mmkvVersion"

    implementation "com.orhanobut:logger:$rootProject.ext.loggerVersion"

    implementation project(':picker')

    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    testImplementation 'junit:junit:4.12'
    implementation 'com.android.support:cardview-v7:27.1.1'