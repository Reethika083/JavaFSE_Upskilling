// Base class Animal
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Subclass Dog inherits from Animal
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}

public class Exercise18_InheritanceExample {
    public static void main(String[] args) {
        Animal genericAnimal = new Animal();
        Dog dog = new Dog();

        // Call methods
        genericAnimal.makeSound(); // Animal sound
        dog.makeSound(); // Bark
    }
}
