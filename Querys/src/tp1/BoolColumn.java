package tp1;

import com.sun.istack.internal.NotNull;

public class BoolColumn extends Column<Boolean> {

    public BoolColumn(String name){
        super(name);
    }

    public BinaryCondition and(@NotNull Statement<Boolean> other) {
        return new BinaryCondition(Operator.AND, this, other);
    }
    public BinaryCondition or(@NotNull Statement<Boolean> other) {
        return new BinaryCondition(Operator.OR, this, other);
    }

    public UnitCondition not() {
        return new UnitCondition(Operator.NOT, this);
    }

}
