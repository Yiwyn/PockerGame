package com.yiwyn.card;


/**
 * value 作为数值: 1 2 3 4 5 6 7 8 9 10 11 12 13
 * 对应关系: 2 3 4 5 6 7 8 9 10 j q  k  1
 */
public class PokerCard {
    private CardType cardType;
    private int cardValue;


    public PokerCard(CardType cardType, int cardValue) {
        this.cardType = cardType;
        this.cardValue = cardValue;
    }

    @Override
    public String toString() {
        return "pokerCard{" +
                "cardType=" + cardType +
                ", cardValue=" + cardValue +
                '}';
    }


    public boolean Equals(PokerCard obj) {
        if (obj.getCardValue() == this.cardValue && obj.getCardType() == this.cardType) {
            return true;
        }
        return false;
    }


    public CardType getCardType() {
        return cardType;
    }

    public int getCardValue() {
        return cardValue;
    }


}
