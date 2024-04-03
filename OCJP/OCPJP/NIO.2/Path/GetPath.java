package build;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetPath {
    public static void main(String[] args) {
        GetPath main = new GetPath();
        main.getPathBySystem();
        main.getPathByPath();

        System.out.println("----------------- LINE -----------------");

        main.testSplit();

        System.out.println("----------------- LINE -----------------");

        main.testNormalize();

        System.out.println("----------------- LINE -----------------");

        main.testSubPath();
    }

    // get path by FilSystem class
    private void getPathBySystem() {
        FileSystem fileSystem = FileSystems.getDefault();
        Path path = fileSystem.getPath("/Users/ateto/Desktop/Project/Java-training/OCJP/OCPJP/NIO.2/Path/demo.txt");
        System.out.println(path);
    }

    // get path by java.nio.file.Paths
    private void getPathByPath() {
        Path path0 = Paths.get("/Users/ateto/Desktop/Project/Java-training/OCJP/OCPJP/NIO.2/Path/demo.txt");
        Path path1 = Paths.get("Users", "ateto", "Desktop", "Project", "Java-training", "OCJP", "OCPJP", "NIO.2", "demo.txt");
        Path path2 = Paths.get("./demo.txt");
        System.out.println(path0 + "\n" + path1 + "\n" + path2);
    }

    private void testSplit() {
        Path path = Paths.get("/Users/ateto/Desktop/Project/Java-training/OCJP/OCPJP/NIO.2/Path/demo.txt");
        System.out.format("getFileName: %s%n", path.getFileName());
        System.out.format("getParent: %s%n", path.getParent());
        System.out.format("getNameCount: %s%n", path.getNameCount());
        System.out.format("getRoot: %s%n", path.getRoot());
        System.out.format("isAbsolute: %b%n", path.isAbsolute());
        System.out.format("toAbsolutePath: %s%n", path.toAbsolutePath());
        System.out.format("toURI: %s%n", path.toUri());
    }

    private void testNormalize() {
        Path path = Paths.get("/Users/ateto/../ateto/Desktop/Project/Java-training/OCJP/OCPJP/NIO.2/Path/././demo.txt");
        path = path.normalize();
        System.out.println(path);
    }

    private void testSubPath() {
        Path path = Paths.get("/Users/ateto/../ateto/Desktop/Project/Java-training/OCJP/OCPJP/NIO.2");
        path = path.normalize();
        path = path.subpath(1, 5);
        System.out.println(path);
    }
}