package com.oeynet.hackers.plugin.utils


import android.app.Activity
import android.content.Context
import android.widget.Toast

object ToastUtils {
    /** Toast第一次显示的内容  */
    private var oldMsg: String? = null
    /** Toast对象  */
    private var toast: Toast? = null
    /** Toast第一次显示的时间  */
    private var oneTime: Long = 0
    /** Toast第二次显示的时间  */
    private var twoTime: Long = 0

    /**
     * 显示Toast，为了解决Toast重复出现问题
     * @param context
     * @param message
     */
    fun showToast(context: Context, message: String) {
        if (toast == null) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
            toast!!.show()
            oneTime = System.currentTimeMillis()
        } else {
            twoTime = System.currentTimeMillis()
            if (message == oldMsg) {
                if (twoTime - oneTime > Toast.LENGTH_SHORT) {
                    toast!!.show()
                }
            } else {
                oldMsg = message
                toast!!.setText(message)
                toast!!.show()
            }
        }
        oneTime = twoTime
    }

    fun showToastOnThread(context: Activity, str: String) {
        if (Thread.currentThread().name == "main") {
            Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
        } else {
            context.runOnUiThread {
                // TODO Auto-generated method stub
                Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
