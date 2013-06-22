package query;


import query.visitor.QueryVisitor;
import query.visitor.Visitable;

public abstract class Statement<T> implements Visitable {
    @Override
    public abstract void accept(QueryVisitor visitor);
}
