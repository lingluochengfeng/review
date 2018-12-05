/**
 * @author ASUS
 * @since 2018-10-04 13:01
 */
public class Test {
    public static void main(String[] args) {
        L1 l1 = new L1();
        l1.doA();
    }
}

class L1  extends Level{
    boolean v2 = false;

    @Override
    void doA() {
        v2 = true;
        doA();
        System.out.println("这里做的是A方法");
    }

    @Override
    boolean doB() {
        if (v2)
            return false;
        return true;
    }
}

abstract class Level{
    abstract void doA();
    abstract boolean doB();
}
