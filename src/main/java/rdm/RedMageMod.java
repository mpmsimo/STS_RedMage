package rdm;

// Local imports
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.RelicStrings;
import rdm.assets.RedMageAssetPaths;
import rdm.cards.*;
import rdm.characters.RedMageJob;
import rdm.patches.AbstractCardEnum;
import rdm.patches.RedMageEnum;

// BaseMod imports
import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.EditCharactersSubscriber;

// ModTheSpire imports
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;

// SlayTheSpire imports
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.CharacterStrings;

// Third party imports
import com.badlogic.gdx.Gdx;
import java.nio.charset.StandardCharsets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpireInitializer
public class RedMageMod implements
        EditCharactersSubscriber,
        EditStringsSubscriber,
        EditCardsSubscriber {

    // Initialize logging for debugging purposes.
    public static final Logger logger = LogManager.getLogger(RedMageMod.class.getName());

    /*
        Art Assets
            - Create character color
            - Load art assets
     */

    // Create the RedMageJob color (a shade of magenta, similar to the soulgem)
    public static final com.badlogic.gdx.graphics.Color REDMAGE_COLOR = com.megacrit.cardcrawl.helpers.CardHelper.getColor(250.0F, 117.0F, 161.0F);
    public static final com.badlogic.gdx.graphics.Color REDMAGE_ENCHANTED = com.megacrit.cardcrawl.helpers.CardHelper.getColor(130.0F, 0.0F, 255.0F);

    public RedMageMod() {
        BaseMod.subscribe(this);

        BaseMod.addColor(AbstractCardEnum.REDMAGE_COLOR,
                REDMAGE_COLOR,
                REDMAGE_COLOR,
                REDMAGE_COLOR,
                REDMAGE_COLOR,
                REDMAGE_COLOR,
                REDMAGE_COLOR,
                REDMAGE_COLOR,
                RedMageAssetPaths.ATTACK_CARD.getFilePath(),
                RedMageAssetPaths.SKILL_CARD.getFilePath(),
                RedMageAssetPaths.POWER_CARD.getFilePath(),
                RedMageAssetPaths.ENERGY_ORB.getFilePath(),
                RedMageAssetPaths.ATTACK_CARD_PORTRAIT.getFilePath(),
                RedMageAssetPaths.SKILL_CARD_PORTRAIT.getFilePath(),
                RedMageAssetPaths.POWER_CARD_PORTRAIT.getFilePath(),
                RedMageAssetPaths.ENERGY_ORB_PORTRAIT.getFilePath(),
                RedMageAssetPaths.CARD_ENERGY_ORB.getFilePath());
    }

    public static void initialize() {
        new RedMageMod();
    }

    // Load game description info from JSON
    @Override
    public void receiveEditStrings() {
        logger.info("Writing all description strings in English.");
        String cardStrings = Gdx.files.internal(RedMageAssetPaths.CARD_STRINGS.getFilePath()).readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(CardStrings.class, cardStrings);

        String characterStrings = Gdx.files.internal(RedMageAssetPaths.CHARACTER_STRINGS.getFilePath()).readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(CharacterStrings.class, characterStrings);

        String relicStrings = Gdx.files.internal(RedMageAssetPaths.RELIC_STRINGS.getFilePath()).readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(RelicStrings.class, relicStrings);
        logger.info("Finished writing description strings.");
    }

    /*
        Card Settings
            - Create card tags
            - Loading cards into the game
     */

    // Card Tagging
    @SpireEnum
    public static AbstractCard.CardTags BLACK_MANA;
    @SpireEnum
    public static AbstractCard.CardTags COMBINED_MANA;
    @SpireEnum
    public static AbstractCard.CardTags WHITE_MANA;

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


    // Load cards into game
    public void receiveEditCards() {
        logger.info("Advancing RedMageJob level to 70.");

        // Starting cards
        BaseMod.addCard(new Strike_RedMage());
        UnlockTracker.unlockCard("RedMageJob:Strike");
        BaseMod.addCard(new Defend_RedMage());
        UnlockTracker.unlockCard("RedMageJob:Defend");
        BaseMod.addCard(new Jolt());
        UnlockTracker.unlockCard("RedMageJob:Jolt");
        BaseMod.addCard(new Bio());
        UnlockTracker.unlockCard("RedMageJob:Bio");

        // Attacks
        // Enchanted Attacks
        // Skills
        // Powers

        logger.info("Job and role abilities have been added.");
    }


    /*
        Keywords
            - Add RedMageJob mechanics as keywords
     */

    public void receiveEditKeywords() {
        logger.info("Adding RedMageJob keywords.");
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
        logger.info("RedMageJob keywords have been added!");
    }


    /*
        Character Settings
            - Add the RedMageJob
     */

    public void receiveEditCharacters() {
        logger.info("Spawning soul gems.");
        logger.info("Add " + RedMageEnum.REDMAGE.toString());
        BaseMod.addCharacter(
                new RedMageJob(CardCrawlGame.playerName),
                RedMageAssetPaths.CHAR_BUTTON.getFilePath(),
                RedMageAssetPaths.CHAR_PORTRAIT.getFilePath(),
                RedMageEnum.REDMAGE);
        logger.info("Souls have been accounted for.");
    }
}
