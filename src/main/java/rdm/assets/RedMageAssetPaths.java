package rdm.assets;

public enum RedMageAssetPaths {
    // base
    CARD_ENERGY_ORB("img/manaSymbol.png"),

    // 512
    ATTACK_CARD("img/512/rdm_attack.png"),
    ATTACK_ENCHANTED_ADDON("img/512/rdm_attack_enchanted"),
    ATTACK_SPELL_ADDON("img/512/rdm_attack_spell"),
    ATTACK_BLACK_MAGIC_ADDON("img/512/rdm_attack_blackmagic.png"),
    ATTACK_WHITE_MAGIC_ADDON("img/512/rdm_attack_whitemagic.png"),

    SKILL_CARD("img/512/rdm_skill.png"),
    SKILL_ENCHANTED_ADDON("img/512/rdm_skill_enchanted"),
    SKILL_SPELL_ADDON("img/512/rdm_skill_spell"),
    SKILL_BLACK_MAGIC_ADDON("img/512/rdm_skill_blackmagic.png"),
    SKILL_WHITE_MAGIC_ADDON("img/512/rdm_skill_whitemagic.png"),

    POWER_CARD("img/512/rdm_power.png"),
    POWER_ENCHANTED_ADDON("img/512/rdm_power_enchanted"),
    POWER_SPELL_ADDON("img/512/rdm_power_spell"),
    POWER_BLACK_MAGIC_ADDON("img/512/rdm_power_blackmagic.png"),
    POWER_WHITE_MAGIC_ADDON("img/512/rdm_power_whitemagic.png"),

    ENERGY_ORB("img/512/card_mystic_orb.png"),

    // 1024
    ATTACK_CARD_PORTRAIT("img/1024/rdm_attack.png"),
    ATTACK_ENCHANTED_ADDON_PORTRAIT("img/1024/rdm_attack_enchanted"),
    ATTACK_SPELL_ADDON_PORTRAIT("img/1024/rdm_attack_spell"),
    ATTACK_BLACK_MAGIC_ADDON_PORTRAIT("img/1024/rdm_attack_blackmagic.png"),
    ATTACK_WHITE_MAGIC_ADDON_PORTRAIT("img/1024/rdm_attack_whitemagic.png"),

    SKILL_CARD_PORTRAIT("img/1024/rdm_skill.png"),
    SKILL_ENCHANTED_ADDON_PORTRAIT("img/1024/rdm_skill_enchanted"),
    SKILL_SPELL_ADDON_PORTRAIT("img/1024/rdm_skill_spell"),
    SKILL_BLACK_MAGIC_ADDON_PORTRAIT("img/1024/rdm_skill_blackmagic.png"),
    SKILL_WHITE_MAGIC_ADDON_PORTRAIT("img/1024/rdm_skill_whitemagic.png"),

    POWER_CARD_PORTRAIT("img/1024/rdm_power.png"),
    POWER_ENCHANTED_ADDON_PORTRAIT("img/1024/rdm_power_enchanted"),
    POWER_SPELL_ADDON_PORTRAIT("img/1024/rdm_power_spell"),
    POWER_BLACK_MAGIC_ADDON_PORTRAIT("img/1024/rdm_power_blackmagic.png"),
    POWER_WHITE_MAGIC_ADDON_PORTRAIT("img/1024/rdm_power_whitemagic.png"),

    ENERGY_ORB_PORTRAIT("img/1024/card_mystic_orb.png"),

    // charSelect
    CHAR_BUTTON("img/charSelect/button.png"),
    CHAR_PORTRAIT("img/charSelect/portrait.png"),

    // char
    CORPSE("img/char/corpse.png"),
    SHOULDER_1("img/char/shoulder1.png"),
    SHOULDER_2("img/char/shoulder2.png"),
    ANIMATION("img/char/idle/Animation.scml"),
    ORB_VFX("img/char/orb/vfx.png"),

    // orbs - might be used, evoke for ultima/holy, 1-10.
    BLACK_MANA_ORB("img/mana/rdm_orb_blackmana.png"),
    WHITE_MANA_ORB("img/mana/rdm_orb_whitemana.png"),

    // mana 1-100 for balance gauge
    BLACK_MANA_TOPPANEL("img/mana/rdm_orb_blackmana.png"),
    WHITE_MANA_TOPPANEL("img/mana/rdm_orb_whitemana.png"),

    // JSON strings
    CARD_STRINGS("localization/RedMageCards.json"),
    CHARACTER_STRINGS("localization/RedMageCharacter.json"),
    RELIC_STRINGS("localization/RedMageRelics.json");

    private final String filePath;

    RedMageAssetPaths(final String filePath) { this.filePath = filePath; }

    public String getFilePath() { return filePath; }
}
