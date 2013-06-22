package query;


import query.visitor.QueryVisitor;
import query.visitor.Visitable;

import java.util.List;


public class Table implements Visitable {

    private final String name;


    public Table(String name){
        this.name = name;
    }

    public StrColumn str(String columnName) {
        return new StrColumn(columnName);
    }

    public IntColumn number(String columnName) {
        return new IntColumn(columnName);
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(QueryVisitor visitor) {
        visitor.visit(this);
    }
}
