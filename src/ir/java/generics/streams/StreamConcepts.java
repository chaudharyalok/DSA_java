package ir.java.generics.streams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamConcepts {

    // findFirst if using sequencial streams & findAny in case of parallel streams
    // not every operation can be parallleized as findFirst uses sequencial approach
    static String directory = "/abc/dfg/ghgh";
    public static void main(String args[]) {
        System.out.println("welcome to streams!");
        IntStream.iterate(0, n->n+1).limit(10).map(x->x*2).forEach(System.out::println);

    }

    private void method() throws IOException {
        List<Integer> nums1 = Arrays.asList(1, 2, 3);
        List<Integer> nums2 = Arrays.asList(4, 5);

        List<List<Integer>> pairs = nums1.stream().flatMap(i -> nums2.stream()
                .map(j -> Arrays.asList(i, j))).collect(Collectors.toList());

        nums1.stream().map(x -> x.toString()).forEach(x -> nums2.stream().forEach(y-> System.out.print("("+x+","+y+"),")));


        Files.createDirectory(Paths.get(directory));



    }

    private void save(Person person){

        try(FileOutputStream fos = new FileOutputStream(new File(directory + person.getId() + ".txt"))){
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


