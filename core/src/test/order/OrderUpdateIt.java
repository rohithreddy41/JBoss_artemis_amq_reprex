package order;

import beans.OrderManagerBean;
import beans.OrderMangaer;
import org.junit.Test;

public class OrderUpdateIt extends AbstractIntegrationFixture{

    final public static String APPNAME = "reprex-1.0-SNAPSHOT";
    final public static String MODULENAME = "core";
    final public static String BEAN_PREFIX = "ejb:" + APPNAME + "/" + MODULENAME;
    final public static String ORDER_MANANGER_BEAN_NAME = BEAN_PREFIX + "/OrderManagerBean!" + OrderManagerBean.class.getName();


    @Test
    public void addMessages(){
        OrderMangaer orderMangaer = getOrderManager();
        orderMangaer.updateOrder(null);
    }

    OrderManagerBean  getOrderManager() {
        return (OrderManagerBean)getBean(ORDER_MANANGER_BEAN_NAME);
    }

}
