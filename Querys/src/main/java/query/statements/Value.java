package query.statements;

import com.sun.istack.internal.NotNull;
import query.visitor.QueryVisitor;

public class Value<T> extends Statement<T> {
    private T value;

    private Value(@NotNull T val) {
        this.value = val;
    }

    public Value() {

    }

    @NotNull
    public static Value<String> val(@NotNull String str) {
        return new Value<String>(str);
    }

    @NotNull
    public static Value<Integer> val(@NotNull Integer integer) {
        return new Value<Integer>(integer);
    }

    @Override
    public void accept(@NotNull QueryVisitor visitor) {
        visitor.visit(this);
    }

    @NotNull
    public T getValue(){
        return value;
    }
}
