package com.chinasofti.press;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TestZip {
    public static void main(String[] args) throws Exception{

        FileOutputStream fos = new FileOutputStream("d:/arch/xxx.xar");

        ZipOutputStream zos = new ZipOutputStream(fos);

        String[] ars = {"d:/arch/a.jpg","d:/arch/b.png"};

        for (String s:ars) {
            addFile(zos,s);
        }

        zos.close();
        fos.close();

    }

    public static void addFile(ZipOutputStream zos,String path) throws Exception{
        File f = new File(path);
        zos.putNextEntry(new ZipEntry(f.getName()));
        FileInputStream fis = new FileInputStream(f);
        byte[] bytes = new byte[fis.available()];
        fis.read(bytes);
        fis.close();

        zos.write(bytes);
        zos.closeEntry();

    }
}
