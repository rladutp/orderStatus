package TaxiCall;

import TaxiCall.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderStatusViewHandler {


    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1 (@Payload Ordered ordered) {
        try {
            if (ordered.isMe()) {
                // view 객체 생성
                OrderStatus orderStatus = new OrderStatus();
                // view 객체에 이벤트의 Value 를 set 함
                orderStatus.setId(ordered.getId());
                orderStatus.setOrderId(ordered.getOrderId());
                // view 레파지 토리에 save
                orderStatusRepository.save(orderStatus);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_CREATE_2 (@Payload OrderCanceled orderCanceled) {
        try {
            if (orderCanceled.isMe()) {
                // view 객체 생성
                OrderStatus orderStatus = new OrderStatus();
                // view 객체에 이벤트의 Value 를 set 함
                orderStatus.setId(orderCanceled.getId());
                orderStatus.setOrderId(orderCanceled.getOrderId());
                // view 레파지 토리에 save
                orderStatusRepository.save(orderStatus);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderAgreed_then_UPDATE_1(@Payload OrderAgreed orderAgreed) {
        try {
            if (orderAgreed.isMe()) {
                // view 객체 조회
                List<OrderStatus> orderStatusList = orderStatusRepository.findByOrderId(orderAgreed.getOrderId());
                for(OrderStatus orderStatus : orderStatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderStatus.setStatus(orderAgreed.getStatus());
                    orderStatus.setOrderId(orderAgreed.getOrderId());
                    // view 레파지 토리에 save
                    orderStatusRepository.save(orderStatus);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderDeclined_then_UPDATE_2(@Payload OrderDeclined orderDeclined) {
        try {
            if (orderDeclined.isMe()) {
                // view 객체 조회
                List<OrderStatus> orderStatusList = orderStatusRepository.findByOrderId(orderDeclined.getOrderId());
                for(OrderStatus orderStatus : orderStatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderStatus.setStatus(orderDeclined.getStatus());
                    orderStatus.setOrderId(orderDeclined.getOrderId());
                    // view 레파지 토리에 save
                    orderStatusRepository.save(orderStatus);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_3(@Payload OrderCanceled orderCanceled) {
        try {
            if (orderCanceled.isMe()) {
                // view 객체 조회
                List<OrderStatus> orderStatusList = orderStatusRepository.findByOrderId(orderCanceled.getOrderId());
                for(OrderStatus orderStatus : orderStatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderStatus.setOrderId(orderCanceled.getOrderId());
                    orderStatus.setCustomerName(orderCanceled.getCustomerName());
                    // view 레파지 토리에 save
                    orderStatusRepository.save(orderStatus);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}