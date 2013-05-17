package tp1.visitor;

/**
 * Created with IntelliJ IDEA.
 * User: laura
 * Date: 26/04/13
 * Time: 08:33
 * To change this template use File | Settings | File Templates.
 */
public interface Visitable {

    public void accept(QueryVisitor visitor);

}
