package md.faiks.playertrack.CONFIG;


import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

import static md.faiks.playertrack.PlayerTrack.MODID;

@Config(name = MODID)
public class config implements ConfigData {

    @ConfigEntry.Gui.Tooltip
    public String NICKNAME = "";

    @ConfigEntry.Gui.Tooltip
    public Boolean enable = true;

    @ConfigEntry.Gui.Tooltip
    public Boolean enableSound = true;


}
