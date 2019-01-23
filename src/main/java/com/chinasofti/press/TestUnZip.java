package com.chinasofti.press;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class TestUnZip {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("d:/arch/xxx.xar");
        ZipInputStream zis = new ZipInputStream(fis);

        ZipEntry entry = null;
        byte[] buf = new byte[1024];
        int len = 0;
        while ((entry = zis.getNextEntry()) != null){
            String name = entry.getName();
            FileOutputStream fos = new FileOutputStream("d:/arch/unzip/"+name);
            while ((len=zis.read(buf)) != -1){
                fos.write(buf,0,len);
            }
            fos.close();
        }
        zis.close();
        fis.close();

    }
}
