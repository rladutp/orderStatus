package TaxiCall;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="OrderStatus_table")
public class OrderStatus {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long orderId;
        private Long driverId;
        private String location;
        private String status;
        private String customerName;


        public Long getOrderId() {
            return orderId;
        }

        public void setOrderId(Long orderId) {
            this.orderId = orderId;
        }
        public Long getDriverId() {
            return driverId;
        }

        public void setDriverId(Long driverId) {
            this.driverId = driverId;
        }
        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

}
