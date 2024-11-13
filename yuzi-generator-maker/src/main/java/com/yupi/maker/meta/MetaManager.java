package com.yupi.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

public class MetaManager {
    private static volatile Meta meta;

    private MetaManager(){

    }

    public static  Meta getMetaObject(){

        if(meta==null){
            synchronized (MetaManager.class){
                if(meta == null){
                    meta = initMeta();
                }
            }
        }

        return meta;
    }

    public static Meta initMeta(){
        String metajson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(metajson,Meta.class);
        return  newMeta;
    }
}
