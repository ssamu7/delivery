package delivery.domain;

import delivery.domain.PointEarned;
import delivery.CustomerApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="CustomerInfo_table")
@Data

public class CustomerInfo  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private Integer point;
    
    
    
    
    
    private String orderId;

    @PostPersist
    public void onPostPersist(){


        PointEarned pointEarned = new PointEarned(this);
        pointEarned.publishAfterCommit();

    }

    public static CustomerInfoRepository repository(){
        CustomerInfoRepository customerInfoRepository = CustomerApplication.applicationContext.getBean(CustomerInfoRepository.class);
        return customerInfoRepository;
    }




    public static void earnDeliveryPoints(Delivered delivered){

        /** Example 1:  new item 
        CustomerInfo customerInfo = new CustomerInfo();
        repository().save(customerInfo);

        PointEarned pointEarned = new PointEarned(customerInfo);
        pointEarned.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(delivered.get???()).ifPresent(customerInfo->{
            
            customerInfo // do something
            repository().save(customerInfo);

            PointEarned pointEarned = new PointEarned(customerInfo);
            pointEarned.publishAfterCommit();

         });
        */

        
    }


}
