package query.statements;


import com.sun.istack.internal.NotNull;
import query.query.Operator;

public class UnitCondition extends Condition{

    public UnitCondition(@NotNull Operator operator, @NotNull Statement<?> unary) {
        super(operator, unary);
    }

}
