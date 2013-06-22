package query;

import query.visitor.QueryVisitor;
import query.visitor.Visitable;


public class Column<T extends Comparable<T>> extends Value<T> implements Visitable {
    private final String columnName;

    public Column(String columnName){
        this.columnName = columnName;
    }

    public UnitCondition isNull() {
        return new UnitCondition(Operator.NULL, this);
    }

    public UnitCondition isNotNull() {
        return new UnitCondition(Operator.NOT_NULL, this);
    }

    public BinaryCondition greaterThan(Value<Integer> value) {
        return new BinaryCondition(Operator.GREAT, this, value);
    }

    public BinaryCondition greaterEqualThan(Value<Integer> value) {
        return new BinaryCondition(Operator.GREAT, this, value);
    }

    public BinaryCondition lessThan(Value<Integer> value) {
        return new BinaryCondition(Operator.LESS, this, value);
    }

    public BinaryCondition equalTo(Value<Integer> value) {
        return new BinaryCondition(Operator.EQ, this, value);
    }

    public BinaryCondition notEqual(Value<Integer> value) {
        return new BinaryCondition(Operator.NE, this, value);
    }

    public String getName(){
        return columnName;
    }

    public void accept(QueryVisitor visitor){
        visitor.visit(this);
    }
}
