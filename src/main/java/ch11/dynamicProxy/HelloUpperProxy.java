package ch11.dynamicProxy;

public class HelloUpperProxy implements Hello {
    Hello hello;

    public HelloUpperProxy(Hello hello) {
        this.hello = hello;
    }

    //sayHello를 대문자로 바꿔 내보내기위한 프록시
    //하지만 Hello의 나머지 두 메서드까지 구현해야한다
    //이를 극복하기 위함이 다이나믹프록시?

    @Override
    public String sayHello(String name) {
        return hello.sayHello(name).toUpperCase();
    }

    @Override
    public String sayHi(String name) {
        return hello.sayHi(name);
    }

    @Override
    public String sayThankyou(String name) {
        return hello.sayThankyou(name);
    }
}
