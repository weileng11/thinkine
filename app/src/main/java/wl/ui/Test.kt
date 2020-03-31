package wl.ui

import android.util.Log

/**
 * @author: bruce
 * @project: thinkine
 * @package: wl.ui
 * @description:
 * @date: 2020/3/24
 * @time:  16:39
 */
open class Test{

    class Test constructor(){
        init {

        }
    }

//    constructor(name :String){
//
//    }

    val book=Book()
    fun test(){
        Log.i("info",book.lock)
    }

    class Book{
        var name:String="22"
        var lock:String="33"
    }

   fun foo()=2
    open fun test2() {}
}

abstract  class test1 :Test(){
   abstract override fun test2()
}