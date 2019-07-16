package ch6.visitor;

import java.util.ArrayList;

public class Directory extends Entry {

    ArrayList<Entry> directory = new ArrayList();

    public Directory(String name) {
        super(name);
    }

    @Override
    public void add(Entry entry) {
        directory.add(entry);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

}
