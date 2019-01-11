package rdm.cards;

import rdm.RedMageMod;

import basemod.abstracts.CustomCard;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Verflare extends CustomCard {

    // Card description
    public static final String ID = "RDM:Verflare";
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards/verflare.png";

    // Card effects
    private static final int COST = 2;
    private static final int ATTACK_DMG = 16;
    private static final int BLACK_MANA = 10;

    // Upgraded card effects
    private static final int UPGRADE_PLUS_DMG = 6;
    private static final int UPGRADE_PLUS_BLACK_MANA = 5;

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(UPGRADE_PLUS_DMG);
        }
    }

    public Verflare() {
        super(
                ID,
                NAME,
                IMG_PATH,
                COST,
                DESCRIPTION,
                AbstractCard.CardType.ATTACK,
                AbstractCard.CardColor.RED,
                //AbstractCardEnum.REDMAGE_COLOR,
                AbstractCard.CardRarity.UNCOMMON,
                AbstractCard.CardTarget.ENEMY);
        tags.add(RedMageMod.BLACK_MANA);
        this.isEthereal = true;
        this.damage = this.baseDamage = ATTACK_DMG;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.DamageAction(m,
                new DamageInfo(p, this.damage, this.damageTypeForTurn),
                AbstractGameAction.AttackEffect.FIRE));
    }

    @Override
    public AbstractCard makeCopy() { return new Verflare(); }
}
