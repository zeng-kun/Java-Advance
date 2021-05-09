package leetcode.editor.cn;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HelloAWeekOne extends ClassLoader {
        public static void main(String[] args) {
            try {
                Class<?> helloClass = new HelloAWeekOne().findClass("Hello");
                Method helloMethod = helloClass.getMethod("hello");
                helloMethod.invoke(helloClass.newInstance());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {

            Path path = Paths.get("C:\\Users\\zengk\\Desktop\\Inbox\\Java进阶训练营\\第一周\\作业相关\\Hello.xlass");
            byte[] helloBase64 = new byte[0];
            try {
                helloBase64 = Files.readAllBytes(path);
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < helloBase64.length; i++) {
                helloBase64[i] = (byte) (255 - helloBase64[i]);
            }

            return defineClass(name, helloBase64, 0, helloBase64.length);
        }
    }
