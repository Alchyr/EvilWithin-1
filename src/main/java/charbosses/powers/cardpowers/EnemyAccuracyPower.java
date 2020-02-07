package charbosses.powers.cardpowers;

import com.megacrit.cardcrawl.localization.*;
import com.megacrit.cardcrawl.powers.AbstractPower;

import charbosses.bosses.AbstractCharBoss;
import charbosses.cards.colorless.EnShiv;

import com.megacrit.cardcrawl.dungeons.*;
import com.megacrit.cardcrawl.cards.*;
import com.megacrit.cardcrawl.cards.tempCards.*;
import java.util.*;
import com.megacrit.cardcrawl.core.*;

public class EnemyAccuracyPower extends AbstractPower
{
    public static final String POWER_ID = "EvilWithin:Enemy Accuracy";
    private static final PowerStrings powerStrings;
    public static final String[] DESCRIPTIONS;
    
    public EnemyAccuracyPower(final AbstractCreature owner, final int amt) {
        this.name = EnemyAccuracyPower.powerStrings.NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = amt;
        this.updateDescription();
        this.loadRegion("accuracy");
        this.updateExistingShivs();
    }
    
    @Override
    public void updateDescription() {
        this.description = EnemyAccuracyPower.DESCRIPTIONS[0] + this.amount + EnemyAccuracyPower.DESCRIPTIONS[1];
    }
    
    @Override
    public void stackPower(final int stackAmount) {
        this.fontScale = 8.0f;
        this.amount += stackAmount;
        this.updateExistingShivs();
    }
    
    private void updateExistingShivs() {
        for (final AbstractCard c : AbstractCharBoss.boss.hand.group) {
            if (c instanceof EnShiv) {
                if (!c.upgraded) {
                    c.baseDamage = 4 + this.amount;
                }
                else {
                    c.baseDamage = 6 + this.amount;
                }
            }
        }
        for (final AbstractCard c : AbstractCharBoss.boss.drawPile.group) {
            if (c instanceof EnShiv) {
                if (!c.upgraded) {
                    c.baseDamage = 4 + this.amount;
                }
                else {
                    c.baseDamage = 6 + this.amount;
                }
            }
        }
        for (final AbstractCard c : AbstractCharBoss.boss.discardPile.group) {
            if (c instanceof EnShiv) {
                if (!c.upgraded) {
                    c.baseDamage = 4 + this.amount;
                }
                else {
                    c.baseDamage = 6 + this.amount;
                }
            }
        }
        for (final AbstractCard c : AbstractCharBoss.boss.exhaustPile.group) {
            if (c instanceof EnShiv) {
                if (!c.upgraded) {
                    c.baseDamage = 4 + this.amount;
                }
                else {
                    c.baseDamage = 6 + this.amount;
                }
            }
        }
    }
    
    @Override
    public void onDrawOrDiscard() {
        for (final AbstractCard c : AbstractCharBoss.boss.hand.group) {
            if (c instanceof EnShiv) {
                if (!c.upgraded) {
                    c.baseDamage = 4 + this.amount;
                }
                else {
                    c.baseDamage = 6 + this.amount;
                }
            }
        }
    }
    
    static {
        powerStrings = CardCrawlGame.languagePack.getPowerStrings("Accuracy");
        DESCRIPTIONS = EnemyAccuracyPower.powerStrings.DESCRIPTIONS;
    }
}