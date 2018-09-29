import java.util.ArrayList;
import java.util.List;

/**
 * 泛型
 */
public class Generic {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        //PECS Producer Extends, Consumer Super
        // 泛型 类定义 声明 实例化

        List<? extends Go> listE = null;
        List<Car> listCar = new ArrayList<>(); //Car类型的数组
        listCar.add(new Car());
        listCar.add(new YellowCar());
        listE = listCar;
//        listE.add(new Ship()) //存在的冲突，实例化为Car类型的List
//        listE.add(new Car())
        Go goE = listE.get(0);
        System.out.println(goE.toString());


        // 使用通配符？super Obj 的方式，可以接受Obj父类的实例对象，可做后续的add操作，单无法执行（返回object）get。
        List<? super Car> listS = null; //注意擦除造成的影响，内部都会擦除到下一边界Car
        List<Go> listGo = new ArrayList<>(); //Go类型的数组
        Go goS = new Car();
        listGo.add(new Car());
        listGo.add(new Ship()); // 继承于Go，但不能转型为Car
        listGo.add(goS);
        listS = listGo;
        listS.add(new YellowCar());
//        Car car = listS.get(0);
//        Ship ship = listS.get(2); // 和实例化冲突
        Object obj = listS.get(0); //返回object
        System.out.println(listS.toString());

    }


}

abstract class Go{
    public abstract void run();
}

class Car extends Go{

    @Override
    public void run() {

    }
}

class YellowCar extends Car{

}

class Ship extends Go{

    @Override
    public void run() {

    }
}