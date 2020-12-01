import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;

import java.util.ArrayList;

@SpirePatch(
        clz= CardGroup.class,
        method="getPurgeableCards"
)
public class CursesFirst
{
    public ArrayList<AbstractCard> group = new ArrayList();

    public CardGroup Replace(){
        CardGroup retVal = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);

        for(AbstractCard card : this.group)
        {
            if(card.type == AbstractCard.CardType.CURSE)
            {
                if(!card.cardID.equals("Necronomicurse") && !card.cardID.equals("CurseOfTheBell") && !card.cardID.equals("AscendersBane"))
                {
                    retVal.group.add(card);
                }
            }
        }

        for(AbstractCard card : this.group)
        {
            if(card.type != AbstractCard.CardType.CURSE)
            {
                    retVal.group.add(card);
            }
        }

        return retVal;
    }
}
