package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args){
        Shop shop = new Shop();
        IShop iShop = (IShop) Proxy.newProxyInstance(IShop.class.getClassLoader(), new Class[]{IShop.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("do "+method.getName());
                return method.invoke(shop, args);
            }
        });
        iShop.add("111");
        iShop.sell();
    }

}
