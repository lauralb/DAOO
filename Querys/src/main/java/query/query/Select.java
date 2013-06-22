package query.query;


import com.sun.istack.internal.NotNull;
import query.statements.Column;
import query.visitor.QueryVisitor;
import query.visitor.Visitable;

import java.util.List;

public class Select implements Visitable {

    private final List<Column> columns;

    public Select(@NotNull List<Column> columns) {
        this.columns = columns;
    }

    @Override
    public void accept(@NotNull QueryVisitor visitor) {
        visitor.visit(this);
    }

    @NotNull
    public List<Column> getColumns() {
        return columns;
    }
}
