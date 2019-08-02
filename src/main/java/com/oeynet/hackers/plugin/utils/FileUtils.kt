package com.oeynet.hackers.plugin.utils

import android.os.Environment
import java.io.*
import java.net.URLDecoder
import java.net.URLEncoder


object FileUtils {
    val sdCardPath: String
        get() = Environment.getExternalStorageDirectory().toString() + "/"

    //写数据到SD中的文件
    fun writeFileSdcardFile(fileName: String, write_str: String) {
        try {

            //隐藏加密
//            var encryptStr = AESUtil.Encrypt(write_str)
//            encryptStr = URLEncoder.encode(encryptStr, "UTF-8")

            //LogUtils.s("加密数据："+encryptStr)

            val file = File(sdCardPath + fileName)
            if (!file.exists()) {
                file.createNewFile()
            }
            val fout = FileOutputStream(sdCardPath + fileName)
//            val bytes = encryptStr.toByteArray()
            val bytes = write_str.toByteArray()

            fout.write(bytes)
            fout.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun writeFileSdcardFileNoEnc(fileName: String, write_str: String) {
        try {

            val file = File(sdCardPath + fileName)
            if (!file.exists()) {
                file.createNewFile()
            }
            val fout = FileOutputStream(sdCardPath + fileName)
            val bytes = write_str.toByteArray()

            fout.write(bytes)
            fout.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    //读SD中的文件
    fun readFileSdcardFile(fileName: String): String {
        var res = ""
        try {
            val file = File(sdCardPath + fileName)
            if (!file.exists()) {
                file.createNewFile()
            }
            val fin = FileInputStream(sdCardPath + fileName)

            val length = fin.available()

            val buffer = ByteArray(length)
            fin.read(buffer)

            res = String(buffer)

            res = URLDecoder.decode(res, "UTF-8")
            //LogUtils.s("原返回数据：$res")

            //res = AESUtil.Decrypt(res)
            //LogUtils.s("解密返回数据：$res")

            fin.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return res
    }

    fun readFileSdcardFileNoEnc(fileName: String): String {
        var res = ""
        try {
            val file = File(sdCardPath + fileName)
            if (!file.exists()) {
                file.createNewFile()
            }
            val fin = FileInputStream(sdCardPath + fileName)

            val length = fin.available()

            val buffer = ByteArray(length)
            fin.read(buffer)

            res = String(buffer)
            fin.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return res
    }

    fun sendfile(str: String) {
        try {
            val dataOutputStream = DataOutputStream(Runtime
                .getRuntime().exec("su").outputStream)
            try {
                dataOutputStream.writeBytes("chmod 777 "+FileUtils.sdCardPath+"yijianxinji/\n")
                dataOutputStream.flush()
                dataOutputStream.writeBytes("cp $str "+FileUtils.sdCardPath+"yijianxinji/\n")
                dataOutputStream.flush()
                dataOutputStream.close()
                val path_arr = str.split("/")
                val fileName = path_arr[path_arr.size-1]
                if (File(FileUtils.sdCardPath+"yijianxinji/"+fileName).exists()) {
                    return
                }
                throw IOException()
            } catch (e2: IOException) {
                e2.printStackTrace()
            }

        } catch (e3: IOException) {
            e3.printStackTrace()
        }

    }

}