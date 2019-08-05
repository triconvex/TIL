package ch11.dynamicProxy;

public class HelloTarget implements Hello {

    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }

    @Override
    public String sayHi(String name) {
        return "hi " + name;
    }

    @Override
    public String sayThankyou(String name) {
        return "thankyou " + name;
    }
}
