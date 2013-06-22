package query;


import com.sun.istack.internal.NotNull;
import query.visitor.QueryVisitor;
import query.visitor.Visitable;

public abstract class Statement<T> implements Visitable {
    @Override
    public abstract void accept(@NotNull QueryVisitor visitor);
}
