package com.oeynet.hackers.hook.utils


import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge


object Logger {


    fun debug(tag: String, message: String) {
        XposedBridge.log("$tag=====$message")
    }

    public fun printLogs(tag: String, param: XC_MethodHook.MethodHookParam) {
        var str = "$tag@${param.method}->Result=${param.result}"
        param.args?.forEach {
            try {
                str += "#Params:${it.javaClass}____$it\t"
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
        str += "参数:${param.args?.size}个"
        XposedBridge.log(str)
    }

    fun printCallStatck() {
        val ex = Throwable()
        ex.printStackTrace()
        val stackElements = ex.stackTrace
        if (stackElements != null) {
            for (i in stackElements.indices) {
                print(stackElements[i].className + "/t")
                print(stackElements[i].fileName + "/t")
                print(stackElements[i].lineNumber.toString() + "/t")
                println(stackElements[i].methodName)
                println("-----------------------------------")
            }
        }
    }
}