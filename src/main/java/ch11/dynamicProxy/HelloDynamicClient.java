package ch11.dynamicProxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class HelloDynamicClient {

    public String proxied() {
        Hello proxiedHello = (Hello) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[] {Hello.class},
                new HelloUpperDynamicHandler(new HelloTarget())
        );

        return proxiedHello.sayHello("James");
    }

    public String nonProxied() {
        Hello proxiedHello = (Hello) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[] {Hello.class},
                new HelloUpperDynamicHandler(new HelloTarget())
        );

        return proxiedHello.sayHi("James");
    }

    @Test
    public void test() {
        System.out.println(proxied());
        System.out.println(nonProxied());
    }

}
