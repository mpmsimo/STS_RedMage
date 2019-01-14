package rdm.patches;

import basemod.TopPanelItem;
import com.badlogic.gdx.graphics.Texture;

import static basemod.BaseMod.logger;

public class TopPanelItemTemplate extends TopPanelItem {
    private static final Texture IMG = new Texture("yourmodresources/images/icon.png");
    public static final String ID = "yourmodname:TopPanelItemExample";

    public TopPanelItemTemplate() {
        super(IMG, ID);
    }

    @Override
    protected void onClick() {
        logger.info("Top panel item clicked.");
    }
}

