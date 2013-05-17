package tp1;

import com.sun.istack.internal.NotNull;
import tp1.visitor.QueryVisitor;
import tp1.visitor.Visitable;

/**
 * Created with IntelliJ IDEA.
 * User: laura
 * Date: 03/05/13
 * Time: 09:41
 * To change this template use File | Settings | File Templates.
 */
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
