package com.yiwyn.tool;

import com.yiwyn.card.CardType;
import com.yiwyn.card.PokerCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PokerManager {
    private static PokerManager instance;

    private PokerManager() {
    }

    public static PokerManager getInstance() {
        if (instance == null) {
            instance = new PokerManager();
        }
        return instance;
    }


    /**
     * 发牌初始化完成
     */
    PokerPlayer playerA = new PokerPlayer("A");
    PokerPlayer playerB = new PokerPlayer("B");

    List<PokerCard> existPokerCard = new ArrayList<>();

    public void InitPokerGame() {

        for (int i = 0; i < 3; i++) {

            PokerCard card;
            while (true) {
                card = CreatePokerCard();
                //当前已存在链表为空
                if (existPokerCard.size() == 0) {
                    existPokerCard.add(card);
                }

                /**
                 * 判断当前生成的卡牌是否已经存在.
                 * 若存在则重新生成
                 */
                boolean isExis = false;
                for (PokerCard pokerCard : existPokerCard) {
                    if (pokerCard.Equals(card)) {
                        isExis = true;
                    }
                }

                if (!isExis) {
                    break;
                }
            }
            playerA.AddPokerCard(card);
        }

        for (int i = 0; i < 3; i++) {

            PokerCard card;
            while (true) {
                card = CreatePokerCard();
                //当前已存在链表为空
                if (existPokerCard.size() == 0) {
                    existPokerCard.add(card);
                }

                /**
                 * 判断当前生成的卡牌是否已经存在.
                 * 若存在则重新生成
                 */
                boolean isExis = false;
                for (PokerCard pokerCard : existPokerCard) {
                    if (pokerCard.Equals(card)) {
                        isExis = true;
                    }
                }

                if (!isExis) {
                    break;
                }
            }
            playerB.AddPokerCard(card);
        }


        for (PokerCard pokerCard : playerA.PokerCards) {
            System.out.println(pokerCard.toString());
        }

        System.out.println("A的权重为:"+playerA.getCalcWeigth()+"  A的分数为:"+playerA.getCalcScore());
        System.out.println("---------------------------------------------------------------");

        for (PokerCard pokerCard : playerB.PokerCards) {
            System.out.println(pokerCard.toString());
        }
        System.out.println("B的权重为:"+playerB.getCalcWeigth()+"  A的分数为:"+playerB.getCalcScore());

    }

    public PokerPlayer getWinner() {
        PokerPlayer winner = playerA.Contest(playerB);
        return winner;
    }

    /**
     * 创建新的扑克牌,并且确定不会重复
     *
     * @return
     */
    PokerCard CreatePokerCard() {
        Random random = new Random();
        PokerCard card;
        int cardType = random.nextInt(4);
        int cardValue = random.nextInt(13);
        card = new PokerCard(CardType.values()[cardType], cardValue);
        return card;
    }

}
