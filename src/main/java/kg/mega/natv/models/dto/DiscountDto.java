package kg.mega.natv.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import kg.mega.natv.models.entities.Channel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountDto {
    Long id;
  //  Date startDate;
  //  Date endDate;
    @JsonProperty("discount_days")
    int discountDays;
    int discount;
 //   Channel channel;
}