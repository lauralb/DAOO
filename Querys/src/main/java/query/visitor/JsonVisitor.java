package query.visitor;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import query.query.*;
import query.statements.Column;
import query.statements.Condition;
import query.statements.Value;

import java.util.ArrayList;
import java.util.List;


public class JsonVisitor implements QueryVisitor {

    private final JSONObject jsonObject;

    public JsonVisitor(){
       jsonObject = new JSONObject();
    }

    @Override
    public void visit(SqlQuery sqlQuery) {
        sqlQuery.accept(this);
    }

    @Override
    public void visit(Column column) {
        String where = (String) jsonObject.get("where");
        jsonObject.put("where", where +" " + column.getName());
    }

    @Override
    public void visit(Table table) {
        jsonObject.put("table", table.getName());
    }

    @Override
    public void visit(Value value) {
        String where = (String) jsonObject.get("where");
        jsonObject.put("where", where + " " + value.getValue());
    }

    @Override
    public void visit(Condition condition) {
        condition.accept(this);
    }

    @Override
    public void visit(Operator operator) {
        String where = (String) jsonObject.get("where");
        jsonObject.put("where", where + " " + operator.getName());
    }

    @Override
    public void visit(GroupBy groupBy) {
        jsonObject.put("group by", visitColumns(groupBy.getColumns()));
    }

    @Override
    public void visit(OrderBy orderBy) {
        jsonObject.put("order by", visitColumns(orderBy.getColumns()));
    }

    @Override
    public void visit(From from) {
        jsonObject.put("from", from.getTable().getName());
    }

    @Override
    public void visit(Limit limit) {
        jsonObject.put("limit", limit.getNumber());
    }

    @Override
    public void visit(Where where) {
        jsonObject.put("where", "");
    }

    @Override
    public void visit(Select select) {
        jsonObject.put("select", visitColumns(select.getColumns()));
    }

    private JSONArray visitColumns(List<Column> columns){
        JSONArray array = new JSONArray();
        for (Column column : columns) {
            array.add(column.getName());
        }
        return array;
    }

    public JSONObject getJsonObject(){
        return jsonObject;
    }
}
