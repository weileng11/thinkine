    //android Material Design风格自定义控件
    implementation "net.qiujuer.genius:ui:$rootProject.ext.geniusVersion"
    implementation "net.qiujuer.genius:res:$rootProject.ext.geniusVersion"
    //retrofit框架
    implementation "com.squareup.retrofit2:retrofit:2.4.0"
    implementation "com.squareup.retrofit2:converter-gson:2.4.0"
    implementation "com.squareup.retrofit2:adapter-rxjava2:2.4.0"
    implementation "io.reactivex.rxjava2:rxjava:2.2.1"
    implementation "io.reactivex.rxjava2:rxandroid:2.1.0"
    implementation "com.google.code.gson:gson:2.8.0"
    //注解
    implementation "com.jakewharton:butterknife:$rootProject.ext.butterknifeVersion"
    annotationProcessor "com.jakewharton:butterknife-compiler:$rootProject.ext.butterknifeVersion"
    // Glide 包
    implementation "com.github.bumptech.glide:glide:$rootProject.ext.glideVersion"
    //eventbus
    implementation "org.greenrobot:eventbus:$rootProject.ext.eventbusVersion"
    //弹窗框架
    implementation "com.github.zyyoona7:EasyPopup:$rootProject.ext.easyPopupVersion"
    //rv侧滑框架，头部底部
    implementation "com.yanzhenjie:recyclerview-swipe:$rootProject.ext.recyclerviewSwipeVersion"
    //图片选择框架
    implementation "com.lijunguan:imageseletor:$rootProject.ext.imageseletorVersion"
    implementation "com.android.support.constraint:constraint-layout:$rootProject.ext.constraintLayoutVersion"
    //圆形圆角
    implementation "com.makeramen:roundedimageview:$rootProject.ext.roundedimageviewVersion"
    //图片选择框架（包含很多）
    implementation "com.github.LuckSiege.PictureSelector:picture_library:$rootProject.ext.pictureLibraryVersion"
    //七牛
    api "com.qiniu:qiniu-android-sdk:$rootProject.ext.qiniuAndroidSdkVersion"
    //手势解锁、手势密码、九宫格密码、九宫格图形
    implementation "com.github.ihsg:PatternLocker:$rootProject.ext.PatternLockerVersion"
     //按钮
    implementation "com.kyleduo.switchbutton:library:$rootProject.ext.switchbuttonVersion"

    implementation "com.uber.autodispose:autodispose:$rootProject.ext.autodisposeVersion"
    implementation "com.uber.autodispose:autodispose-android:$rootProject.ext.autodisposeVersion"
    implementation "com.uber.autodispose:autodispose-android-archcomponents:$rootProject.ext.autodisposeVersion"

    //二维码扫描
    implementation "cn.yipianfengye.android:zxing-library:$rootProject.ext.zxinglibraryVersion"
    //权限
    implementation "pub.devrel:easypermissions:$rootProject.ext.easyPMVersion"

    implementation "com.shizhefei:ViewPagerIndicator:$rootProject.ext.viewPagerIndicatorVersion"
    //刷新框架
    implementation "com.scwang.smartrefresh:SmartRefreshLayout:$rootProject.ext.SmartRefreshLayoutVersion"

    //热更新
    implementation "com.tencent.bugly:crashreport_upgrade:$rootProject.ext.Bugly_crashreport_upgrade_Version"
    implementation "com.tencent.bugly:nativecrashreport:$rootProject.ext.Bugly_nativecrashreport_Version"
    //阿里推送
    implementation 'com.aliyun.ams:alicloud-android-push:3.1.3@aar'
    implementation 'com.aliyun.ams:alicloud-android-utils:1.1.3'
    implementation 'com.aliyun.ams:alicloud-android-beacon:1.0.1'
    //toast
    implementation "com.hjq:toast:$rootProject.ext.ToastVersion"
    //mmkv 保存
    implementation "com.tencent:mmkv:$rootProject.ext.mmkvVersion"
    //log
    implementation "com.orhanobut:logger:$rootProject.ext.loggerVersion"

    implementation project(':picker')

    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    testImplementation 'junit:junit:4.12'
    implementation 'com.android.support:cardview-v7:27.1.1'

    //适配
    implementation "me.jessyan:autosize:$rootProject.ext.autosizeVersion"
    implementation "net.qiujuer.genius:kit-handler:$rootProject.ext.geniusVersion"

    //	implementation 'com.github.devlight:infinitecycleviewpager:1.0.2'
    implementation 'com.github.weileng11:InfiniteCycleViewPager-master:1.0.4'

    //引导蒙层
    implementation 'com.github.huburt-Hu:NewbieGuide:v2.4.0'
    implementation project(':mzbanner')
    implementation project(':loopbanner')
    implementation 'com.flyco.tablayout:FlycoTabLayout_Lib:2.0.2@aar'
    implementation project(path: ':xLog')
    implementation 'com.yanzhenjie:recyclerview-swipe:1.1.3'

    //    implementation 'com.elvishew:xlog:1.6.1'
    implementation 'com.github.WenHuayu:GlidePlaceholderDrawable:1.0.0'
    implementation project(path: ':common')

    implementation 'com.necer.ncalendar:ncalendar:4.0.2'



  Android应用图标微技巧，8.0系统中应用图标的适配
  https://blog.csdn.net/guolin_blog/article/details/79417483




