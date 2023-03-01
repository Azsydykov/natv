package kg.mega.natv.models.dto;

import kg.mega.natv.models.entities.Channel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelDto {
    Long id;
    String channelName;
   // Date createdDate;
    boolean active;
    double pricePerLetter;
    String logoPath;
    List<DiscountDto> discounts;

}
