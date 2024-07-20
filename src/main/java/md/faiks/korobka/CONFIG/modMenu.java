package md.faiks.korobka.CONFIG;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;


public class modMenu implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
            return parent -> AutoConfig.getConfigScreen(config.class, parent).get();
    }
}
