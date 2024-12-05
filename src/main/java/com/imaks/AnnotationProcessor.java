package com.imaks;

import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void processAnnotation(Class<?> clazz){
        try {
            for (Method method : clazz.getDeclaredMethods()){
                if (method.isAnnotationPresent(MethodInfo.class)){
                    MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                    System.out.println("Method: " + (methodInfo.name().equals("null")
                            ? method.getName()
                            : methodInfo.name()));
                    System.out.println("Return type: " + (methodInfo.returnType().equals("null")
                            ? method.getReturnType().getSimpleName()
                            : methodInfo.returnType()));
                    System.out.println("Description: " + methodInfo.description());
                }

                if (method.isAnnotationPresent(Author.class)){
                    Author author = method.getAnnotation(Author.class);
                    System.out.println("Author: " + author.firstName() + " " + author.lastName());
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