#  Android 必须知道2019年流行的框架库及开发语言

## 2018 已经悄悄的走了，2019 也已经匆匆的来了，我们在总结过去的同时，也要展望一下未来，来规划一下今年要学哪些新技术。这几年优秀Android的开源库不断推出，新技术层出不穷，需要我们不断去了解和掌握，在提高自身开发水平的同时，我们需要付出更多学习精力和时间。俗话说，打铁还需自身硬，为了在这个日新月异的技术时代为了生存不被淘汰，必须要求自身掌握的技术不断跟进时代脚步，所以我们必须付出才能得到回报，说没有时间去学习的人永远都会有找不完的借口。好了，闲话不多说了，下面一起来看看流行的技术吧。

### 1.图片加载库

- Picasso，谐音"毕加索",听起来就很艺术，是 Square开源的项目，主导者是是Android大神JakeWharton。

- Glide，是google员工在Picasso基础上进行优化，总体比Picasso更优秀，在Google很多项目在用。

### 2.图片加载库

- EventBus ，是一个发布、订阅的轻量级事件总线框架，基于观察者模式的实现的线程通信框架。

- RxJava， 一个在 Java VM 上使用可观测的序列来组成异步的、基于观察者模式的实现的库。

- RxAndroid，函数响应式编程， 把 RxJava 带到 Android 环境中。很多时候，编写 Android 程序，你也可以看成是数据的处理和流动，换一种思想编程，曾经看起来很棘手的问题，瞬间就很优雅的解决了，相信你会被这种build模式的开发会越来越爱。
 
- RxBinding，是 Jake Wharton 的一个开源库，它提供了一套在 Android 平台上的基于 RxJava的 Binding API。所谓 Binding，就是类似设置 OnClickListener 、设置 TextWatcher 这样的注册绑定对象的 API。

### 3.注入注解框架

- Butterknife，出自大神JakeWharton，绑定视图和回调字段和方法。例如，减少了findViewById()的繁琐操作。

- Dagger2，与Spring 的IOC差不多吧。这个框架它的好处是它没有采用反射技术（Spring是用反射的）,而是用预编译技术，因为基于反射的DI非常地耗用资源（空间，时间）。

### 4.设计模式

- MVP，因为 Android 并没有严格的业务和界面区分，项目一庞大，就很容易使代码结构显得越来越乱。现在 Android 端对 MVP 模式讨论越来越热，谷歌6.0API以及更多的体现了MVP设计思维，觉得 MVP 是非常适合 Android 上的APP 开发。

- MVVM ，这是因为开始官方支持 DataBinding，把 MVVM 直接带到 Android 中。数据绑定在 Windows WPF 和 Web （尤其JSP中）已经非常常见，它非常高效的开发效率，让你只关心你的数据和业务。这也对 Android 开发来说，无疑是一个非常重大的里程碑

### 5.UI框架
- BaseRecyclerViewAdapterHelper使用——RecyclerView万能适配器。

- PinnedSectionItemDecoration：强大的粘性标签库

- EasyRefreshLayout：    轻松实现下拉刷新和上拉更多

- EasySwipeMenuLayout：仿IOS侧滑删除

