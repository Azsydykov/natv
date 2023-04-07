package kg.mega.natv.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.mega.natv.models.dto.DiscountDto;
import kg.mega.natv.models.enums.ChannelStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_channel")
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String channelName;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    Date createdDate;
    @Enumerated(EnumType.STRING)
    ChannelStatus channelStatus;
    boolean active;
    String logoPath;



    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
        active=true;
    }


}
