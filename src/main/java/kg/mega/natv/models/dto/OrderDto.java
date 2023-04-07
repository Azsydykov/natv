package kg.mega.natv.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.mega.natv.models.enums.OrderStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDto {
    Long id;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    Date createdDate;
    String client_email;
    String fullName;
    String clientPhoneNumber;
    ChannelDto channel;
    double totalPrice;
    TextAdDto text;
    OrderStatus orderStatus;

}