package query;

import com.sun.istack.internal.NotNull;

public class IntColumn extends Column<Integer> {

    public IntColumn(@NotNull String name){
        super(name);
    }

    @NotNull
    public BinaryCondition greaterThan(@NotNull Value<Integer> value) {
        return new BinaryCondition(Operator.GREAT, this, value);
    }

    @NotNull
    public BinaryCondition lessThan(@NotNull Value<Integer> value) {
        return new BinaryCondition(Operator.LESS, this, value);
    }

    @NotNull
    public BinaryCondition between(@NotNull Value<Integer> left, @NotNull Value<Integer> right) {
        return greaterThan(left).and(lessThan(right));
    }

    @NotNull
    public BinaryCondition equalTo(@NotNull Value<Integer> value) {
        return new BinaryCondition(Operator.EQ, this, value);
    }

    @NotNull
    public BinaryCondition notEqual(@NotNull Value<Integer> value) {
        return new BinaryCondition(Operator.NE, this, value);
    }
}
