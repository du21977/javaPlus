package cn.enjoyedu.service.impl;


import cn.enjoyedu.service.TechInterface;

/**
 * 享学课堂
 * 类说明：服务实现类
 */
public class TechImpl implements TechInterface {
    @Override
    public String XJ(String name) {

        return "您好，13号技师为你服务:"+name;
    }
}
