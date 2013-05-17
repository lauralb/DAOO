package tp1.visitor;

import tp1.*;



public interface QueryVisitor {

    public void visit(SqlQuery sqlQuery);

    public void visit(Column column);

    public void visit(Table table);

    public void visit(Value value);

    public void visit(Condition condition);

    public void visit(Operator operator);

    public void visit(GroupBy groupBy);

    public void visit(OrderBy orderBy);

    public void visit(From from);

    public void visit(Limit limit);

    public void visit(Where where);

    public void visit(Select select);



}
