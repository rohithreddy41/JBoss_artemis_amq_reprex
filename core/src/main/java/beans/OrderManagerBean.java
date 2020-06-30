package beans;

import domain.Order;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RequestScoped
public class OrderManagerBean implements OrderMangaer {

   /* @Inject
    private EntityManager entityManager;*/

    @PersistenceContext(unitName="nsfsApp")
    private EntityManager entityManager;

    @Override
    public void updateOrder(Order order) {
       entityManager.merge(order);
       entityManager.flush();
    }
}
