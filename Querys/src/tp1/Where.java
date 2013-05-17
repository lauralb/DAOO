package tp1;


import tp1.visitor.QueryVisitor;
import tp1.visitor.Visitable;

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
