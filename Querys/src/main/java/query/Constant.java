package query;

import com.sun.istack.internal.NotNull;
import query.visitor.QueryVisitor;
import query.visitor.Visitable;

public class Constant<T> extends Value<T> implements Visitable {
    private T str;

    private Constant(T str) {
        this.str = str;
    }

    public static Constant<String> cons(@NotNull String str) {
        return new Constant<String>(str);
    }

    public static Constant<Integer> cons(@NotNull Integer integer) {
        return new Constant<Integer>(integer);
    }

    @Override
    public void accept(QueryVisitor visitor) {
        visitor.visit(this);
    }

    public T getValue(){
        return str;
    }

}
