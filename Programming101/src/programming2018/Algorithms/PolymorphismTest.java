package programming2018.Algorithms;

public class PolymorphismTest {

        static class A{
            void m(A a){
                System.out.println("a");
            }
        }
        static class B extends A{
            void m(B b){
                System.out.println("b");
            }
        }
        static class C extends B{

            void m(C c) {
                System.out.println("c");
            }
        }
        public static void main(String[] args) {
            A a = new C();
            B b = new C();
            b.m(a);

            System.out.println(Runtime.getRuntime().totalMemory());
        }


}
