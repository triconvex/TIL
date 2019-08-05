package ch6.visitor;

public class Main {

    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory bin = new Directory("bin");
        Directory lib = new Directory("lib");

        File file1 = new File("file1");
        File file2 = new File("file2");
        File file3 = new File("file3");
        File file4 = new File("file4");

        root.add(file1);
        bin.add(file2);
        bin.add(file3);
        lib.add(file4);
        root.add(lib);
        root.add(bin);

        root.accept(new ViewVisitor());
    }

}
