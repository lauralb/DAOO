package query;

import query.visitor.QueryVisitor;


public class BinaryCondition extends Condition{

    private final Statement<?> right;

    public BinaryCondition(Operator operator, Statement<?> left, Statement<?> right) {
        super(operator, left);
        this.right = right;
    }

    public void accept(QueryVisitor visitor){
        left.accept(visitor);
        operator.accept(visitor);
        right.accept(visitor);
    }

}
