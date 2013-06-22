package query;

import com.sun.istack.internal.NotNull;
import query.visitor.QueryVisitor;
import query.visitor.Visitable;

public class Condition extends Statement<Boolean> implements Visitable {

    protected final Operator operator;
    protected final Statement<?> left;


    public Condition(@NotNull Operator operator,@NotNull Statement<?> unary) {
        this.operator = operator;
        left = unary;
    }

    @NotNull
    public UnitCondition not() {
        return new UnitCondition(Operator.NOT, this);
    }

    @NotNull
    public BinaryCondition and(@NotNull Statement<Boolean> other) {
        return new BinaryCondition(Operator.AND, this, other);
    }

    @NotNull
    public BinaryCondition or(@NotNull Statement<Boolean> other) {
        return new BinaryCondition(Operator.OR, this, other);
    }

    public void accept(@NotNull QueryVisitor visitor){
        operator.accept(visitor);
        left.accept(visitor);
    }

}
