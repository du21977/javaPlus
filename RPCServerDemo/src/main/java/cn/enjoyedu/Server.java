package cn.enjoyedu;


import cn.enjoyedu.register.RegisterCenter;
import cn.enjoyedu.service.TechInterface;
import cn.enjoyedu.service.impl.TechImpl;

/**
 * 享学课堂
 *类说明：rpc的服务端，提供服务
 */
public class Server {
    public static void main(String[] args) throws  Exception{
        new Thread(new Runnable() {
            public void run() {
                try {
                    //起一个服务中心
                    RegisterCenter serviceServer = new RegisterCenter(8888);
                    //注册技师对象至注册中心
                    serviceServer.register(TechInterface.class, TechImpl.class);
                    //运行我们的服务
                    serviceServer.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
