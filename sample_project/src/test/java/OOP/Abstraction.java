package OOP;

abstract class Animal {
    // Abstract method (does not have a body)
    public abstract void animalSound();
    // Regular method
    public void sleep() {
        System.out.println("Zzz");
    }
}

// Subclass (inherit from OOP.Animal)
class Pig extends Animal {
    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The pig says: wee wee");
    }
}

class Cat extends Animal {
    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The cat says: meu meu");
    }
}

class MyMainClass {
    public static void main(String[] args) {
        Animal animal = new Pig(); // Create a OOP.Pig object
        animal.animalSound();
        animal.sleep();

        Animal animal2 = new Cat();
        animal2.animalSound();
        animal2.sleep();
    }
}