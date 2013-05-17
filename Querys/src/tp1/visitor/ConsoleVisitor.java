package tp1.visitor;

import tp1.*;

import java.util.ArrayList;
import java.util.List;


public class ConsoleVisitor implements QueryVisitor {

    @Override
    public void visit(SqlQuery sqlQuery) {
        sqlQuery.accept(this);
    }

   @Override
    public void visit(Column column) {
       System.out.print(column.getName()+ " ");
    }

    @Override
    public void visit(Table table) {
        System.out.print(table.getName());
    }
    @Override
    public void visit(Value val) {
        System.out.print(val.getValue() + " ");
    }

    @Override
    public void visit(Condition condition) {
        condition.accept(this);
    }

    @Override
    public void visit(Operator operator) {
        System.out.print(operator.getName() + " ");
    }

    @Override
    public void visit(GroupBy groupBy) {
        StringBuilder groupByString = new StringBuilder();
        groupByString.append("GROUP BY ");
        groupByString.append(printColumns(groupBy.getColumns()));
        System.out.println(groupByString.toString());
    }

    @Override
    public void visit(OrderBy orderBy){
        StringBuilder orderByString = new StringBuilder();
        orderByString.append("\nORDER BY ");
        orderByString.append(printColumns(orderBy.getColumns()));
        System.out.println(orderByString.toString());
    }

    @Override
    public void visit(From from) {
       System.out.println("FROM " + from.getTable().getName());
    }

    @Override
    public void visit(Limit limit) {
        System.out.println("LIMIT " + limit.getNumber());
    }

    @Override
    public void visit(Where where) {
        System.out.print("WHERE ");
    }

    @Override
    public void visit(Select select) {
        StringBuilder selectString = new StringBuilder();
        selectString.append("SELECT ");
        selectString.append(printColumns(select.getColumns()));
        System.out.println(selectString.toString());
    }


    private String createSVFromList(List<?> list, String first, String separator, String end) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(first);
        for (int i=0; i< list.size()-1; i++) {
            stringBuilder.append(list.get(i).toString());
            stringBuilder.append(separator);
        }
        if(!list.isEmpty()){
            stringBuilder.append(list.get(list.size()-1).toString());
        }
        stringBuilder.append(end);
        return  stringBuilder.toString();
    }

    private String printColumns(List<Column> columns){
        List<String> columnNames = new ArrayList<String>();
        for (Column column : columns) {
            columnNames.add(column.getName());
        }
        return createSVFromList(columnNames, "", ", ", "");
    }
}
