package kg.mega.natv.models.responses;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetAllChannelResponses implements Comparable<GetAllChannelResponses> {

    Long id;
    String channelName;
    Date createdDate;
    boolean active;
    String logoPath;
    List<DiscountResponse> discounts;


    @Override
    public int compareTo(GetAllChannelResponses channelResponses) {
        return this.channelName.compareTo(channelResponses.channelName);
    }
}