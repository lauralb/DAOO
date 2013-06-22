
package query;


import com.sun.istack.internal.NotNull;
import query.visitor.QueryVisitor;
import query.visitor.Visitable;

import java.util.List;


public class SqlQuery implements Visitable {
    private final Select select;
    private final From from;
    private final Where whereClause;
    private final OrderBy orderBy;
    private final GroupBy groupBy;
    private final Limit limit;

    SqlQuery(@NotNull List<Column> selectColumns, @NotNull Table fromTable, @NotNull Condition condition,
             @NotNull List<Column> orderByColumns, @NotNull List<Column> groupByColumns, @NotNull int limit) {
        select = new Select(selectColumns);
        from = new From(fromTable);
        whereClause = new Where(condition);
        groupBy = new GroupBy(groupByColumns);
        orderBy = new OrderBy(orderByColumns);
        this.limit = new Limit(limit);
    }

    @Override
    public void accept(@NotNull QueryVisitor visitor) {
        select.accept(visitor);
        from.accept(visitor);
        whereClause.accept(visitor);
        orderBy.accept(visitor);
        groupBy.accept(visitor);
        limit.accept(visitor);

    }
}
