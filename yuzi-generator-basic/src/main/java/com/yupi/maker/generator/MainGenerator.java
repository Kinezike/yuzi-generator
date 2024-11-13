package com.yupi.maker.generator;

import com.yupi.maker.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 核心生成器
 */
public class MainGenerator {

    /**
     * 生成
     *
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException {

        String inputRootpath =  "E:\\yuzi-generator\\generated\\acm-template-pro-generator";
        String outputRootpath ="E:\\yuzi-generator";


        //{
        //        "inputPath": "src/com/yupi/acm/MainTemplate.java.ftl",
        //        "outputPath": "src/com/yupi/acm/MainTemplate.java",
        //        "type": "file",
        //        "generateType": "dynamic"
        //      },

        // 生成动态文件
        String inputpath = new File(inputRootpath,"src/com/yupi/acm/MainTemplate.java.ftl").getAbsolutePath();
        String outputpath = new File(outputRootpath,"src/com/yupi/acm/MainTemplate.java").getAbsolutePath();
        DynamicGenerator.doGenerate(inputRootpath,outputRootpath,model);


        //      {
        //        "inputPath": ".gitignore",
        //        "outputPath": ".gitignore",
        //        "type": "file",
        //        "generateType": "static"
        //      },
        //      {
        //        "inputPath": "README.md",
        //        "outputPath": "README.md",
        //        "type": "file",
        //        "generateType": "static"
        //      }

        //生成静态文件
        inputpath = new File(inputRootpath,".gitignore").getAbsolutePath();
        outputpath = new File(outputRootpath,"gitignore").getAbsolutePath();
        StaticGenerator.copyFilesByHutool(inputpath,outputpath);

        inputpath = new File(inputRootpath,"README.md").getAbsolutePath();
        outputpath = new File(outputRootpath,"README.md").getAbsolutePath();
        StaticGenerator.copyFilesByHutool(inputpath,outputpath);


    }

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("YHH");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");
        doGenerate(mainTemplateConfig);
    }
}

