package query;


import com.sun.istack.internal.NotNull;

public class UnitCondition extends Condition{

    public UnitCondition(@NotNull Operator operator, @NotNull Statement<?> unary) {
        super(operator, unary);
    }

}
