package com.yupi.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.lang.reflect.Array;
import java.util.concurrent.Callable;

public class Login implements Callable<Integer> {
    @Option(names = {"-u", "--user"}, description = "User name",arity = "0..1")
    String user;

    @Option(names = {"-p", "--password"}, description = "Passphrase",arity = "0..1", interactive = true)
    String password;

    @Option(names = {"-cp", "--checkpassword"}, description = "Passphrase",arity = "0..1", interactive = true)
    String checkpassword;

    public Integer call() throws Exception {
        System.out.println("password = " + password);
        return 0;
    }

    public static void main(String[] args) {

        String[] filledArray = autoFillArray(args);

        new CommandLine(new Login()).execute(args);
    }

    public static String[] autoFillArray(String[] originalArray) {
        try {
            // 获取数组的类对象和组件类型
            Class<?> arrayClass = originalArray.getClass();
            Class<?> componentType = arrayClass.getComponentType();

            // 创建一个新的数组，用于存储补充后的结果
            String[] filledArray = (String[]) Array.newInstance(componentType, originalArray.length + 2);

            // 遍历原数组，将原数组元素复制到新数组
            for (int i = 0; i < originalArray.length; i++) {
                filledArray[i] = originalArray[i];
            }

            // 补充指定的字符串到新数组
            filledArray[originalArray.length] = "-p";
            filledArray[originalArray.length + 1] = "-cp";

            return filledArray;
        } catch (Exception e) {
            e.printStackTrace();
            return originalArray;
        }
    }
}