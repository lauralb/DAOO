package tp1;

public class IntColumn extends Column<Integer> {

    public IntColumn(String name){
        super(name);
    }

    public BinaryCondition greaterThan(Value<Integer> value) {
        return new BinaryCondition(Operator.GREAT, this, value);
    }
    public BinaryCondition lessThan(Value<Integer> value) {
        return new BinaryCondition(Operator.LESS, this, value);
    }
    public BinaryCondition between(Value<Integer> left, Value<Integer> right) {
        return greaterThan(left).and(lessThan(right));
    }

    public BinaryCondition equalTo(Value<Integer> value) {
        return new BinaryCondition(Operator.EQ, this, value);
    }

    public BinaryCondition notEqual(Value<Integer> value) {
        return new BinaryCondition(Operator.NE, this, value);
    }
}
