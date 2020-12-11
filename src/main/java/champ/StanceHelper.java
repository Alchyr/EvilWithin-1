package champ;

import basemod.BaseMod;
import champ.stances.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.Hitbox;
import com.megacrit.cardcrawl.helpers.TipHelper;
import com.megacrit.cardcrawl.helpers.input.InputHelper;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

public class StanceHelper {

    public static float globalX = 15F * Settings.scale;
    public static float globalY = 900F * Settings.scale;

    public static Hitbox hitboxStance;
    private static Hitbox hitboxTechnique;
    private static Hitbox hitboxFinisher;

    /*
            hitboxStance = new Hitbox(globalX, globalY, 200 * Settings.scale, 100 * Settings.scale);
        hitboxTechnique = new Hitbox(globalX, globalY - (100F * Settings.scale), 200 * Settings.scale, 100 * Settings.scale);
        hitboxFinisher = new Hitbox(globalX, globalY - (200F * Settings.scale), 200 * Settings.scale, 100 * Settings.scale);
     */

    public static Vector2 dx1 = new Vector2(globalX, globalY);
    public static Vector2 dx2 = new Vector2(globalX, globalY - (100F * Settings.scale));
    public static Vector2 dx3 = new Vector2(globalX, globalY - (200F * Settings.scale));

    public static void init() {
        hitboxStance = new Hitbox(globalX, globalY - (50F * Settings.scale), 300 * Settings.scale, 100 * Settings.scale);
        hitboxTechnique = new Hitbox(globalX, globalY - (150F * Settings.scale), 300 * Settings.scale, 100 * Settings.scale);
        hitboxFinisher = new Hitbox(globalX, globalY - (250F * Settings.scale), 300 * Settings.scale, 100 * Settings.scale);
    }

    public static void update() {
        hitboxStance.update();
        hitboxTechnique.update();
        hitboxFinisher.update();
    }

    public static String getStanceName() {
        if (AbstractDungeon.player.stance instanceof BerserkerStance) {
            return ChampChar.characterStrings.TEXT[24];
        } else if (AbstractDungeon.player.stance instanceof DefensiveStance) {
            return ChampChar.characterStrings.TEXT[25];
        } else if (AbstractDungeon.player.stance instanceof GladiatorStance) {
            return ChampChar.characterStrings.TEXT[26];
        } else if (AbstractDungeon.player.stance instanceof UltimateStance) {
            return ChampChar.characterStrings.TEXT[7];
        } else if (AbstractDungeon.player instanceof ChampChar) {
            return ChampChar.characterStrings.TEXT[6];
        }
        return null;
    }


    public static String getStanceTechnique() {
        if (AbstractDungeon.player.stance instanceof BerserkerStance) {
            return ChampChar.characterStrings.TEXT[10];
        } else if (AbstractDungeon.player.stance instanceof DefensiveStance) {
            return ChampChar.characterStrings.TEXT[12];
        } else if (AbstractDungeon.player.stance instanceof GladiatorStance) {
            return ChampChar.characterStrings.TEXT[14];
        } else if (AbstractDungeon.player.stance instanceof UltimateStance) {
            return ChampChar.characterStrings.TEXT[19];
        } else if (AbstractDungeon.player instanceof ChampChar) {
            return ChampChar.characterStrings.TEXT[6];
        }
        return null;
    }

    public static String getStanceFinisher() {
        if (AbstractDungeon.player.stance instanceof BerserkerStance) {
            return ChampChar.characterStrings.TEXT[11];
        } else if (AbstractDungeon.player.stance instanceof DefensiveStance) {
            return ChampChar.characterStrings.TEXT[13];
        } else if (AbstractDungeon.player.stance instanceof GladiatorStance) {
            return ChampChar.characterStrings.TEXT[15];
        } else if (AbstractDungeon.player.stance instanceof UltimateStance) {
            return ChampChar.characterStrings.TEXT[20];
        } else if (AbstractDungeon.player instanceof ChampChar) {
            return ChampChar.characterStrings.TEXT[6];
        }
        return null;
    }

