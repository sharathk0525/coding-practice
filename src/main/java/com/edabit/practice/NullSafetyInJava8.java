package com.edabit.practice;

import java.util.Optional;
import java.util.function.Supplier;

public class NullSafetyInJava8 {
    public static void main(String[] args) {
        /*Optional.of(new Outer())
                .map(Outer::getNested)
                .map(Nested::getInner)
                .map(Inner::getFoo)
                .ifPresent(System.out::println);*/

        Outer obj = new Outer();
        resolve(() -> obj.getNested().getInner().getFoo()).ifPresent(System.out::println);
    }

    public static <T> Optional<T> resolve(Supplier<T> resolver) {
        try {
            T result = resolver.get();
            return Optional.ofNullable(result);
        }
        catch (NullPointerException e) {
            return Optional.empty();
        }
    }

}

class Outer {
    Nested nested;
    Nested getNested() {
        return nested = new Nested();
    }
}
class Nested {
    Inner inner;
    Inner getInner() {
        return inner=new Inner();
    }
}
class Inner {
    String foo="sharath";
    String getFoo() {
        return foo;
    }
}