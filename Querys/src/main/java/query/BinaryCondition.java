package query;

import com.sun.istack.internal.NotNull;
import query.visitor.QueryVisitor;


public class BinaryCondition extends Condition{

    private final Statement<?> right;

    public BinaryCondition(@NotNull Operator operator, @NotNull Statement<?> left, @NotNull Statement<?> right) {
        super(operator, left);
        this.right = right;
    }

    public void accept(@NotNull QueryVisitor visitor){
        left.accept(visitor);
        operator.accept(visitor);
        right.accept(visitor);
    }

}
