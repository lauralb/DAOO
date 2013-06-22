package query.query;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import query.statements.Column;
import query.statements.Condition;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class SqlQueryBuilder {
    private Select selectColumns;
    private From fromTable;
    private Where whereClause;
    private OrderBy orderByColumns;
    private GroupBy groupByColumns;
    private Limit limit;


    private SqlQueryBuilder() {
        selectColumns = new Select(Collections.<Column>emptyList());
        orderByColumns = new OrderBy(Collections.<Column>emptyList());
        groupByColumns = new GroupBy(Collections.<Column>emptyList());
    }

    @NotNull
    public static SqlQueryBuilder sqlQuery() {
        return new SqlQueryBuilder();
    }

    @NotNull
    public SqlQueryBuilder select(Column... columns) {
        selectColumns = new Select(asList(columns));
        return this;
    }

    @NotNull
    public SqlQueryBuilder from(@Nullable Table table) {
        fromTable = new From(table);
        return this;
    }

    @NotNull
    public SqlQueryBuilder where(@NotNull final Condition condition) {
        whereClause = new Where(condition);
        return this;
    }

    @NotNull
    public SqlQueryBuilder orderBy(@NotNull Column... columns) {
        orderByColumns = new OrderBy(asList(columns));
        return this;
    }

    @NotNull
    public SqlQueryBuilder groupBy(@NotNull Column... columns) {
        groupByColumns = new GroupBy(asList(columns));
        return this;
    }

    @NotNull
    public SqlQueryBuilder limit(@NotNull int limit) {
        if (limit < 0)
            throw new NumberFormatException();
        else {
            this.limit = new Limit(limit);
            return this;
        }
    }

    @NotNull
    public SqlQuery build() throws Exception {
        return  new SqlQuery(selectColumns, fromTable, whereClause, orderByColumns, groupByColumns, limit );

    }

}
