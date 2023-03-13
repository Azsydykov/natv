package kg.mega.natv.services;

import kg.mega.natv.models.dto.PriceDto;
import kg.mega.natv.models.entities.Channel;
import kg.mega.natv.models.entities.Price;
import kg.mega.natv.models.request.PriceRequest;
import kg.mega.natv.models.responses.PriceResponse;

public interface PriceService extends BaseService<PriceDto>{
    void create(double pricePerLetter, Channel channel);

    Price toPrice(double price, Channel channel);

    PriceResponse getPriceResponse(PriceRequest priceRequest);
}
