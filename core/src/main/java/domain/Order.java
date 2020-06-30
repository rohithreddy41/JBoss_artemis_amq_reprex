package domain;

import annotations.TrackedProperties;
import annotations.TrackedProperty;
import entityListeners.UpdateEventListener;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ORDER", schema = "NSFS")
@EntityListeners({
        UpdateEventListener.class
})
@TrackedProperties(
        properties = {
                @TrackedProperty(oldPropertyName = "previousIsReadyForSO", propertyName = "isReadyForSO")}
)
public class Order {


    @Id
    @SequenceGenerator(
            allocationSize = 1,
            sequenceName = "CONEXUS_SEQ",
            schema = "NSFS",
            name = "CONEXUS_SEQ_NAME"
    )
    @GeneratedValue(generator = "CONEXUS_SEQ_NAME")
    @Column(name = "ORDER_ID", unique = true, nullable = false, scale = 0)
    private Long orderId;

    @Column(name = "IS_READY_FOR_SO", nullable = false)
    @Type(type = "yes_no")
   // @NotNull
    private boolean isReadyForSO = false;
    @Transient
    private boolean previousIsReadyForSO;

    public Order() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public boolean isReadyForSO() {
        return isReadyForSO;
    }

    public boolean isPreviousIsReadyForSO() {
        return previousIsReadyForSO;
    }

    public void setReadyForSO(boolean readyForSO) {
        previousIsReadyForSO = this.isReadyForSO;
        isReadyForSO = readyForSO;
    }
}
