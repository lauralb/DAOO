
package query.query;


import com.sun.istack.internal.NotNull;
import query.statements.Column;
import query.statements.Condition;
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

    SqlQuery(@NotNull Select select, @NotNull From from, @NotNull Where whereClause, @NotNull OrderBy orderBy,
             @NotNull GroupBy groupBy, @NotNull Limit limit) {
        this.select = select;
        this.from = from;
        this.whereClause = whereClause;
        this.groupBy = groupBy;
        this.orderBy = orderBy;
        this.limit = limit;
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
