package kg.mega.natv.models.responses;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import javax.validation.constraints.Size;


@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceResponse {

    @Size(min = 20, message = "Длина текста должно быть минимум 20 символов!")
    String text;
    int daysCount;
    Long channelId;
    double price;
    double priceWithDiscount;


}
