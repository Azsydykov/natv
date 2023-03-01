package kg.mega.natv.services;

import kg.mega.natv.models.entities.Channel;
import kg.mega.natv.models.entities.Price;

public interface PriceService {
    void save(double pricePerLetter, Channel channel);

    Price toPrice(double price, Channel channel);
}
