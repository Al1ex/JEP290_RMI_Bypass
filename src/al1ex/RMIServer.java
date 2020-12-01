package al1ex;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) throws RemoteException {
        try {
            // 定义服务对象
            HelloService helloService = new HelloServiceImpl();
            // 获取注册器，指定查找端口
            Registry reg = LocateRegistry.createRegistry(9999);
            // 注册对象
            reg.bind("HelloService", helloService);
            System.out.println("HelloServiceImpl 已绑定到 Registry ......");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
