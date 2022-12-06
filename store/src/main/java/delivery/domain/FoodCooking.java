package delivery.domain;

import delivery.domain.OrderAccepted;
import delivery.domain.OrderRejected;
import delivery.domain.CookStarted;
import delivery.domain.CookFinished;
import delivery.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="FoodCooking_table")
@Data

public class FoodCooking  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String foodId;
    
    
    
    
    
    private String orderId;
    
    
    
    @ElementCollection
    
    private List<String> options;
    
    
    
    
    
    private String storeId;
    
    
    
    
    
    private String customerId;

    @PostPersist
    public void onPostPersist(){


        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();



        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();



        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();



        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();

    }

    public static FoodCookingRepository repository(){
        FoodCookingRepository foodCookingRepository = StoreApplication.applicationContext.getBean(FoodCookingRepository.class);
        return foodCookingRepository;
    }



    public void accept(AcceptCommand acceptCommand){
        if(acceptCommand.getAccept()) {
            OrderAccepted.orderAccepted = new OrderAccepted(this);
            orderAccepted.publishAfterCommit();

            setStatus("order accepted");
        } else {
            orderRejected orderRejected = new OrderRejected(this);
            orderRejected.publishAfterCommit();

            setStatus("order rejected");
        }
    }
    public void start(){
    }

    public static void copyOrderInfo(OrderPlaced orderPlaced){

        /** Example 1:  new item*/ 
        FoodCooking foodCooking = new FoodCooking();
        foodCooking.setCustmerId(orderPlaced.getCustomerId());
        foodCooking.setFoodId(orderPlaced.getFoodId());
        foodCooking.setOrderId(String.valueOf(orderPlaced.getId()));
        foodCooking.setStatus("payment processing");
        repository().save(foodCooking);

        

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(foodCooking->{
            
            foodCooking // do something
            repository().save(foodCooking);


         });
        */

        
    }
    public static void updateStatus(Paid paid){

        /** Example 1:  new item 
        FoodCooking foodCooking = new FoodCooking();
        repository().save(foodCooking);

        */

        /** Example 2:  finding and process*/
        
        repository().findByOrderId(paid.getOrderId()).ifPresent(foodCooking->{
            
            foodCooking.setStatus("paid successfully"); // do something
            repository().save(foodCooking);


         });
        

        
    }


}
