package rdm.assets;

public enum RedMageAssetPaths {
    // base
    CARD_ENERGY_ORB("img/manaSymbol.png"),

    // 512
    ATTACK_CARD("img/512/bg_attack_mystic.png"),
    SKILL_CARD("img/512/bg_skill_mystic.png"),
    POWER_CARD("img/512/bg_power_mystic.png"),
    ENERGY_ORB("img/512/card_mystic_orb.png"),

    // 1024
    ATTACK_CARD_PORTRAIT("img/1024/bg_attack_mystic.png"),
    SKILL_CARD_PORTRAIT("img/1024/bg_skill_mystic.png"),
    POWER_CARD_PORTRAIT("img/1024/bg_power_mystic.png"),
    ENERGY_ORB_PORTRAIT("img/1024/card_mystic_orb.png"),

    // charSelect
    CHAR_BUTTON("img/charSelect/button.png"),
    CHAR_PORTRAIT("img/charSelect/portrait.png"),

    // char
    CORPSE("img/char/corpse.png"),
    SHOULDER_1("img/char/shoulder1.png"),
    SHOULDER_2("img/char/shoulder2.png"),
    SKELETON_JSON("img/char/idle/skeleton.json"),
    SKELETON_ATLAS("img/char/idle/skeleton.atlas"),
    ANIMATION("/img/char/idle/Animation.scml"),
    ORB_VFX("img/char/orb/vfx.png"),

    // JSON strings
    CARD_STRINGS("localization/RedMageCards.json"),
    CHARACTER_STRINGS("localization/RedMageCharacter.json"),
    RELIC_STRINGS("localization/RedMageRelics.json");

    private final String filePath;

    RedMageAssetPaths(final String filePath) { this.filePath = filePath; }

    public String getFilePath() { return filePath; }
}
