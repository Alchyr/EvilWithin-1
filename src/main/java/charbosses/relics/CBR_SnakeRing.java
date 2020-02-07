package charbosses.relics;

import com.megacrit.cardcrawl.dungeons.*;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.relics.SnakeRing;

import charbosses.actions.common.EnemyDrawCardAction;
import charbosses.bosses.AbstractCharBoss;

import com.megacrit.cardcrawl.core.*;
import com.megacrit.cardcrawl.actions.*;
import com.megacrit.cardcrawl.actions.common.*;

public class CBR_SnakeRing extends AbstractCharbossRelic
{
    
    public CBR_SnakeRing() {
        super(new SnakeRing());
    }
    
    @Override
    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0] + 2 + this.DESCRIPTIONS[1];
    }
    
    @Override
    public void atBattleStart() {
        this.addToBot(new RelicAboveCreatureAction(AbstractCharBoss.boss, this));
        this.addToBot(new EnemyDrawCardAction(AbstractCharBoss.boss, 2));
    }
    
    @Override
    public AbstractRelic makeCopy() {
        return new CBR_SnakeRing();
    }
}