package query;


import query.query.IntColumn;
import query.query.SqlQuery;
import query.query.Table;
import query.statements.StrColumn;
import query.visitor.ConsoleVisitor;
import query.visitor.JsonVisitor;

import static query.statements.Constant.cons;
import static query.query.SqlQueryBuilder.sqlQuery;

public class MainTp1 {
    public static void main(String[] args) throws Exception {
        final Table t = table("student");
        final StrColumn lastName = t.str("lastName");
        final StrColumn fistName = t.str("lastName");
        final IntColumn age = t.number("age");

        final SqlQuery query = sqlQuery()
                .select(age, fistName)
                .from(t)
                .where(lastName.startsWith(cons("Lopez"))
                        .and(age.between(cons(18), cons(21)))
                        .and(age.lessThan(cons(18)).not()))
                .orderBy(age)
                .groupBy(lastName)
                .limit(5)
                .build();

        System.out.println("Console visitor: ");
        ConsoleVisitor consoleVisitor = new ConsoleVisitor();
        query.accept(consoleVisitor);

        System.out.println("\nJson visitor: ");
        JsonVisitor jsonVisitor = new JsonVisitor();
        query.accept(jsonVisitor);
        System.out.println(jsonVisitor.getJsonObject());
    }


    private static Table table(String table) { return new Table(table); }


}
