package proxy;

import java.util.ArrayList;
import java.util.List;

public class Shop implements IShop {

    List list;

    public Shop(){
        list = new ArrayList();
    }

    public void add(String book){
        list.add(book);
    }

    public void sell(){
        if(list.size()!=0){
            System.out.print(list.remove(0));
        }
    }

}
