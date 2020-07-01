package beans;

import domain.Order;



public interface OrderManager {
    void updateOrder(Long orderId);

    int getMessageReceivedCount();
}
