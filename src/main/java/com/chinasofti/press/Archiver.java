package com.chinasofti.press;

import com.chinasofti.utils.Util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Archiver {
    public static void main(String[] args) throws Exception{
        FileOutputStream fos = new FileOutputStream("d:/arch/x.xar");
        fos.write(addFile("d:/arch/a.jpg"));
        fos.write(addFile("d:/arch/b.png"));
    }

    /**
     *
     * @param path : d/XXX/XXX/a.jpg
     * @return
     */
    public static byte[] addFile(String path) throws Exception{
       File f = new File(path);
       //文件名
       String fname = f.getName();
       //文件名数组
       byte[] fnameBytes = fname.getBytes();
       //文件内容长度
       int len = (int)f.length();
       //计算总长度
       int total = 4+fnameBytes.length+4+len;
       //初始化总数组
       byte[] bytes = new byte[total];

       //写入文件名长度
       byte[] fnameLenArr = Util.int2Bytes(fnameBytes.length);
       System.arraycopy(fnameLenArr,0,bytes,0,4);

       //写入文件名本身
        System.arraycopy(fnameBytes,0,bytes,4,fnameBytes.length);

        //写入文件内容长度
        byte[] fcontentLentArr = Util.int2Bytes(len);
        System.arraycopy(fcontentLentArr,0,bytes,fnameBytes.length+4,4);

        //写入文件内容
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        FileInputStream fis = new FileInputStream(f);
        byte[] buf = new byte[1024];
        int len0 = 0;
        while((len0 = fis.read(buf)) != -1){
           baos.write(buf,0,len0);
        }
        fis.close();
        //得到文件内容
        byte[] fileContentArr = baos.toByteArray();

        System.arraycopy(fileContentArr,0,bytes,4+fnameBytes.length+4,fileContentArr.length);
        return bytes;
    }

}
