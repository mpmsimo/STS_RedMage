package rdm.characters;

// built-ins
import java.util.ArrayList;

// local imports
import rdm.RedMageMod;
import rdm.assets.RedMageAssetPaths;
import rdm.cards.Dia;
import rdm.cards.Defend;
import rdm.cards.Jolt;
import rdm.cards.Strike;
import rdm.patches.AbstractCardEnum;
import rdm.relics.Dualcast;
import rdm.patches.RedMageEnum;

// BaseMod imports
import basemod.abstracts.CustomPlayer;
import basemod.animations.SpriterAnimation;

// Slay the Spire imports
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ScreenShake;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CharacterStrings;

// third-party imports
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class RedMageJob extends CustomPlayer {

    // Character Statistics
    public static final String ID = "RDM:RedMageJob";
    private static final CharacterStrings characterStrings = CardCrawlGame.languagePack.getCharacterString(ID);
    public static final String[] NAMES = characterStrings.NAMES;
    public static final String[] TEXT = characterStrings.TEXT;
    public static final int STARTING_HP = 70;
    public static final int MAX_HP = 70;
    public static final int STARTING_GOLD = 99;
    public static final int HAND_SIZE = 5;
    public static final int ENERGY_PER_TURN = 3; // how much energy you get every turn
    public static final int ORB_SLOTS = 0;
    private static final float DIALOG_X_ADJUSTMENT = 0.0F;
    private static final float DIALOG_Y_ADJUSTMENT = 220.0F;
    public static final String ANIMATION = RedMageAssetPaths.ANIMATION.getFilePath();
    public static final String[] ORB_TEXTURES = {
            "img/char/orb/layer1.png",
            "img/char/orb/layer2.png",
            "img/char/orb/layer3.png",
            "img/char/orb/layer4.png",
            "img/char/orb/layer5.png",
            "img/char/orb/layer6.png",
            "img/char/orb/layer1d.png",
            "img/char/orb/layer2d.png",
            "img/char/orb/layer3d.png",
            "img/char/orb/layer4d.png",
            "img/char/orb/layer5d.png"
    };


    public RedMageJob(String name) {
        super(name, RedMageEnum.REDMAGE, ORB_TEXTURES, RedMageAssetPaths.ORB_VFX.getFilePath(), null, new SpriterAnimation(ANIMATION));

        this.dialogX = this.drawX + DIALOG_X_ADJUSTMENT * Settings.scale;
        this.dialogY = this.drawY + DIALOG_Y_ADJUSTMENT * Settings.scale;

        initializeClass(null,
                RedMageAssetPaths.SHOULDER_2.getFilePath(), // required call to load textures and setup energy/loadout
                RedMageAssetPaths.SHOULDER_1.getFilePath(),
                RedMageAssetPaths.CORPSE.getFilePath(),
                getLoadout(), 20.0F, -10.0F, 220.0F, 290.0F, new EnergyManager(ENERGY_PER_TURN));
    }

    @Override
    public CharSelectInfo getLoadout() {
        return new CharSelectInfo(
                NAMES[0],
                TEXT[0],
                STARTING_HP,
                MAX_HP,
                ORB_SLOTS,
                STARTING_GOLD,
                HAND_SIZE,
                this,
                getStartingRelics(),
                getStartingDeck(),
                false);
    }

    public AbstractPlayer newInstance() {
        return new RedMageJob(this.name);
    }

    @Override
    public ArrayList<String> getStartingDeck() {
        ArrayList<String> retVal = new ArrayList<>();
        retVal.add(Strike.ID);
        retVal.add(Strike.ID);
        retVal.add(Strike.ID);
        retVal.add(Strike.ID);
        retVal.add(Defend.ID);
        retVal.add(Defend.ID);
        retVal.add(Defend.ID);
        retVal.add(Defend.ID);
        retVal.add(Jolt.ID);
        retVal.add(Dia.ID);
        return retVal;
    }

    @Override
    public ArrayList<String> getStartingRelics() {
        ArrayList<String> retVal = new ArrayList<>();
        retVal.add(Dualcast.ID);
        UnlockTracker.markRelicAsSeen(Dualcast.ID);
        return retVal;
    }

    @Override
    public String getTitle(PlayerClass playerClass) {
        return NAMES[0];
    }

    public String getSpireHeartText() {
        return TEXT[1];
    }

    @Override
    public String getVampireText() {
        return TEXT[2];
    }

    @Override
    public void doCharSelectScreenSelectEffect() {
        CardCrawlGame.sound.playA("ATTACK_FIRE", MathUtils.random(-0.2f, 0.2f));
        CardCrawlGame.sound.playA("ATTACK_FAST", MathUtils.random(-0.2f, 0.2f));
        CardCrawlGame.screenShake.shake(ScreenShake.ShakeIntensity.MED, ScreenShake.ShakeDur.SHORT, false);
    }

    @Override
    public Color getSlashAttackColor() {
        return RedMageMod.REDMAGE_COLOR;
    }

    @Override
    public Color getCardRenderColor() {
        return RedMageMod.REDMAGE_COLOR;
    }

    @Override
    public AbstractCard.CardColor getCardColor() {
        return AbstractCardEnum.REDMAGE_COLOR;
    }

    @Override
    public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        return new AbstractGameAction.AttackEffect[]{
                AbstractGameAction.AttackEffect.SLASH_DIAGONAL,
                AbstractGameAction.AttackEffect.FIRE,
                AbstractGameAction.AttackEffect.SLASH_HORIZONTAL,
                AbstractGameAction.AttackEffect.POISON,
                AbstractGameAction.AttackEffect.BLUNT_LIGHT,
                AbstractGameAction.AttackEffect.BLUNT_LIGHT,
                AbstractGameAction.AttackEffect.BLUNT_LIGHT,
                AbstractGameAction.AttackEffect.BLUNT_HEAVY
        };
    }

    @Override
    public AbstractCard getStartCardForEvent() {
        return new Jolt();
    }

    @Override
    public Color getCardTrailColor() {
        return RedMageMod.REDMAGE_COLOR;
    }

    @Override
    public int getAscensionMaxHPLoss() {
        return 5;
    }

    @Override
    public BitmapFont getEnergyNumFont() {
        return FontHelper.energyNumFontRed;
    }

    @Override
    public String getCustomModeCharacterButtonSoundKey() {
        return "ATTACK_FIRE";
    }

    @Override
    public String getLocalizedCharacterName() { return NAMES[0]; }

    // Custom Mechanics
}
