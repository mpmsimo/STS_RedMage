package rdm;

// Local imports
import rdm.cards.*;

// BaseMod imports
import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.PostBattleSubscriber;
import basemod.interfaces.PostDungeonInitializeSubscriber;
import basemod.interfaces.PostExhaustSubscriber;

// ModTheSpire imports
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;

// SlayTheSpire imports
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

// Third party imports
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpireInitializer
public class RedMage implements
        PostExhaustSubscriber,
        PostBattleSubscriber,
        PostDungeonInitializeSubscriber,
        EditCardsSubscriber {

    // Initialize logging for debugging purposes.
    public static final Logger logger = LogManager.getLogger(RedMage.class.getName());

    // Mana mechanic tags
    @SpireEnum
    public static AbstractCard.CardTags BLACK_MANA;
    @SpireEnum
    public static AbstractCard.CardTags COMBINED_MANA;
    @SpireEnum
    public static AbstractCard.CardTags WHITE_MANA;

    // Remaining character mechanic tags
    @SpireEnum
    public static AbstractCard.CardTags CHAINSPELL;
    @SpireEnum
    public static AbstractCard.CardTags DUALCAST;
    @SpireEnum
    public static AbstractCard.CardTags ENCHANTED;
    @SpireEnum
    public static AbstractCard.CardTags MIND;
    @SpireEnum
    public static AbstractCard.CardTags PARALYZE;

    public RedMage() {
        BaseMod.subscribe(this);
        resetCounts();
    }

    public static void initialize() {
        new RedMage();
    }

    // Add new cards
    public void receiveEditCards() {
        logger.info("Advancing RDM level to 70.");

        // Starting cards
        BaseMod.addCard(new Strike_RedMage());
        UnlockTracker.unlockCard("RDM:Strike");
        BaseMod.addCard(new Defend_RedMage());
        UnlockTracker.unlockCard("RDM:Defend");
        BaseMod.addCard(new Jolt());
        UnlockTracker.unlockCard("RDM:Jolt");
        BaseMod.addCard(new Bio());
        UnlockTracker.unlockCard("RDM:Bio");

        // Attacks
        // Enchanted Attacks
        // Skills
        // Powers

        logger.info("Job and role abilities have been added.");
    }

    // Add new keywords
    public void receiveEditKeywords() {
        logger.info("Adding RDM keywords.");
        BaseMod.addKeyword(new String[]{"Dualcast"},
                "Your next spell that costs 2 or more can be cast for free.");
        BaseMod.addKeyword(new String[]{"Mind"},
                "Add 1 healing to restoration effects");
        BaseMod.addKeyword(new String[]{"Enchanted"},
                "Your next melee attack or Scatter is Enchanted.");
        BaseMod.addKeyword(new String[]{"Verfire Ready"},
                "Your next Verthunder is replaced with Verfire.");
        BaseMod.addKeyword(new String[]{"Verstone Ready"},
                "Your next Veraero is replaced with Verstone.");
        logger.info("RDM keywords have been added.");
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
