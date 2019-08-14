package com.architect.jdkproxy;

import com.architect.Person;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class JdkMatchmakerTest {
    public static void main(String[] args) throws Exception {
        JdkMatchmaker jdkMatchmaker = new JdkMatchmaker(new Lisi());
        Person proxy = jdkMatchmaker.getProxy();
        proxy.findLove();
        //int sum = proxy.study(1, 2);
       // System.out.println(sum);


        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
        FileOutputStream os = new FileOutputStream("E:\\$Proxy0.class");
        os.write(bytes);
        os.close();

        //Person proxy = jdkMatchmaker.getProxy(Lisi.class);
        //System.out.println(proxy);
        //proxy.findLove();
    }
}
