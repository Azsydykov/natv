package kg.mega.natv.models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_discount")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date startDate;
    Date endDate;
    int discountDays;
    int discount;
    boolean active;
    @ManyToOne
    Channel channel;

    @PrePersist
    protected void onCreate() {
        active=true;
    }
}
