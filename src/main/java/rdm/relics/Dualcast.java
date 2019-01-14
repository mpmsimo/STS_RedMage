package rdm.relics;

import rdm.assets.RedMageAssetPaths;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.RelicLibrary;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class Dualcast extends CustomRelic {

    public static final String ID = "RDM:Dualcast";
    private boolean isActive = false;

    public Dualcast() {
        super(
                ID,
                new com.badlogic.gdx.graphics.Texture(RedMageAssetPaths.RELIC_DUALCAST.getFilePath()),
                new com.badlogic.gdx.graphics.Texture(RedMageAssetPaths.RELIC_DUALCAST_OUTLINE.getFilePath()),
                RelicTier.STARTER,
                LandingSound.MAGICAL);
    }

    public String getUpdatedDescription()
    {
        return this.DESCRIPTIONS[0];
    }

    public void atBattleStart()
    {
        super.atBattleStart();
        this.isActive = false;
    }

    public boolean canSpawn() { return AbstractDungeon.player.hasRelic(ID); }

    public void obtain() {
        if (AbstractDungeon.player.hasRelic(ID)) {
            for (int i = 0; i < AbstractDungeon.player.relics.size(); i++) {
                if (AbstractDungeon.player.relics.get(i).relicId.equals(ID)) {
                    instantObtain(AbstractDungeon.player, i, true);
                    break;
                }
            }
        } else {
            super.obtain();
        }
    }

    public AbstractRelic makeCopy()
    {
        return new Dualcast();
    }
}
