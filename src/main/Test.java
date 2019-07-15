public class Test {
    //https://stackoverflow.com/questions/13554507/order-of-static-variable-initialization-java

    static class StaticClassTest {
        static {
            System.out.println(StaticClassTest.k);
            k = 2;
            System.out.println(StaticClassTest.k);
        }

        static int k = 1;

        public static void main(String[] args) {
            System.out.println(k);
        }
    }

    static class StaticClassTest2 {
        static int k = 1;

        static {
            System.out.println(StaticClassTest2.k);
            k = 2;
            System.out.println(StaticClassTest2.k);
        }

        public static void main(String[] args) {
            System.out.println(k);
        }
    }

}

class TestInitOrder {
    static {
        System.out.println(TestInitOrder.stat1);
        System.out.println(TestInitOrder.stat2);
        System.out.println(TestInitOrder.str);
        System.out.println(TestInitOrder.str2);

        str = "something";

        System.out.println(TestInitOrder.str);
        System.out.println(TestInitOrder.str2);
        System.out.println(TestInitOrder.lazy);
        System.out.println(TestInitOrder.second); //이건 왜 null...?
    }

    private static final int stat1 = 10;
    private static int stat2 = 19;

    static String str = "crap";
    static final String str2 = "sdfff";

    static final Second second = new Second();
    static final int lazy;

    static {
        lazy = 20;
    }

    static {
        System.out.println(TestInitOrder.str2);
        System.out.println(TestInitOrder.stat2);
        System.out.println(TestInitOrder.str);
        System.out.println(TestInitOrder.lazy);
        System.out.println(TestInitOrder.second);
    }

    public static void main(String args[]) {
    }

}

class Second {
    public Second() {
        System.out.println(TestInitOrder.second);
    }
}