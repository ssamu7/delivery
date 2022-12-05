package delivery.domain;

import delivery.domain.Picked;
import delivery.domain.Delivered;
import delivery.DeliveryApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Delivery_table")
@Data

public class Delivery  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String address;

    @PostPersist
    public void onPostPersist(){


        Picked picked = new Picked(this);
        picked.publishAfterCommit();



        Delivered delivered = new Delivered(this);
        delivered.publishAfterCommit();

    }

    public static DeliveryRepository repository(){
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(DeliveryRepository.class);
        return deliveryRepository;
    }

    public void accept(){
        //
    }



    public static void copyOrderInfo(OrderPlaced orderPlaced){

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

        
    }
    public static void updateStatus(CookStarted cookStarted){

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookStarted.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

        
    }


}
