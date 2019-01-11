package rdm.patches;

import basemod.TopPanelItem;
import com.badlogic.gdx.graphics.Texture;
import rdm.assets.RedMageAssetPaths;

import static basemod.BaseMod.logger;

/*:24
public class BalanceGauge extends TopPanelItem {

    public BalanceGauge() {
        super(new Texture(RedMageAssetPaths.BLACK_MANA_TOPPANEL.getFilePath()), "RDM:BlackManaTopPanel");
    }

    @Override
    protected void onClick() {
        logger.info("Balance Gauge clicked.");
    }
}



    /*

    //public class BlackManaTopPanel() {
    public BalanceGauge {
        super(new Texture(RedMageAssetPaths.BLACK_MANA_TOPPANEL.getFilePath()), "RDM:BlackManaTopPanel");
    }

    //TODO
    // Draw UI components for Balance Gauge

        @Override
        protected void onClick() {
            // your onclick code
        }
    }

    public class BalanceGauge extends TopPanelItem {
        private static final Texture IMG = new Texture(".png");
        public static final String ID = "yourmodname:TopPanelItemExample";

        public TopPanelItemExample() {
            super(IMG, ID);
        }

        @Override
        protected void onClick() {
            // your onclick code
        }
    }
    // Calculate manas
    // Store manas so they persist through combats
    // Have a way to represent this out of combat, maybe dynamically updated on soulgem
    // When hovering over a card that uses Mana flash the relic + the exact amount on the balance gauge

    public static boolean isThisASpell(AbstractCard card) {
        boolean retVal = false;
        if (card instanceof AbstractRedMageCard) {
            if (((AbstractRedMageCard)card).isSpell()) { //methods simply call against hasTag, but exist to offer hooks into conditional spell/arte logic within specific cards
                retVal = true;
            }
        } else if (card.hasTag(RedMageTags.IS_SPELL)) { //First, determine if card is naturally a spell (has the tag)
            retVal = true;
        }
        if (RefreshSpellArteLogicField.checkSpell.get(card)) {
            if (AbstractDungeon.player != null) { //Then, apply any conditional relic/power logic with provided hooks.
                ArrayList<SpellArteLogicAffector> listByPriority = new ArrayList<>();
                Iterator iter;
                iter = AbstractDungeon.player.relics.iterator();
                AbstractRelic r;
                while (iter.hasNext()) {
                    r = (AbstractRelic) iter.next();
                    if (r instanceof SpellArteLogicAffector) {
                        listByPriority.add((SpellArteLogicAffector)r);
                    }
                }
                iter = AbstractDungeon.player.powers.iterator();
                AbstractPower p;
                while (iter.hasNext()) {
                    p = (AbstractPower) iter.next();
                    if (p instanceof SpellArteLogicAffector) {
                        listByPriority.add((SpellArteLogicAffector)p);
                    }
                }
                listByPriority.sort(new SpellArteLogicAffector.SortByPriority());
                iter = listByPriority.iterator();
                while (iter.hasNext()) {
                    retVal = ((SpellArteLogicAffector)iter.next()).modifyIsSpell(card, retVal);
                }
            }
            RefreshSpellArteLogicField.isConditionalSpell.set(card, retVal);
            RefreshSpellArteLogicField.checkSpell.set(card, false);
        } else {
            retVal = RefreshSpellArteLogicField.isConditionalSpell.get(card);
        }
        return retVal;
    }

    public static boolean isThisAnArte(AbstractCard card) {
        boolean retVal = false;
        if (card instanceof AbstractRedMageCard) {
            if (((AbstractRedMageCard)card).isArte()) { //if card is RedMage card, test if has Arte tag
                retVal = true;
            }
        } else if (card.hasTag(RedMageTags.IS_ARTE)) { //if card is not a mystic card, repeat tests.
            retVal = true;
        }
        if (RefreshSpellArteLogicField.checkArte.get(card)) {
            if (AbstractDungeon.player != null) { //Then, apply any conditional relic/power logic with provided hooks.
                ArrayList<SpellArteLogicAffector> listByPriority = new ArrayList<>();
                Iterator iter;
                iter = AbstractDungeon.player.relics.iterator();
                AbstractRelic r;
                while (iter.hasNext()) {
                    r = (AbstractRelic) iter.next();
                    if (r instanceof SpellArteLogicAffector) {
                        listByPriority.add((SpellArteLogicAffector)r);
                    }
                }
                iter = AbstractDungeon.player.powers.iterator();
                AbstractPower p;
                while (iter.hasNext()) {
                    p = (AbstractPower) iter.next();
                    if (p instanceof SpellArteLogicAffector) {
                        listByPriority.add((SpellArteLogicAffector)p);
                    }
                }
                listByPriority.sort(new SpellArteLogicAffector.SortByPriority());
                iter = listByPriority.iterator();
                while (iter.hasNext()) {
                    retVal = ((SpellArteLogicAffector)iter.next()).modifyIsArte(card, retVal);
                }
            }
            RefreshSpellArteLogicField.isConditionalArte.set(card, retVal);
            RefreshSpellArteLogicField.checkArte.set(card, false);
        } else {
            retVal = RefreshSpellArteLogicField.isConditionalArte.get(card);
        }
        return retVal;
    }

//}

    */
