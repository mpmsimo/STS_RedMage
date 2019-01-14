package variables;

import basemod.abstracts.DynamicVariable;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class TotalBlackMagicCards extends DynamicVariable
{

    // Will display as !TBMC!
    @Override
    public String key()
    {
        return "TBMC";
    }

    // Has the damage value changed?
    @Override
    public boolean isModified(AbstractCard card)
    {
        return card.isDamageModified;
    }

    // Amount of black magic cards (non-temporary) in deck.
    @Override
    public int value(AbstractCard card)
    {
        return card.damage;
    }

    @Override
    public int baseValue(AbstractCard card){
        // Search for Tags with BlackMagic
        return AbstractDungeon.player.masterDeck.size();
    }

    @Override
    public boolean upgraded(AbstractCard card)
    {
        return card.upgradedDamage;
    }
}