- SmartRefreshLayout，下拉刷新、上拉加载、二级刷新、淘宝二楼、RefreshLayout、OverScroll，Android智能下拉刷新框架，支持越界回弹、越界拖动，具有极强的扩展性，集成了几十种炫酷的Header和 Footer。 也吸取了现在流行的各种刷新布局的优点，包括谷歌官方的 SwipeRefreshLayout，其他第三方的 Ultra-Pull-To-Refresh、TwinklingRefreshLayout 。还集成了各种炫酷的 Header 和 Footer。

- android-gif-drawable，用于在Android上显示动画GIF的视图和Drawable。

- PhotoView ，用于在Android上通过各种触摸手势实现支持缩放的图片的框架。

### 6.网络请求库

- okhttp，在Android开发中，它已经成为眼下最火的http请求框架了。

- Retrofit，与okhttp共同出自于Square公司，retrofit就是对okhttp做了一层封装。把网络请求都交给给了Okhttp，我们只需要通过简单的配置就能使用retrofit来进行网络请求了，其主要作者也是Android大神JakeWharton。

### 7.日志打印库

- logger，简单,漂亮的android和强大的记录器。

### 8.权限请求库

- RxPermissions，API23以上Android 6.0项目分为普通权限和危险权限，该库在项目运行时动态进行权限请求，支持RxJava2。

