package com.ilivinskyi.homeworks;

import com.ilivinskyi.homeworks.reflection.User;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        // 1) Получение информации о классе:
        var user = new User("Cat", 10);
        var userClass = user.getClass();
        System.out.println(userClass.getName());
        System.out.println(userClass.getPackage());
        System.out.println(userClass.getModifiers());

        var fields = userClass.getDeclaredFields();
        for (var field : fields) {
            System.out.println(field.getName());
            System.out.println(field.getType().getName());
        }
        try {
            System.out.println(userClass.getDeclaredMethod("getAgeAfterYears", int.class));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 2) Создание объекта с использованием рефлексии:
        Object object;

        try {
            var newUser = getClassForName("com.ilivinskyi.homeworks.reflection.User");
            try {
                var constructor = getConstructor(newUser);
                object = constructor.newInstance("Code", 5);
                System.out.println(object.getClass().getName());
            } catch (
                InstantiationException | IllegalAccessException | InvocationTargetException e
            ) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // 3) Вызов метода по имени:
        invokeUserMethodByName(user, "sayHello", "Rokko");

        // 4) Анализ аннотаций:
        printClassMethodAnnotations(user);

        // 5) Динамическая модификация класса:
        changeUserAge(user, 50);
    }

    public static Class<?> getClassForName(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }

    public static Constructor getConstructor(Class<?> clazz) {
        return clazz.getConstructors()[0];
    }

    public static void invokeUserMethodByName(
        Object object,
        String methodName,
        String strangerName
    ) throws RuntimeException {
        try {
            Method method = object.getClass().getDeclaredMethod(methodName, String.class);
            Class<?>[] parameterTypes = method.getParameterTypes();
            Object[] arguments = new Object[parameterTypes.length];
            arguments[0] = strangerName;
            method.invoke(object, arguments);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void printClassMethodAnnotations(User user) {
        Method[] methods = user.getClass().getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation.annotationType().getName());
            }
        }
    }

    public static void changeUserAge(User user, int value) {
        try {
            System.out.println("Age before change: ");
            user.printAge();
            Field field = User.class.getDeclaredField("age");
            field.setAccessible(true);
            field.setInt(user, 30);
            System.out.println("Age after change:");
            user.printAge();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
