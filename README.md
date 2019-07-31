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




  Android应用图标微技巧，8.0系统中应用图标的适配
  https://blog.csdn.net/guolin_blog/article/details/79417483




  Android 必须知道2019年流行的框架库及开发语言

### 2018 已经悄悄的走了，2019 也已经匆匆的来了，我们在总结过去的同时，也要展望一下未来，来规划一下今年要学哪些新技术。这几年优秀Android的开源库不断推出，新技术层出不穷，需要我们不断去了解和掌握，在提高自身开发水平的同时，我们需要付出更多学习精力和时间。俗话说，打铁还需自身硬，为了在这个日新月异的技术时代为了生存不被淘汰，必须要求自身掌握的技术不断跟进时代脚步，所以我们必须付出才能得到回报，说没有时间去学习的人永远都会有找不完的借口。好了，闲话不多说了，下面一起来看看流行的技术吧。

## 1.图片加载库

- Picasso，谐音"毕加索",听起来就很艺术，是 Square开源的项目，主导者是是Android大神JakeWharton。

- Glide，是google员工在Picasso基础上进行优化，总体比Picasso更优秀，在Google很多项目在用。

