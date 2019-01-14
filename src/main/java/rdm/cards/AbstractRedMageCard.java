package rdm.cards;


import rdm.characters.RedMageJob;


import basemod.abstracts.CustomCard;
import basemod.abstracts.DynamicVariable;
import basemod.helpers.TooltipInfo;
import com.megacrit.cardcrawl.cards.AbstractCard;

import java.util.ArrayList;
import java.util.List;

/*
public class AbstractRedMageCard extends CustomCard {
    public int baseSecondMagicNumber;
    public int secondMagicNumber;

    public boolean isSecondMagicNumberModified;
    public boolean upgradedSecondMagicNumber;

    public AbstractRedMageCard(
            final String id,
            final String name,
            final String img,
            final int cost,
            final String rawDescription,
            final AbstractCard.CardType type,
            final AbstractCard.CardColor color,
            final AbstractCard.CardRarity rarity,
            final AbstractCard.CardTarget target) {
        super(
                id,
                name,
                img,
                cost,
                rawDescription,
                type,
                color,
                rarity,
                target);
    }

    // Accessors
    public boolean isEnchanted() {
        return this.hasTag(RedMageTags.ENCHANTED);
    }

    public boolean isBlackMagic() {
        return this.hasTag(RedMageTags.BLACK_MAGIC);
    }

    public boolean isWhiteMagic() {
        return this.hasTag(RedMageTags.WHITE_MAGIC);
    }

    public boolean isDualcast() {
        return this.hasTag(RedMageTags.DUALCAST);
    }

    public boolean isChainspell() {
        return this.hasTag(RedMageTags.CHAINSPELL);
    }

    public boolean isParalyze() {
        return this.hasTag(RedMageTags.PARALYZE);
    }

    public boolean isMind() {
        return this.hasTag(RedMageTags.MIND);
    }

    public boolean isRestore() {
        return this.hasTag(RedMageTags.RESTORE);
    }

    public boolean isRegen() {
        return this.hasTag(RedMageTags.REGEN);
    }

    @Override
    public List<TooltipInfo> getCustomTooltips() {
        List<TooltipInfo> retVal = new ArrayList<>();
        if (this.type == AbstractCard.CardType.SKILL) {
            if (RedMageJob.isThisASpell(this)) {
                retVal.add(new TooltipInfo(tooltips[0], tooltips[2]));
            }
            if (RedMageJob.isThisAnArte(this)) {
                retVal.add(new TooltipInfo(tooltips[1], tooltips[3]));
            }
        } else if (this.type == AbstractCard.CardType.ATTACK) {
            if (RedMageJob.isThisASpell(this)) {
                retVal.add(new TooltipInfo(tooltips[0], tooltips[4]));
            }
            if (RedMageJob.isThisAnArte(this)) {
                retVal.add(new TooltipInfo(tooltips[1], tooltips[5]));
            }
        }
        return retVal;
    }

    public void upgradeToSpell() {
        this.tags.add(RedMageTags.IS_SPELL);
    }

    public void upgradeToArte() {
        this.tags.add(RedMageTags.IS_ARTE);
    }

    public void upgradeSecondMagicNumber(int amount) {
        this.baseSecondMagicNumber += amount;
        this.secondMagicNumber = this.baseSecondMagicNumber;
        this.upgradedSecondMagicNumber = true;
    }

    public static class SecondMagicNumber extends DynamicVariable {

        @Override
        public int baseValue(AbstractCard card) {
            if (card instanceof AbstractRedMageCard) {
                return ((AbstractRedMageCard)card).baseSecondMagicNumber;
            } else {
                return -1;
            }
        }

        @Override
        public boolean isModified(AbstractCard card) {
            if (card instanceof AbstractRedMageCard) {
                return ((AbstractRedMageCard)card).isSecondMagicNumberModified;
            } else {
                return false;
            }
        }

        @Override
        public void setIsModified(AbstractCard card, boolean v) {
            if (card instanceof AbstractRedMageCard) {
                ((AbstractRedMageCard)card).isSecondMagicNumberModified = v;
            }
        }

        @Override
        public String key() {
            return "mysticmod:M2";
        }

        @Override
        public boolean upgraded(AbstractCard card) {
            if (card instanceof AbstractRedMageCard) {
                return ((AbstractRedMageCard)card).upgradedSecondMagicNumber;
            } else {
                return false;
            }
        }

        @Override
        public int value(AbstractCard card) {
            if (card instanceof AbstractRedMageCard) {
                return ((AbstractRedMageCard)card).secondMagicNumber;
            } else {
                return -1;
            }
        }
    }
}
*/
