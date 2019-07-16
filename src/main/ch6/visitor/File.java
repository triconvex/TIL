package ch6.visitor;

public class File extends Entry {

    public File(String name) {
        super(name);
    }

    @Override
    public void add(Entry entry) {}

    public void accept(Visitor v) {
        v.visit(this);
    }

}
