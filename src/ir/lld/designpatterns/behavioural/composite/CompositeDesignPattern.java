package ir.lld.designpatterns.behavioural.composite;

import ir.lld.designpatterns.behavioural.composite.impl.Directory;
import ir.lld.designpatterns.behavioural.composite.impl.File;

public class CompositeDesignPattern {

    public static void main(String arr[]){
        Directory movieDirectory = new Directory("Movie");

        FileSystem border = new File("Border");
        movieDirectory.add(border);

        Directory comedyMovieDirectory = new Directory("ComedyMovie");
        File hulchul = new File("Hulchul");
        comedyMovieDirectory.add(hulchul);
        movieDirectory.add(comedyMovieDirectory);

        movieDirectory.ls();

    }
}
