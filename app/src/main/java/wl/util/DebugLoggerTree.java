//package wl.util;
//
//import android.os.Build;
//import android.support.annotation.Nullable;
//
//
///**
// *    author : Android 轮子哥
// *    github : https://github.com/getActivity/AndroidProject
// *    time   : 2020/08/12
// *    desc   : 自定义日志打印规则
// */
//public class DebugLoggerTree extends Timber.DebugTree {
//
//    private static final int MAX_TAG_LENGTH = 23;
//
//    /**
//     * 创建日志堆栈 TAG
//     */
//    @Override
//    protected @Nullable
//    String createStackElementTag(@NotNull StackTraceElement element) {
//        String tag = "(" + element.getFileName() + ":" + element.getLineNumber() + ")";
//        // 日志 TAG 长度限制已经在 Android 7.0 上面移除
//        if (tag.length() <= MAX_TAG_LENGTH || Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            return tag;
//        }
//        return tag.substring(0, MAX_TAG_LENGTH);
//    }
//}