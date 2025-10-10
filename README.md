# Proxy Pattern in This Project

## How the Proxy Works

1. **Proxy Creation**  
   The `PersonProxyFactory` class provides a static method `getPersonProxy(Person person)` that creates a proxy instance for any `Person` object. It uses `Proxy.newProxyInstance` to generate a proxy that implements the same interfaces as the original object.

2. **Invocation Handler**  
   The proxy delegates all method calls to the `PersonInvocationHandler`. This handler receives every method invocation, allowing custom logic before or after the actual method call.

3. **Logging and Delegation**  
   In `PersonInvocationHandler`, before calling the real method on the `Person` object, it logs the method name (and arguments for setters). Then, it invokes the method on the original `Person` instance using reflection.

4. **Exception Handling**  
   If the method invocation fails, the handler throws a runtime exception, ensuring errors are not silently ignored.

## Benefits

- **Separation of Concerns:** Logging and other cross-cutting concerns are handled outside the `Person` class.
- **Flexibility:** You can add more behaviors (e.g., validation, access control) in the handler without changing the `Person` implementation.

## Example Usage

```java
Person realPerson = new PersonImplementation();
Person proxyPerson = PersonProxyFactory.getPersonProxy(realPerson);

proxyPerson.setName("Alice"); // Logs the call, then sets the name
String name = proxyPerson.getName(); // Logs the call, then gets the name
```

The proxy acts as a wrapper, transparently adding extra behavior to method calls on the `Person` object.

