package kg.mega.natv.models.responses;

import kg.mega.natv.models.entities.Channel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Comparator;
import java.util.Date;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetAllChannelResponses implements Comparable<GetAllChannelResponses> {

    Long id;
    String channelName;
    Date createdDate;
    boolean active;
    String logoPath;


    @Override
    public int compareTo(GetAllChannelResponses o) {
        return this.channelName.compareTo(o.channelName);
    }
}