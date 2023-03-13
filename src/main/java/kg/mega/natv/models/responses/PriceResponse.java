package kg.mega.natv.models.responses;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceResponse {
    String text;
    int daysCount;
    Long channelId;
    double price;
    double priceWithDiscount;


}
