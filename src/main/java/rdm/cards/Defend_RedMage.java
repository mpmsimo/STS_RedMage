package rdm.cards;

import rdm.patches.AbstractCardEnum;

import basemod.abstracts.CustomCard;
import basemod.helpers.BaseModCardTags;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Defend_RedMage extends CustomCard {

    // Card description
    public static final String ID = "RedMageJob:Defend";
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards/Defend_RedMage.png";

    // Card effects
    private static final int COST = 1;
    private static final int BLOCK_AMT = 5;

    // Upgraded card effects
    private static final int UPGRADE_PLUS_BLOCK = 3;

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeBlock(UPGRADE_PLUS_BLOCK);
        }
    }

    public Defend_RedMage() {
        super(
                ID,
                NAME,
                IMG_PATH,
                COST,
                DESCRIPTION,
                AbstractCard.CardType.SKILL,
                AbstractCard.CardColor.RED,
                //AbstractCardEnum.REDMAGE_COLOR,
                AbstractCard.CardRarity.BASIC,
                AbstractCard.CardTarget.SELF
        );
        this.tags.add(BaseModCardTags.BASIC_DEFEND);
        this.baseBlock = BLOCK_AMT;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(
                new GainBlockAction(p, p, this.block)
        );
    }

    public AbstractCard makeCopy() { return new Defend_RedMage(); }

    @Override
    public boolean isDefend() { return true; }
}