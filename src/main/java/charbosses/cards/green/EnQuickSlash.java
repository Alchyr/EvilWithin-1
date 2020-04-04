package charbosses.cards.green;

import charbosses.actions.common.EnemyDrawCardAction;
import charbosses.bosses.AbstractCharBoss;
import charbosses.cards.AbstractBossCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.green.FlyingKnee;
import com.megacrit.cardcrawl.cards.green.QuickSlash;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class EnQuickSlash extends AbstractBossCard {
    public static final String ID = "EvilWithin_Charboss:Quick Slash";
    private static final CardStrings cardStrings;

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(QuickSlash.ID);
    }

    public EnQuickSlash() {
        super(ID, EnQuickSlash.cardStrings.NAME, "green/attack/quick_slash", 1, EnQuickSlash.cardStrings.DESCRIPTION, CardType.ATTACK, CardColor.GREEN, CardRarity.COMMON, CardTarget.ENEMY);
        this.baseDamage = 8;
    }

    @Override
    public void use(final AbstractPlayer p, final AbstractMonster m) {
        this.addToBot(new DamageAction(p, new DamageInfo(m, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        this.addToBot(new EnemyDrawCardAction((AbstractCharBoss) m, 1));
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(4);
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new EnQuickSlash();
    }
}