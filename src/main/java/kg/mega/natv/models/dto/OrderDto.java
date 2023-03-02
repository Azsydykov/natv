package kg.mega.natv.models.dto;

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
    Date createdDate;
    String client_email;
    String fullName;
    String clientPhoneNumber;
    boolean orderStatus;
    ChannelDto channel;
    double totalPrice;
    TextAdDto text;

}