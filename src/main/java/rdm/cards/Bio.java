package rdm.cards;

import rdm.RedMage;

import basemod.abstracts.CustomCard;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;

public class Bio extends CustomCard {

    // Card description
    public static final String ID = "RDM:Bio";
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards/bio.png";

    // Card effects
    private static final int COST = 2;
    private static final int POTENCY = 7;
    private static final int COMBINED_MANA = 5;

    // Upgraded card effects
    //public static final String UPGRADE_NAME = "Bio II"
    //public static final String UPGRADE_DESCRIPTION;
    private static final int UPGRADE_PLUS_POTENCY = 5;
    private static final int UPGRADE_PLUS_COMBINED_MANA = 5;

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(UPGRADE_PLUS_POTENCY);
        }
    }

    public Bio() {
        super(
                ID,
                NAME,
                IMG_PATH,
                COST,
                DESCRIPTION,
                CardType.ATTACK,
                CardColor.RED,
                //AbstractCardEnum.REDMAGE_COLOR,
                CardRarity.COMMON,
                CardTarget.ENEMY);
        tags.add(RedMage.COMBINED_MANA);
        this.magicNumber = this.baseMagicNumber = POTENCY;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p, new PoisonPower(m, p, this.magicNumber), this.magicNumber, true, AbstractGameAction.AttackEffect.POISON));
    }

    @Override
    public AbstractCard makeCopy() {
        return new Bio();
    }
}
