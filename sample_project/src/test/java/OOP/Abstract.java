package OOP;

public class Abstract {

    static abstract class Animal {

        abstract void sound();

    }

    static class Cat extends Animal {
        public void sound() {
            System.out.println("Cat makes a sound");
        }
    }


    public static void main(String[] args) {

        Animal animal = new Cat();
        animal.sound();
    }

}
