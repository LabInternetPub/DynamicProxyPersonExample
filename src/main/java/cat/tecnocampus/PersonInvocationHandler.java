package cat.tecnocampus;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class PersonInvocationHandler implements InvocationHandler {
    private final Person person;

    public PersonInvocationHandler(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {

        try {
            if (method.getName().startsWith("get")) {
                System.out.println("Person's proxy going to call: " + method.getName());
            } else if (method.getName().startsWith("set")) {
                System.out.println("Person's proxy going to call: " + method.getName() + " with args: " + Arrays.toString(args));
            }
            return method.invoke(person, args);
        }
        catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Invocation failed for method: " + method.getName(), e);
        }
    }
}