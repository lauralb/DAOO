package query.query;

import com.sun.istack.internal.NotNull;
import java.util.List;

import query.statements.Column;
import query.visitor.*;

public class GroupBy implements Visitable{

    private final List<Column> groupByColumns;

    public GroupBy(@NotNull List<Column> groupByColumns) {
        this.groupByColumns = groupByColumns;
    }

    @Override
    public void accept(@NotNull QueryVisitor visitor) {
        visitor.visit(this);
    }

    @NotNull
    public List<Column> getColumns() {
        return groupByColumns;
    }
}
