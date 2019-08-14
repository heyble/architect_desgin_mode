package com.architect.customproxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyProxy {

    private static final String LN = "\r\n";

    public static Object newProxyInstance(MyClassloader classloader,Class<?>[] interfaces,MyInvocationHandle invokeHandle){
        try {
            // 1.根据接口生成java文件
            String src = gentor(interfaces);

            // 2.将文件写入磁盘中
            String path = MyProxy.class.getResource("").getPath();
            System.out.println(path);
            File file = new File(path + "$Proxy0.java");
            FileWriter writer = new FileWriter(file);
            writer.write(src);
            writer.close();

            // 3.编译成class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            // 4.加载到jvm中
            Class<?> clazz = classloader.findClass("$Proxy0");
            Constructor<?> constructor = clazz.getConstructor(MyInvocationHandle.class);

            // 5. 返回新生成的代理对象
           return constructor.newInstance(invokeHandle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String gentor(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.architect.customproxy;"+LN);
        sb.append("import java.lang.reflect.Method;"+LN);
        //sb.append("import com.architect.Person;"+LN);
        sb.append("public class $Proxy0 implements "+interfaces[0].getName()+"{" + LN);

        sb.append("MyInvocationHandle h;" + LN);

        sb.append("public $Proxy0(MyInvocationHandle h){ this.h = h;}");

        Method[] methods = interfaces[0].getMethods();
        for (Method method : methods) {
            sb.append("public void " + method.getName() + "(){" + LN);
            sb.append("try{");
            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + method.getName() + "\",new Class[]{});"+LN);
            sb.append("this.h.invoke(this,m,null);" + LN);
            sb.append("}catch(Throwable e){ e.printStackTrace();}" + LN);
            sb.append("}" + LN);
        }

        sb.append("}" + LN);
        return sb.toString();
    }
}
