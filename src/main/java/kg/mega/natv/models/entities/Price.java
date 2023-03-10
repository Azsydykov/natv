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
@Table(name = "tb_price")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    Channel channel;
    double pricePerSymbol;
    Date startDate;
    Date endDate;
    boolean active;

    @PrePersist
    protected void onCreate() {
        startDate = new Date();
        active = true;
    }
}
