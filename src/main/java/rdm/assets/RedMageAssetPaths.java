package rdm.assets;

public enum RedMageAssetPaths {
    // Orbs
    ENERGY_SYMBOL("img/rdm_energy_symbol.png"),

    // 512
    ENERGY_ORB("img/512/rdm_energy_orb.png"),

    ATTACK_CARD("img/512/rdm_attack.png"),
    ATTACK_ENCHANTED_ADDON("img/512/rdm_attack_enchanted.png"),
    ATTACK_BLACK_MAGIC_ADDON("img/512/rdm_attack_blackmagic.png"),
    ATTACK_WHITE_MAGIC_ADDON("img/512/rdm_attack_whitemagic.png"),

    SKILL_CARD("img/512/rdm_skill.png"),
    SKILL_ENCHANTED_ADDON("img/512/rdm_skill_enchanted.png"),
    SKILL_BLACK_MAGIC_ADDON("img/512/rdm_skill_blackmagic.png"),
    SKILL_WHITE_MAGIC_ADDON("img/512/rdm_skill_whitemagic.png"),

    POWER_CARD("img/512/rdm_power.png"),
    //TODO: Create BLM/WHM art for Powers.
    POWER_BLACK_MAGIC_ADDON("img/512/rdm_power.png"),
    POWER_WHITE_MAGIC_ADDON("img/512/rdm_power.png"),

    // 1024
    ENERGY_ORB_PORTRAIT("img/1024/rdm_energy_orb_p.png"),

    ATTACK_CARD_PORTRAIT("img/1024/rdm_attack_p.png"),
    ATTACK_ENCHANTED_ADDON_PORTRAIT("img/1024/rdm_attack_enchanted_p.png"),
    ATTACK_BLACK_MAGIC_ADDON_PORTRAIT("img/1024/rdm_attack_blackmagic_p.png"),
    ATTACK_WHITE_MAGIC_ADDON_PORTRAIT("img/1024/rdm_attack_whitemagic_p.png"),

    SKILL_CARD_PORTRAIT("img/1024/rdm_skill_p.png"),
    SKILL_ENCHANTED_ADDON_PORTRAIT("img/1024/rdm_skill_enchanted_p.png"),
    SKILL_BLACK_MAGIC_ADDON_PORTRAIT("img/1024/rdm_skill_blackmagic_p.png"),
    SKILL_WHITE_MAGIC_ADDON_PORTRAIT("img/1024/rdm_skill_whitemagic_p.png"),

    POWER_CARD_PORTRAIT("img/1024/rdm_power_p.png"),
    //TODO: Create BLM/WHM art for Powers.
    POWER_BLACK_MAGIC_ADDON_PORTRAIT("img/1024/rdm_power_p.png"),
    POWER_WHITE_MAGIC_ADDON_PORTRAIT("img/1024/rdm_power_p.png"),

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
    ORB_BLACK_MANA("img/mana/rdm_orb_blackmana.png"),
    ORB_WHITE_MANA("img/mana/rdm_orb_whitemana.png"),

    // mana 1-100 for balance gauge
    TOPPANEL_BLACK_MANA("img/mana/rdm_orb_blackmana.png"),
    TOPPANEL_WHITE_MANA("img/mana/rdm_orb_whitemana.png"),

    // JSON strings
    CARD_STRINGS("localization/RedMageCards.json"),
    CHARACTER_STRINGS("localization/RedMageCharacter.json"),
    RELIC_STRINGS("localization/RedMageRelics.json"),

    // Relics
    RELIC_SOULGEM("img/relics/rdm_soulgem.png"),
    RELIC_SOULGEM_OUTLINE("img/relics/rdm_soulgem_ol.png"),
    RELIC_DUALCAST("img/relics/rdm_dualcast.png"),
    RELIC_DUALCAST_OUTLINE("img/relics/rdm_dualcast_ol.png");

    private final String filePath;

    RedMageAssetPaths(final String filePath) { this.filePath = filePath; }

    public String getFilePath() { return filePath; }
}
