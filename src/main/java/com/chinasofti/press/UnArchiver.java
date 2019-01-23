package com.chinasofti.press;

import com.chinasofti.bean.FileBean;
import com.chinasofti.utils.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UnArchiver {
    public static void main(String[] args) throws Exception{
        List<FileBean> files = new ArrayList<FileBean>();
        FileInputStream fis = new FileInputStream("d:/arch/x.xar");
        FileBean fileBean = null;
        while ((fileBean = readNextFile(fis)) != null){
            files.add(fileBean);
        }
        fis.close();
        for(FileBean fb : files){
            FileOutputStream fos = new FileOutputStream("d:/arch/unarch/"+fb.getFileName());
            fos.write(fb.getFileContent());
            fos.close();
        }
    }

    /**
     * 从流中读取下一个文件
     * @param fis
     * @return
     */
    public static  FileBean readNextFile(FileInputStream fis) throws Exception{
        byte[] bytes4 = new byte[4];
        //读取4个字节
        int res = fis.read(bytes4);
        if(res == -1){
            return null;
        }
        //获取文件名长度
        int fnameLen = Util.bytes2Int(bytes4);

        //文件名数组\
        byte[] fileNameBytes = new byte[fnameLen];
        fis.read(fileNameBytes);

        //得到文件名
        String fname = new String(fileNameBytes);

        //再读取4个字节，作为文件内容的长度
        fis.read(bytes4);
        int fileConLen = Util.bytes2Int(bytes4);

        //读取文件内容
        byte[] fileContBytes = new byte[fileConLen];
        fis.read(fileContBytes);
        return new FileBean(fname,fileContBytes);
    }
}
