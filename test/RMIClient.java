package al1ex;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) throws Exception {
        //根据ip和端口获取Registry
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9999);
        //使用Registry获取远程对象的引用
        HelloService services = (HelloService) registry.lookup("HelloService");
        // 使用远程对象的引用调用对应的方法
        String res = services.sayHello("al1ex");
        System.out.println(res);
    }
}
