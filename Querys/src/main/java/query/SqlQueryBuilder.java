package query;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class SqlQueryBuilder {
    private List<Column> selectColumns;
    private Table fromTable;
    private Condition whereClause;
    private List<Column> orderByColumns;
    private List<Column> groupByColumns;
    private int limit;


    private SqlQueryBuilder() {
        selectColumns = Collections.emptyList();
        orderByColumns = Collections.emptyList();
        groupByColumns = Collections.emptyList();
    }

    @NotNull
    public static SqlQueryBuilder sqlQuery() {
        return new SqlQueryBuilder();
    }

    @NotNull
    public SqlQueryBuilder select(Column... columns) {
        selectColumns = asList(columns);
        return this;
    }

    @NotNull
    public SqlQueryBuilder from(@Nullable Table table) {
        fromTable = table;
        return this;
    }

    @NotNull
    public SqlQueryBuilder where(@NotNull final Condition condition) {
        whereClause = condition;
        return this;
    }

    @NotNull
    public SqlQueryBuilder orderBy(@NotNull Column... columns) {
        orderByColumns = asList(columns);
        return this;
    }

    @NotNull
    public SqlQueryBuilder groupBy(@NotNull Column... columns) {
        groupByColumns = asList(columns);
        return this;
    }

    @NotNull
    public SqlQueryBuilder limit(@NotNull int limit) {
        if (limit < 0)
            throw new NumberFormatException();
        else {
            this.limit = limit;
            return this;
        }
    }

    @NotNull
    public SqlQuery build() throws Exception {
        return  new SqlQuery(selectColumns, fromTable, whereClause, orderByColumns, groupByColumns, limit );

    }



    /**
     * Creates a String of Separated Values from a List of T Objects by a String separator
     *
     * @param list
     * @param separator
     * @return String
     */
    private <T> String createSVFromList(Iterable<T> list, String opening, String separator, String closing) {
        final StringBuilder builder = new StringBuilder();
        boolean first = true;
        for (T t : list) {
            builder.append(t.toString());
            if (!first) {
                builder.append(separator);
            }
        }
        return builder.length() > 0 ?  builder.substring(0, builder.length() - separator.length()) + " " : "";
    }

    private <T> String createSVFromList(Iterable<T> list, String separator) {
        return createSVFromList(list, "", separator, "");
    }

}
