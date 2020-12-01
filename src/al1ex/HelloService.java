package al1ex;

import java.rmi.RemoteException;

public interface HelloService extends java.rmi.Remote {
    //远程调用方法必须抛出RemoteException异常
    String sayHello(Object obj) throws RemoteException;
    void log(String msg) throws RemoteException;
}
