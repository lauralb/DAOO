package query;


import com.sun.istack.internal.NotNull;
import query.visitor.QueryVisitor;
import query.visitor.Visitable;

public class Where implements Visitable {

    private final Condition condition;

    public Where(@NotNull Condition condition) {
        this.condition = condition;
    }

    @Override
    public void accept(@NotNull QueryVisitor visitor) {
        visitor.visit(this);
        condition.accept(visitor);
    }
}
