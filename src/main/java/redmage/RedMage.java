package redmage;

// BaseMod imports
import basemod.BaseMod;
import basemod.interfaces.PostBattleSubscriber;
import basemod.interfaces.PostDungeonInitializeSubscriber;
import basemod.interfaces.PostExhaustSubscriber;

// SpireInitializer import
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

// SlayTheSpire imports
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

@SpireInitializer
public class RedMage implements
        PostExhaustSubscriber,
        PostBattleSubscriber,
        PostDungeonInitializeSubscriber {

    public RedMage() {
        BaseMod.subscribe(this);
        resetCounts();
    }

    public static void initialize() {
        new RedMage();
    }

    private int count, totalCount;

    private void resetCounts() {
        totalCount = count = 0;
    }

    @Override
    public void receivePostExhaust(AbstractCard c) {
        count++;
        totalCount++;
    }

    @Override
    public void receivePostBattle(AbstractRoom r) {
        System.out.println(count + " cards were exhausted this battle, " +
                totalCount + " cards have been exhausted so far this act.");
        count = 0;
    }

    @Override
    public void receivePostDungeonInitialize() {
        resetCounts();
    }
}
