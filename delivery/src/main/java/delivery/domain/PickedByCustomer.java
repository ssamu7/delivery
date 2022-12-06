package delivery.domain;

import delivery.domain.*;
import delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class PickedByCustomer extends AbstractEvent {

    private Long id;
    private String status;
    private String orderId;

    public PickedByCustomer(Delivery aggregate){
        super(aggregate);
    }
    public PickedByCustomer(){
        super();
    }
}
