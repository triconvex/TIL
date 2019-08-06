package ch11.cglib;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.FixedValue;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class CglibTest {

    @Test
    public void introduction_to_cglib() {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Cat.class); //Cat을 수퍼클래스

        String result = new Cat().meow();
        System.out.println("result = " + result);

//        enhancer.setCallback(new FixedValue() {
//            @Override
//            public Object loadObject() throws Exception {
//                return "meeeoooww by cglib";
//            }
//        });

//        enhancer.setCallback((FixedValue) () -> "meeeoooww by cglib"); //age호출시 ClassCastException

        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                if(method.getName().equals("age")) {
                    return 5;
                }

                if(method.getName().equals("meow")) {
                    return "mewoowowow cglib";
                }

                return null;
            }
        });

        Cat cat = (Cat) enhancer.create();
        System.out.println("cat.meow() = " + cat.meow());
        System.out.println("cat.age() = " + cat.age());
    }

    public static class Cat {
        public String meow() {
            return "meeeeoooww";
        }

        public int age() {
            return 5;
        }
    }

}
