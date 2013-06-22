package query.visitor;

import query.query.*;
import query.statements.Column;
import query.statements.Condition;
import query.statements.Value;


public class JsonVisitor implements QueryVisitor {


    @Override
    public void visit(SqlQuery sqlQuery) {
    }

    @Override
    public void visit(Column column) {

    }

    @Override
    public void visit(Table table) {

    }

    @Override
    public void visit(Value value) {
    }

    @Override
    public void visit(Condition condition) {
    }

    @Override
    public void visit(Operator operator) {

    }

    @Override
    public void visit(GroupBy groupBy) {

    }

    @Override
    public void visit(OrderBy orderBy) {
    }

    @Override
    public void visit(From from) {
    }

    @Override
    public void visit(Limit limit) {
    }

    @Override
    public void visit(Where where) {

    }

    @Override
    public void visit(Select select) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
