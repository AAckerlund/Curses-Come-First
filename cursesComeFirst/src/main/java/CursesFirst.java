import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;

import java.util.ArrayList;

@SpirePatch(
        clz= CardGroup.class,
        method="getPurgeableCards"
)

public class CursesFirst{
    public static CardGroup Postfix(CardGroup retVal){
        ArrayList<AbstractCard> curses = new ArrayList();
        for(AbstractCard card : retVal.group){
            if(card.type == AbstractCard.CardType.CURSE){
                if(!card.cardID.equals("Necronomicurse") && !card.cardID.equals("CurseOfTheBell") && !card.cardID.equals("AscendersBane")){
                    curses.add(card);
                }
            }
        }
        for (AbstractCard card : curses){
            retVal.removeCard(card);
            retVal.addToBottom(card);
        }
        return retVal;
    }
}
