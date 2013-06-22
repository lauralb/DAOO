package query;

import com.sun.istack.internal.NotNull;
import query.visitor.QueryVisitor;
import query.visitor.Visitable;

public class From implements Visitable {

    private final Table fromTable;

    public From(@NotNull Table fromTable) {
        this.fromTable = fromTable;
    }

    @Override
    public void accept(QueryVisitor visitor) {
        visitor.visit(this);
    }

    public Table getTable() {
        return fromTable;
    }
}
