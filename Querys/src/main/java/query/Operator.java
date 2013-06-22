package query;

import query.visitor.QueryVisitor;
import query.visitor.Visitable;

public enum Operator implements Visitable {
    AND("AND"),
    OR("OR"),
    LESS("LESS"),
    GREAT("GREAT"),
    EQ("EQUAL"),
    NE("NOT EQUAL"),
    STARTS("STARTS WITH"),
    CONTAINS("CONTAINS"),
    NULL("IS NULL"),
    NOT_NULL("IS NOT NULL"),
    NOT("NOT");

    private final String name;
    private Operator(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void accept(QueryVisitor visitor) {
        visitor.visit(this);
    }
}
