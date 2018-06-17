package services.validation;

import model.Card;
import model.Ranks;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoPairsValidator implements HandValidator {

    @Override
    public boolean isValid(List<Card> hand) {

        Map<Ranks, List<Card>> ranks = hand.stream().collect(Collectors.groupingBy(Card::getRank));

        return ranks.values().stream()
                .filter(list -> list.size() %2 == 0)
                .collect(Collectors.toList()).size() == 2;
    }
}
