package com.architect.customproxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassloader extends ClassLoader{

    private File filePath;

    public MyClassloader() {
        String path = MyClassloader.class.getResource("").getPath();
        filePath = new File(path);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String className = MyClassloader.class.getPackage().getName() + "." + name;
        File file = new File(filePath, name.replaceAll("\\.", "/")+".class");
        if (file.exists()) {
            FileInputStream in = null;
            ByteArrayOutputStream bos = null;
            try {
                in = new FileInputStream(file);
                bos = new ByteArrayOutputStream();
                byte[] buff = new byte[1024];
                int len;
                while ((len = in.read(buff)) != -1) {
                    bos.write(buff,0,len);
                }
                return defineClass(className,bos.toByteArray(),0,bos.size());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                    if (bos != null) {
                        bos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return null;
    }
}
