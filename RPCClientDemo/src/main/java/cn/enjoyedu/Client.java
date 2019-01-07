package cn.enjoyedu;


import cn.enjoyedu.rpc.RpcClientFrame;
import cn.enjoyedu.service.TechInterface;

/**
 * 享学课堂
 *类说明：rpc的客户端，调用远端服务
 */
public class Client {
    public static void main(String[] args) throws Exception {
        //动态代理获取我们的对象
        TechInterface techInterface = RpcClientFrame.getRemoteProxyObj(TechInterface.class);
        //进远程调用我们的对象
        System.out.println(techInterface.XJ("king"));

    }
}
