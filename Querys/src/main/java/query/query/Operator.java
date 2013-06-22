package query.query;

import com.sun.istack.internal.NotNull;
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

    private Operator(@NotNull String name){
        this.name = name;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void accept(@NotNull QueryVisitor visitor) {
        visitor.visit(this);
    }
}
