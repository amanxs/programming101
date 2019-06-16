package programming2018.coreJava;

public class InterfaceTest {
    interface Gift {
        void present();

        default void getPresent() {
            return;
        }
    }

    interface Guest {
        void present();

        default void getPresent() {
            return;
        }

        interface Presentable extends Gift, Guest {
            default void getPresent() {
                return;
            }
        }

        /**
         * If a type implements two interfaces, and each interface define a method that has identical signature,
         * then in effect there is only one method, and they are not distinguishable.
         * If, say, the two methods have conflicting return types, then it will be a compilation error.
         * This is the general rule of inheritance, method overriding, hiding, and declarations,
         * and applies also to possible conflicts not only between 2 inherited interface methods,
         * but also an interface and a super class method, or even just conflicts due to type erasure of generics.
         */
        class Test implements Gift, Guest {
            public void present() {

            }

            public void getPresent() {
                Guest.super.getPresent();
            }
        }


        /**
         * public class InterfaceTest {
         * interface Gift  { void present(); }
         * interface Guest { boolean present(); }
         * <p>
         * interface Presentable extends Gift, Guest { } // DOES NOT COMPILE!!!
         * // "types InterfaceTest.Guest and InterfaceTest.Gift are incompatible;
         * //  both define present(), but with unrelated return types"
         * }
         * This further reiterates that inheriting members from an interface must obey the general rule of member declarations.
         * Here we have Gift and Guest define present() with incompatible return types: one void the other boolean.
         * For the same reason that you can't an void present() and a boolean present() in one type,
         * this example results in a compilation error.
         */

        public static void main(String[] args) {
            Presentable johnny = new Presentable() {
                @Override
                public void present() {
                    System.out.println("Heeeereee's Johnny!!!");
                }
            };
            johnny.present();                     // "Heeeereee's Johnny!!!"

            ((Gift) johnny).present();            // "Heeeereee's Johnny!!!"
            ((Guest) johnny).present();           // "Heeeereee's Johnny!!!"

            Gift johnnyAsGift = (Gift) johnny;
            johnnyAsGift.present();               // "Heeeereee's Johnny!!!"

            Guest johnnyAsGuest = (Guest) johnny;
            johnnyAsGuest.present();              // "Heeeereee's Johnny!!!"
        }
    }
}