import java.lang.reflect.Method;

public class Exercise39_ReflectionDemo {

    public void greet(String name) {
        System.out.println("Hello, " + name + "! This is reflection magic!");
    }

    public static void main(String[] args) {
        try {
            // Load the class dynamically by name
            Class<?> clazz = Class.forName("Exercise39_ReflectionDemo");

            // Create an instance using no-arg constructor
            Object instance = clazz.getDeclaredConstructor().newInstance();

            // Get all declared methods
            Method[] methods = clazz.getDeclaredMethods();

            System.out.println("Methods in class " + clazz.getName() + ":");
            for (Method method : methods) {
                System.out.println("- " + method.getName());

                // Print parameter types
                Class<?>[] params = method.getParameterTypes();
                System.out.print("  Parameters: ");
                if (params.length == 0) {
                    System.out.println("None");
                } else {
                    for (Class<?> p : params) {
                        System.out.print(p.getSimpleName() + " ");
                    }
                    System.out.println();
                }
            }

            // Find the greet method with String param and invoke it
            Method greetMethod = clazz.getDeclaredMethod("greet", String.class);
            greetMethod.invoke(instance, "Reflection Baby!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
