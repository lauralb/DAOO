package query;

import com.sun.istack.internal.NotNull;
import query.visitor.*;

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

    @NotNull
    public List<Column> getColumns() {
        return orderByColumns;
    }


}
