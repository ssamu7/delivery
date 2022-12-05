package delivery.domain;

import delivery.domain.*;
import delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class PointEarned extends AbstractEvent {

    private Long id;
    private Integer point;
    private String customerId;
    private String orderId;

    public PointEarned(CustomerInfo aggregate){
        super(aggregate);
    }
    public PointEarned(){
        super();
    }
}
