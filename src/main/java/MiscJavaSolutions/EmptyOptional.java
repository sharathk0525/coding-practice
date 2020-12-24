package MiscJavaSolutions;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class EmptyOptional {

    public static void main(String[] args) {
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o.get());

        List<String> stringList = Arrays.asList("1", "2", "3", "4");
        Stream<String> stringStream = stringList.stream().map(s -> s.toUpperCase());
    }
}
