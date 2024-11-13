package com.yupi.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;

import java.io.File;
import java.util.List;

@CommandLine.Command(name = "list", mixinStandardHelpOptions = true)

public class ListCommand implements Runnable {

    @Override
    public void run() {
        String projectpath = System.getProperty("user.dir");

        String inputpath = new File(projectpath,"yuzi-generator-demo-projects/acm-template").getAbsolutePath();

        List<File> files = FileUtil.loopFiles(inputpath);

        for(File file:files){
            System.out.println(file);
        }

    }
}
