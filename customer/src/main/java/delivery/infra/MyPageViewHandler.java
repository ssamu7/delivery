package delivery.infra;

import delivery.domain.*;
import delivery.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MyPageViewHandler {

    @Autowired
    private MyPageRepository myPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1 (@Payload OrderPlaced orderPlaced) {
        try {

            if (!orderPlaced.validate()) return;

            // view 객체 생성
            MyPage myPage = new MyPage();
            // view 객체에 이벤트의 Value 를 set 함
            myPage.setId(orderPlaced.getId());
            myPage.setStatus("order placed");
            // view 레파지 토리에 save
            myPageRepository.save(myPage);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_UPDATE_1(@Payload Paid paid) {
        try {
            if (!paid.validate()) return;
                // view 객체 조회
            Optional<MyPage> myPageOptional = myPageRepository.findById(Long.valueOf(paid.getOrderId()));

            if( myPageOptional.isPresent()) {
                 MyPage myPage = myPageOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setStatus("paid");    
                // view 레파지 토리에 save
                 myPageRepository.save(myPage);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderAccepted_then_UPDATE_2(@Payload OrderAccepted orderAccepted) {
        try {
            if (!orderAccepted.validate()) return;
                // view 객체 조회
            Optional<MyPage> myPageOptional = myPageRepository.findById(Long.valueOf(orderAccepted.getOrderId()));

            if( myPageOptional.isPresent()) {
                 MyPage myPage = myPageOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setStatus("order accepted");    
                // view 레파지 토리에 save
                 myPageRepository.save(myPage);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void when_then_UPDATE_(@Payload  ) {
        try {
            if (!.validate()) return;
                // view 객체 조회
            Optional<MyPage> myPageOptional = myPageRepository.findById(Long.valueOf(.getOrderId()));

            if( myPageOptional.isPresent()) {
                 MyPage myPage = myPageOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setStatus("order rejected");    
                // view 레파지 토리에 save
                 myPageRepository.save(myPage);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookStarted_then_UPDATE_4(@Payload CookStarted cookStarted) {
        try {
            if (!cookStarted.validate()) return;
                // view 객체 조회
            Optional<MyPage> myPageOptional = myPageRepository.findById(Long.valueOf(cookStarted.getOrderId()));

            if( myPageOptional.isPresent()) {
                 MyPage myPage = myPageOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setStatus("cook started");    
                // view 레파지 토리에 save
                 myPageRepository.save(myPage);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookFinished_then_UPDATE_5(@Payload CookFinished cookFinished) {
        try {
            if (!cookFinished.validate()) return;
                // view 객체 조회
            Optional<MyPage> myPageOptional = myPageRepository.findById(Long.valueOf(cookFinished.getOrderId()));

            if( myPageOptional.isPresent()) {
                 MyPage myPage = myPageOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setStatus("cook finished");    
                // view 레파지 토리에 save
                 myPageRepository.save(myPage);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPicked_then_UPDATE_6(@Payload Picked picked) {
        try {
            if (!picked.validate()) return;
                // view 객체 조회
            Optional<MyPage> myPageOptional = myPageRepository.findById(Long.valueOf(picked.getOrderId()));

            if( myPageOptional.isPresent()) {
                 MyPage myPage = myPageOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setStatus("food picked");    
                // view 레파지 토리에 save
                 myPageRepository.save(myPage);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDelivered_then_UPDATE_7(@Payload Delivered delivered) {
        try {
            if (!delivered.validate()) return;
                // view 객체 조회
            Optional<MyPage> myPageOptional = myPageRepository.findById(Long.valueOf(delivered.getOrderId()));

            if( myPageOptional.isPresent()) {
                 MyPage myPage = myPageOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setStatus("delivery completed");    
                // view 레파지 토리에 save
                 myPageRepository.save(myPage);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void when_then_UPDATE_(@Payload  ) {
        try {
            if (!.validate()) return;
                // view 객체 조회
            Optional<MyPage> myPageOptional = myPageRepository.findById(Long.valueOf(.getOrderId()));

            if( myPageOptional.isPresent()) {
                 MyPage myPage = myPageOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setPoint(myPage.getPoint() + 500);
                // view 레파지 토리에 save
                 myPageRepository.save(myPage);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

