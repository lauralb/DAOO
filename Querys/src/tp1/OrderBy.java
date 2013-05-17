package tp1;

import com.sun.istack.internal.NotNull;
import tp1.visitor.QueryVisitor;
import tp1.visitor.Visitable;

import java.util.List;


public class OrderBy implements Visitable {

    private final List<Column> orderByColumns;

    public OrderBy(@NotNull List<Column> orderByColumns){
        this.orderByColumns = orderByColumns;
    }

    @Override
    public void accept(QueryVisitor visitor) {
        visitor.visit(this);
    }

    public List<Column> getColumns() {
        return orderByColumns;
    }
}
