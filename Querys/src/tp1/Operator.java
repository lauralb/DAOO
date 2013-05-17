package tp1;

import tp1.visitor.QueryVisitor;
import tp1.visitor.Visitable;

/**
 * Created with IntelliJ IDEA.
 * User: keevstessens
 * Date: 26/04/13
 * Time: 15:25
 * To change this template use File | Settings | File Templates.
 */
public enum Operator implements Visitable{
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
