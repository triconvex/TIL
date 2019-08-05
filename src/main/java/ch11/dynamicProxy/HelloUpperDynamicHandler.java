package ch11.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloUpperDynamicHandler implements InvocationHandler {
    private Hello hello;

    public HelloUpperDynamicHandler(Hello hello) {
        this.hello = hello;
    }

    //여기서 조건에 맞는 횡단관심사에 로직 추가
    //JDK 프록시

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("sayHello")) {
            String message = (String) method.invoke(hello, args);
            return "proxied " + message;
        }

        return "non proxied";
    }
}
