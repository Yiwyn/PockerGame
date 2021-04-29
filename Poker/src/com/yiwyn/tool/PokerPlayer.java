package com.yiwyn.tool;

import com.yiwyn.card.PokerCard;


import java.util.ArrayList;
import java.util.List;

/**
 * 游戏的玩家,玩家拥有的卡牌分值计算这这里
 */
public class PokerPlayer {

    private String playerName;

    public PokerPlayer(String playername) {
        this.playerName = playername;
    }

    public String getPlayerName() {
        return playerName;
    }

    List<PokerCard> PokerCards = new ArrayList<>();


    public void AddPokerCard(PokerCard pokerCard) {

        PokerCards.add(pokerCard);

        if (PokerCards.size() == 3) {
            SortCard();
            return;
        }

    }


    /**
     * 手中卡牌排序,方便计算牌型
     * ///添加卡组时直接进行排序
     */
    public void SortCard() {
        for (int i = 0; i < PokerCards.size() - 1; i++) {
            for (int j = 0; j < PokerCards.size() - 1 - i; j++) {
                if (PokerCards.get(j).getCardValue() > PokerCards.get(j + 1).getCardValue()) {
                    PokerCard tamp = PokerCards.get(j);
                    PokerCards.set(j, PokerCards.get(j + 1));
                    PokerCards.set(j + 1, tamp);
                }

            }
        }


    }


    /**
     * 计算权重
     * 两处考量
     * 1.花色 2.数值
     * 5个等级
     *
     * @return 返回玩家手里牌的等级的权重值 越大则等级越高 (1,5)
     */
    public int getCalcWeigth() {
        if (PokerCards.get(0).getCardType() == PokerCards.get(1).getCardType() && PokerCards.get(0).getCardType() == PokerCards.get(2).getCardType()) {
            return 5;
        }
        if (PokerCards.get(0).getCardValue() + PokerCards.get(2).getCardValue() == PokerCards.get(1).getCardValue()) {
            return 4;
        }
        if (PokerCards.get(0).getCardValue() == PokerCards.get(1).getCardValue() && PokerCards.get(1).getCardValue() == PokerCards.get(2).getCardValue()) {
            return 3;
        }
        if (PokerCards.get(0).getCardValue() == PokerCards.get(1).getCardValue() || PokerCards.get(1).getCardValue() == PokerCards.get(2).getCardValue()
                || PokerCards.get(0).getCardValue() == PokerCards.get(2).getCardValue()) {
            return 2;
        }

        return 1;
    }

    /**
     * @return 返回玩家手里的卡牌的数值总合
     */
    public int getCalcScore() {
        return PokerCards.get(0).getCardValue() + PokerCards.get(1).getCardValue() + PokerCards.get(2).getCardValue();
    }

    /**
     * @param pokerPlayer 返回胜利的一方,当返回null 则表示平局
     * @return
     */
    public PokerPlayer Contest(PokerPlayer pokerPlayer) {
        if (pokerPlayer.getCalcWeigth() > this.getCalcWeigth()) {
            return pokerPlayer;
        } else if (pokerPlayer.getCalcWeigth() < this.getCalcWeigth()) {
            return this;
        } else {
            if (pokerPlayer.getCalcScore() > this.getCalcScore()) {
                return pokerPlayer;
            } else if (pokerPlayer.getCalcScore() < this.getCalcScore()) {
                return this;
            }

        }

        return null;
    }

}
