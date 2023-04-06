package kg.mega.natv.services.impl;

import kg.mega.natv.dao.PriceRep;
import kg.mega.natv.mappers.PriceMapper;
import kg.mega.natv.models.dto.DiscountDto;
import kg.mega.natv.models.dto.PriceDto;
import kg.mega.natv.models.dto.TextAdDto;
import kg.mega.natv.models.entities.Channel;
import kg.mega.natv.models.entities.Price;
import kg.mega.natv.models.request.PriceRequest;
import kg.mega.natv.models.responses.PriceResponse;
import kg.mega.natv.services.DiscountService;
import kg.mega.natv.services.PriceService;
import kg.mega.natv.services.TextAdService;
import kg.mega.natv.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService{
    PriceMapper priceMapper = PriceMapper.INSTANCE;

    private final PriceRep priceRep;
    private final DiscountService discountService;
    private final TextAdService textAdService;

//так как есть аннотация @RequiredArgsConstructor, конструктор не нужен
//    public PriceServiceImpl(PriceRep priceRep, DiscountService discountService, TextAdService textAdService) {
//        this.priceRep = priceRep;
//        this.discountService = discountService;
//        this.textAdService = textAdService;
//    }

    @Override
    public void create(double pricePerLetter, Channel channel) {
        Price price = toPrice(pricePerLetter, channel);
        priceRep.save(price);
    }

    @Override
    public Price toPrice(double price, Channel channel) {

        Price newPrice = new Price();
        newPrice.setPricePerSymbol(price);
        newPrice.setChannel(channel);
        newPrice.setStartDate(new Date());
        newPrice.setEndDate(DateUtil.getInstance().getEndDate());
        return newPrice;
    }

    @Override
    public PriceDto save(PriceDto priceDto) {
        return priceMapper.toDto(priceRep.save(priceMapper.toEntity(priceDto)));
    }

    @Override
    public PriceDto findById(Long id) {
        return priceMapper.toDto(priceRep.findById(id).orElseThrow(() -> new RuntimeException("Price not found!")));
    }

    @Override
    public PriceDto delete(Long id) {
        PriceDto priceDto = new PriceDto();
        priceDto.setActive(false);
        return save(priceDto);
    }

    @Override
    public List<PriceDto> findAll() {
        return priceMapper.toDtos(priceRep.findAll());
    }

    @Override
    public PriceResponse getPriceResponse(PriceRequest priceRequest) {
        PriceDto priceDto = findById(priceRequest.getChannelId());
        List<DiscountDto> discountList = discountService.findDiscountByChannelId(priceRequest.getChannelId());
        List<DiscountDto> sortedDiscountList = discountList.stream()
                .sorted(Comparator.comparing(DiscountDto::getDiscountDays)
                        .reversed())
                .collect(Collectors.toList());


        double pricePerSymbol = priceDto.getPricePerSymbol();
        String text = priceRequest.getText();
        int textCount = getSymbolCount(text);
        int days = priceRequest.getDaysCount();
        double totalPrice = 0;
        double priceWithDiscount = 0;

        if (discountList.isEmpty() || priceRequest.getDaysCount() < sortedDiscountList.get(sortedDiscountList.size() - 1).getDiscountDays()) {
            totalPrice = textCount * pricePerSymbol * days;
        } else {
            for (DiscountDto item : sortedDiscountList) {

                if (priceRequest.getDaysCount() >= item.getDiscountDays()) {

                    totalPrice = (textCount * pricePerSymbol * days);
                    double diffPrice = (textCount * pricePerSymbol * days * item.getDiscount()) / 100;
                    priceWithDiscount = totalPrice - diffPrice;
                    break;
                }
            }
        }
        TextAdDto textAdDto = new TextAdDto();
        textAdDto.setSymbolCount(textCount);
        textAdDto.setText(text);
        textAdService.save(textAdDto);

        PriceResponse priceResponse = new PriceResponse();
        priceResponse.setText(priceRequest.getText());
        priceResponse.setChannelId(priceRequest.getChannelId());
        priceResponse.setDaysCount(priceRequest.getDaysCount());
        priceResponse.setPrice(totalPrice);
        priceResponse.setPriceWithDiscount(priceWithDiscount);

        return priceResponse;
    }

    int getSymbolCount(String text) {
        int countWithoutSpaсes = 0;
        for (char element : text.toCharArray()) {
            if (element == ' ') {
                continue;
            } else countWithoutSpaсes++;
        }
        return countWithoutSpaсes;
    }

}
