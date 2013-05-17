package tp1;

import com.sun.istack.internal.NotNull;
import tp1.visitor.QueryVisitor;
import tp1.visitor.Visitable;

/**
 * Created with IntelliJ IDEA.
 * User: Martin
 * Date: 4/19/13
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 *
 */
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
