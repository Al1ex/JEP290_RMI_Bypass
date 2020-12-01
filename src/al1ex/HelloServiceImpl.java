package al1ex;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {
    public HelloServiceImpl() throws RemoteException{}

    @Override
    public String sayHello(Object obj) throws RemoteException{
        System.out.println("sayHello被调用，obj值为: " + obj);
        return "我是RMIServer ...... ";
    }
    @Override
    public void log(String msg) throws RemoteException {
        System.out.println("msg: " + msg);
    }
}