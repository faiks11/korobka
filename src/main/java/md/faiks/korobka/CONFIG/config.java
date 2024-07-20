package md.faiks.korobka.CONFIG;


import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import net.minecraft.text.Text;

import static md.faiks.korobka.Korobka.MODID;

@Config(name = MODID)
public class config implements ConfigData {

    @ConfigEntry.Gui.Tooltip
    public String NICKNAME = "";

    @ConfigEntry.Gui.Tooltip
    public Boolean enable = true;

    @ConfigEntry.Gui.Tooltip
    public Boolean enableSound = true;


}
