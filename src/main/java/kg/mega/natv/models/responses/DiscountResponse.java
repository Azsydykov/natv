package kg.mega.natv.models.responses;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountResponse  {

    Long id;
    int discountDays;
    int discount;

}