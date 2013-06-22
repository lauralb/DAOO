package query;


import query.visitor.QueryVisitor;
import query.visitor.Visitable;

public class Where implements Visitable {

    private final Condition condition;

    public Where(Condition condition) {
        this.condition = condition;
    }

    @Override
    public void accept(QueryVisitor visitor) {
        visitor.visit(this);
        condition.accept(visitor);
    }
}
