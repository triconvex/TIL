package ch6.visitor;

public class ViewVisitor extends Visitor {

    private String path = "";

    @Override
    public void visit(File file) {
        System.out.println(path + "/" + file.name);
    }

    @Override
    public void visit(Directory dic) {
        path = path + "/" + dic.name;
        System.out.println(path);

        for (int i = 0; i < dic.directory.size(); i++) {
            dic.directory.get(i).accept(this);
        }
    }
}
