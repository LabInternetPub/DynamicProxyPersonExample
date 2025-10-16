package cat.tecnocampus;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class PersonInvocationHandler implements InvocationHandler {
    private final Person realSubject;

    public PersonInvocationHandler(Person realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {

        try {
            printBefore(method, args);

            // Invoke the actual method on the original person object
            Object result = method.invoke(realSubject, args);

            printAfter(method);

            return result;
        }
        catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Invocation failed for method: " + method.getName(), e);
        }
    }

    private void printBefore(Method method, Object[] args) {
        if (method.getName().startsWith("get")) {
            System.out.println("Person's proxy going to call: " + method.getName());
        } else if (method.getName().startsWith("set")) {
            System.out.println("Person's proxy going to call: " + method.getName() + " with args: " + Arrays.toString(args));
        }
    }

    private void printAfter(Method method) {
        if (method.getName().startsWith("get")) {
            System.out.println("Person's proxy called: " + method.getName());
        } else if (method.getName().startsWith("set")) {
            // Extract property name from setter method
            String propertyName = method.getName().substring(3);
            if (!propertyName.isEmpty()) {
                propertyName = Character.toLowerCase(propertyName.charAt(0)) + propertyName.substring(1);
            }
            Object actualValue;
            try {
                java.lang.reflect.Field field = realSubject.getClass().getDeclaredField(propertyName);
                field.setAccessible(true);
                actualValue = field.get(realSubject);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                actualValue = "(field not found)";
            }
            System.out.println("Set called. The property \"" + propertyName + "\" now has value: " + actualValue);
            System.out.println();
        }
    }

}