package com.yupi.cli.command;

import com.yupi.model.MainTemplateConfig;
import picocli.CommandLine;

import java.lang.reflect.Field;
@CommandLine.Command(name = "config",mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{

    @Override
    public void run() {
        Class<?> myClass = MainTemplateConfig.class;
        Field[] fields = myClass.getDeclaredFields();

        for (Field field : fields) {
            System.out.println("字符类型："+field.getType());
            System.out.println("字符名称："+field.getName());
        }

    }
}