    public static void render(SpriteBatch sb) {
        if (AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT)
            if (hitboxStance != null) {
                if (getStanceName() != null) {
                    TipHelperChamp1.renderGenericTip(dx1.x, dx1.y,
                            ChampChar.characterStrings.TEXT[23],
                            getStanceName());

                    TipHelperChamp1.render(sb);
                    if (hitboxStance.hovered && AbstractDungeon.player.stance instanceof AbstractChampStance) {
                        if ((float) InputHelper.mX < 1400.0F * Settings.scale) {
                            TipHelper.renderGenericTip(
                                    (float) InputHelper.mX + 60.0F * Settings.scale, (float) InputHelper.mY - 50.0F * Settings.scale,
                                    BaseMod.getKeywordTitle(((AbstractChampStance) AbstractDungeon.player.stance).getKeywordString()),
                                    BaseMod.getKeywordDescription(((AbstractChampStance) AbstractDungeon.player.stance).getKeywordString()));
                        } else {
                            TipHelper.renderGenericTip((float) InputHelper.mX - 350.0F * Settings.scale, (float) InputHelper.mY - 50.0F * Settings.scale,
                                    BaseMod.getKeywordTitle(((AbstractChampStance) AbstractDungeon.player.stance).getKeywordString()),
                                    BaseMod.getKeywordDescription(((AbstractChampStance) AbstractDungeon.player.stance).getKeywordString()));
                        }
                    }

                    TipHelperChamp2.renderGenericTip(dx2.x, dx2.y,
                            ChampChar.characterStrings.TEXT[8],
                            getStanceTechnique());

                    TipHelperChamp2.render(sb);
                    if (hitboxTechnique.hovered && AbstractDungeon.player.stance instanceof AbstractChampStance) {
                        String t = "ERROR";
                        String d = "ERROR2";
                        if (AbstractDungeon.player.stance instanceof DefensiveStance) {
                            t = BaseMod.getKeywordTitle("champ:counter");
                            d = BaseMod.getKeywordDescription("champ:counter");
                        } else if (AbstractDungeon.player.stance instanceof BerserkerStance) {
                            t = BaseMod.getKeywordTitle("champ:resolve");
                            d = BaseMod.getKeywordDescription("champ:resolve");
                        }
                        if (!t.equals("ERROR")) {
                            if ((float) InputHelper.mX < 1400.0F * Settings.scale) {
                                TipHelper.renderGenericTip(
                                        (float) InputHelper.mX + 60.0F * Settings.scale, (float) InputHelper.mY - 50.0F * Settings.scale,
                                        t,
                                        d);
                            } else {
                                TipHelper.renderGenericTip((float) InputHelper.mX - 350.0F * Settings.scale, (float) InputHelper.mY - 50.0F * Settings.scale,
                                        t, d);
                            }
                        }
                    }

                    TipHelperChamp3.renderGenericTip(dx3.x, dx3.y,
                            ChampChar.characterStrings.TEXT[9],
                            getStanceFinisher());

                    TipHelperChamp3.render(sb);
                    if (hitboxFinisher.hovered && AbstractDungeon.player.stance instanceof AbstractChampStance) {
                        String t = "ERROR";
                        String d = "ERROR2";
                        if (AbstractDungeon.player.stance instanceof BerserkerStance) {
                            t = BaseMod.getKeywordTitle("champ:resolve");
                            d = BaseMod.getKeywordDescription("champ:resolve");
                        }
                        if (!t.equals("ERROR")) {
                            if ((float) InputHelper.mX < 1400.0F * Settings.scale) {
                                TipHelper.renderGenericTip(
                                        (float) InputHelper.mX + 60.0F * Settings.scale, (float) InputHelper.mY - 50.0F * Settings.scale,
                                        t,
                                        d);
                            } else {
                                TipHelper.renderGenericTip((float) InputHelper.mX - 350.0F * Settings.scale, (float) InputHelper.mY - 50.0F * Settings.scale,
                                        t, d);
                            }
                        }
                    }
                }
            }
    }
}