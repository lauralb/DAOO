package query.statements;

import com.sun.istack.internal.NotNull;
import query.query.Operator;


public class StrColumn extends Column<String>{

    public StrColumn(@NotNull String name){
        super(name);
    }

    @NotNull
    public BinaryCondition equals(@NotNull Value<String> value) {
        return new BinaryCondition(Operator.EQ, this, value);
    }

    @NotNull
    public BinaryCondition startsWith(@NotNull Value<String> value) {
        return new BinaryCondition(Operator.STARTS, this, value);
    }

    @NotNull
    public Condition contains(@NotNull Value<String> value) {
        return new BinaryCondition(Operator.CONTAINS, this, value);
    }

}
