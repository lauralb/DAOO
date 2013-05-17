package tp1;

import com.sun.istack.internal.NotNull;
import tp1.visitor.QueryVisitor;
import tp1.visitor.Visitable;

import javax.management.MBeanFeatureInfo;

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
