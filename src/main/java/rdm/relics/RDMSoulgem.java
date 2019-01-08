package rdm.relics;

// Local imports
import rdm.characters.RedMageJob;

// SlayTheSpire imports
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;

// BaseMod imports
import basemod.abstracts.CustomRelic;

// Third-party imports
import com.badlogic.gdx.graphics.Texture;

public class RDMSoulgem extends CustomRelic {
    public static final String ID = "RedMageJob:RDMSoulgem";

    public RDMSoulgem() {
        super(ID,
                new Texture(("img/relics/rdm_soulgem.png")),
                new Texture(("relics/rdm_soulgem_outline.png")),
                RelicTier.RARE,
                LandingSound.MAGICAL);
    }

    @Override
    public String getUpdatedDescription() { return this.DESCRIPTIONS[0]; }

    public void atBattleStartPreDraw() {
        this.flash();
        //TODO: Add Mind
        //AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new StrengthPower(RedMageJob , 1)));
    }
    public boolean canSpawn() { return AbstractDungeon.player instanceof RedMageJob; }

    @Override
    public AbstractRelic makeCopy() { return new RDMSoulgem(); }
}