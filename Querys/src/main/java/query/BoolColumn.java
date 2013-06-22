package query;

import com.sun.istack.internal.NotNull;

public class BoolColumn extends Column<Boolean> {

    public BoolColumn(@NotNull String name){
        super(name);
    }

    public BinaryCondition and(@NotNull Statement<Boolean> other) {
        return new BinaryCondition(Operator.AND, this, other);
    }
    public BinaryCondition or(@NotNull Statement<Boolean> other) {
        return new BinaryCondition(Operator.OR, this, other);
    }

    @NotNull
    public UnitCondition not() {
        return new UnitCondition(Operator.NOT, this);
    }

}
