package kg.mega.natv.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.mega.natv.models.enums.OrderStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    Date createdDate;
    String client_email;
    String fullName;
    String clientPhoneNumber;
    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;
    @ManyToOne
    Channel channel;
    double totalPrice;
    @ManyToOne
    Text text;

    @PrePersist
    protected void onCreate() {
        createdDate = new Date();

    }
}