### 9.个人常用库
- 强大而灵活的RecyclerView Adapter[BaseRecyclerViewAdapterHelper](https://github.com/CymChad/BaseRecyclerViewAdapterHelper)

- EasyPopup 对 PopupWindow 的封装，使得在项目中使用起来更加简单、方便、快捷 [EasyPopup](https://github.com/zyyoona7/EasyPopup)

- SwipeRecyclerView RecyclerView侧滑菜单，滑动删除，长按拖拽，下拉刷新上拉加载 [SwipeRecyclerView](https://github.com/yanzhenjie/SwipeRecyclerView)

- RoundedImageView Android图片圆角转换 RoundedImageView开源项目[RoundedImageView](https://github.com/vinc3m1/RoundedImageView)

- PatternLocker Android 图形解锁／手势解锁 / 手势密码 / 图案密码 / 九宫格密码 [PatternLocker](https://github.com/ihsg/PatternLocker)

- autodispose Android架构中添加AutoDispose解决RxJava内存泄漏 [autodispose](https://blog.csdn.net/mq2553299/article/details/79418068)

- zxing 扫码 [zxing](https://github.com/yipianfengye/android-zxingLibrary)

- pub.devrel:easypermissions  Easypermissions简化了Android M的运行时权限的申请、结果处理、判断等步骤 [权限](https://www.jianshu.com/p/2b3661928e66)

- toast 性能最优、使用最简单，支持自定义，不需要通知栏权限的吐司 [toast](https://github.com/getActivity/ToastUtils)

- mmkv MMKV 是基于 mmap 内存映射的移动端通用 key-value 组件，底层序列化/反序列化使用 protobuf 实现，性能高，稳定性强。[MMKV](https://github.com/tencent/mmkv)

- bluetooth    库用于Android蓝牙BLE设备通信，支持设备扫描，连接，读写，通知。[bluetooth](https://github.com/dingjikerbo/Android-BluetoothKit)

- autosize 今日头条屏幕适配方案终极版，一个极低成本的 Android 屏幕适配方案 [autosize](https://github.com/JessYanCoding/AndroidAutoSize)

- FlycoTabLayout 一个Android TabLayout库,目前有两个TabLayout [FlycoTabLayout](https://www.jianshu.com/p/9c32f1804cd1)

- SwipeBackHelper 使用物理返回键的情况下舍去了返回的Button [SwipeBackHelper](https://blog.csdn.net/ddwhan0123/article/details/48261597)

- 工具包  AndroidUtilCode fire 是一个强大易用的安卓工具类库[AndroidUtilCode](https://github.com/Blankj/AndroidUtilCode/blob/master/README-CN.md)

- ByRecyclerView：真·万能分割线 (线性/宫格/瀑布流)[万能分割线](https://github.com/youlookwhat/ByRecyclerView)

- Timber 打印log日志  (https://github.com/JakeWharton/timber)

- XLog  打印日志到文本  [XLog](https://github.com/elvishew/XLog/blob/master/README_ZH.md)
### 10.网络好文章兼各种库

- 1.滴滴开源项目DoraemonKit在 GitHub上的star数突破10000，成为滴滴首个star数破万的开源项目 [DoraemonKit](https://github.com/didi/DoraemonKit)
- [说明文章](https://mp.weixin.qq.com/s/MGeo5NOHjDbj5bOZdg2iFw)
- 2.Android权限请求库 [这可能是最好用、实现最简单的Android权限请求库了](https://blog.csdn.net/a1018875550/article/details/103533668)
- 3.[自动轮播无限循环Android库](https://mp.weixin.qq.com/s/p2lhx7xj0YSNa_Fwnhwp8w) (https://github.com/zhpanvip/BannerViewPager/)
- 4.[Android圆角ViewGrup](https://www.jianshu.com/p/3051b5d60c7c)
- 5.[Android 界最万能的 TabLayout](https://github.com/angcyo/DslTabLayout)
- 6.[下载要支持多任务并行下载](https://mp.weixin.qq.com/s/NGIlPFSSzaCD2grVJjGfHw)(https://github.com/AriaLyy/Aria)
- 7.[RxHttp 让你眼前一亮的Http请求框架](https://juejin.im/post/5ded221a518825125d14a1d4)
- 8.[网络请求只会用Retrofit？外国人已经在用Apollo Graphql了](https://mp.weixin.qq.com/s/Jp2wbwVCec3mAt08-0aBdg)
- 9.[花式实现时间轴，样式由你来定](https://mp.weixin.qq.com/s/jNG_dRRhc3pDZK9fax4ycg)
- 10.[Android 开发者的福利，介绍几款看源码的工具](https://zhuanlan.zhihu.com/p/100117330)
- 11.[学不动也要学！探究Fragmen延迟加载的前世今生](https://juejin.im/post/5e085dafe51d45580769a1eb)
- 12.[自定义控件通用库 WidgetCase](https://www.wanandroid.com/blog/show/2683)
- 13.[Orient-Ui | 单RecyclerView实现花式表格](https://juejin.im/post/5e1bca86e51d45529f72f6c3)
- 14.[Android自定义控件进阶篇，自定义LayoutManager](https://mp.weixin.qq.com/s/j0RBxRGleIm_PRkMYFtXbw)
- 15.[一行代码即可接入，二级联动订餐列表](https://github.com/KunMinX/Linkage-RecyclerView)
- 16.[2020年GitHub 上那些优秀Android开源库，这里是Top10！](https://www.jianshu.com/p/3f5865109b05)
- 17.[Android持续滑动布局ConsecutiveScrollerLayout的使用](https://www.jianshu.com/p/0783b0a37fa1)

### 11.值得学习的文章
- 学不动也要学！深入了解ViewPager2 [说明文章](https://juejin.im/post/5df4aabe6fb9a0161104c8eb#comment)
- [作者说这是初级Android工程师的面经？吓到我了](https://mp.weixin.qq.com/s/-supfOYPfDB_PKs6f8WIPw)
- [Kotlin系列 - 函数与类相关细节小结(二)](https://juejin.im/post/5dff8f1df265da33d21e8286)
- [学习 View 事件分发，就像外地人上了黑车！](https://juejin.im/post/5d3140c951882565dd5a66ef)
- [Android OKHttp 可能你从来没用过的拦截器 ](https://juejin.im/post/5ddddd2a6fb9a07161483fb2)
- [学不动了系列，又来推荐一波优质项目咯 ](https://mp.weixin.qq.com/s/Aa4RIbWKzwQTLsdjmM16SA)
- [Android 程序员不得不收藏的 90+ 个人博客(持续更新...](https://juejin.im/post/5e0389ec5188251281602a2e)
- [小红书图片剪裁框架+微信图片选择器+超高清大图预览+自定义比例剪裁，支持UI自定义、支持跨进程回调](https://www.wanandroid.com/blog/show/2686)
- [【Android 架构之MVVM】MVVM架构的基本搭建](https://blog.csdn.net/qq_41423726/article/details/103734217)
- [为什么Dialog弹出以后，activity就无法捕捉触摸事件了？](https://www.jianshu.com/p/9857c45737de)
-  参考 [Android博客周刊](http://androidblog.cn/index.php/Index/detail/id/89)

