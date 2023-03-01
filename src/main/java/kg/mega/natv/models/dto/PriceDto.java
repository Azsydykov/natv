package kg.mega.natv.models.dto;

import kg.mega.natv.models.entities.Channel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceDto {
    Long id;
    Channel channel;
    double pricePerSymbol;
    double bannerPrice;
    Date startDate;
    Date endDate;
}