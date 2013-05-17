
package tp1;

import tp1.visitor.QueryVisitor;
import tp1.visitor.Visitable;

import javax.naming.LimitExceededException;
import java.util.List;


public class SqlQuery implements Visitable {
    private final Select select;
    private final From from;
    private final Where whereClause;
    private final OrderBy orderBy;
    private final GroupBy groupBy;
    private final Limit limit;

    SqlQuery(List<Column> selectColumns, Table fromTable, Condition condition,List<Column> orderByColumns, List<Column> groupByColumns, int limit) {
        select = new Select(selectColumns);
        from = new From(fromTable);
        whereClause = new Where(condition);
        groupBy = new GroupBy(groupByColumns);
        orderBy = new OrderBy(orderByColumns);
        this.limit = new Limit(limit);
    }

    @Override
    public void accept(QueryVisitor visitor) {
        select.accept(visitor);
        from.accept(visitor);
        whereClause.accept(visitor);
        orderBy.accept(visitor);
        groupBy.accept(visitor);
        limit.accept(visitor);

    }
}
