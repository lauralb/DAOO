package query;

import com.sun.istack.internal.NotNull;
import query.visitor.QueryVisitor;
import query.visitor.Visitable;

public class Value<T> extends Statement<T> implements Visitable {
    private T value;

    private Value(T val) {
        this.value = val;
    }

    public Value() {

    }

    public static Value<String> val(@NotNull String str) {
        return new Value<String>(str);
    }

    public static Value<Integer> val(@NotNull Integer integer) {
        return new Value<Integer>(integer);
    }

    @Override
    public void accept(QueryVisitor visitor) {
        visitor.visit(this);
    }

    public T getValue(){
        return value;
    }
}
