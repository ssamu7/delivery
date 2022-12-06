package delivery.domain;

import delivery.domain.*;
import delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class PickedByRider extends AbstractEvent {

    private Long id;
    private String status;
    private String orderId;
    private String address;

    public PickedByRider(Delivery aggregate){
        super(aggregate);
    }
    public PickedByRider(){
        super();
    }
}
