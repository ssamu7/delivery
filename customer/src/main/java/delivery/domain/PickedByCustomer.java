package delivery.domain;

import delivery.domain.*;
import delivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class PickedByCustomer extends AbstractEvent {

    private Long id;
    private String status;
    private String orderId;
}


