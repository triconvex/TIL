package ch6.visitor;

public interface Element {

    void accept(Visitor v);

}
