package query;


import com.sun.istack.internal.NotNull;
import query.visitor.QueryVisitor;
import query.visitor.Visitable;


public class Limit implements Visitable {

    private final int n;

    public Limit(@NotNull int n) {
        this.n = n;
    }

    public void accept(QueryVisitor visitor) {
        visitor.visit(this);
    }

    public int getNumber() {
        return n;
    }
}
