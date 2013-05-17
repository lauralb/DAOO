package tp1;

import com.sun.istack.internal.NotNull;
import tp1.visitor.QueryVisitor;
import tp1.visitor.Visitable;

public class Condition extends Statement<Boolean> implements Visitable {

    protected final Operator operator;
    protected final Statement<?> left;


    public Condition(Operator operator, Statement<?> unary) {
        this.operator = operator;
        left = unary;
    }

    public UnitCondition not() {
        return new UnitCondition(Operator.NOT, this);
    }

    public BinaryCondition and(@NotNull Statement<Boolean> other) {
        return new BinaryCondition(Operator.AND, this, other);
    }

    public BinaryCondition or(@NotNull Statement<Boolean> other) {
        return new BinaryCondition(Operator.OR, this, other);
    }

    public void accept(QueryVisitor visitor){
        operator.accept(visitor);
        left.accept(visitor);
    }


}
