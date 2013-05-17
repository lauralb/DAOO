package tp1;

import tp1.visitor.QueryVisitor;
import tp1.visitor.Visitable;

/**
 * Created with IntelliJ IDEA.
 * User: laura
 * Date: 03/05/13
 * Time: 09:42
 * To change this template use File | Settings | File Templates.
 */
public class UnitCondition extends Condition{

    public UnitCondition(Operator operator, Statement<?> unary) {
        super(operator, unary);
    }



}
