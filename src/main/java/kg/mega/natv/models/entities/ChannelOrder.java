package kg.mega.natv.models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_channel_order")
public class ChannelOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    Channel channel;
    @ManyToOne
    Order order;
    int daysCount;
}
