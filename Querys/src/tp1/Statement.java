package tp1;


import tp1.visitor.QueryVisitor;
import tp1.visitor.Visitable;

public abstract class Statement<T> implements Visitable {



    @Override
    public abstract void accept(QueryVisitor visitor);
}
