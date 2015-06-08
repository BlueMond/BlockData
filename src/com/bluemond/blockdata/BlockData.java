package com.bluemond.blockdata;

import java.util.Map;
import org.spongepowered.api.event.Subscribe;
import org.spongepowered.api.event.state.ServerStartedEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.world.Location;

@Plugin(id="SgPg", name="SpongePlugin", version="1.0")
public class BlockData {
    private Map data;

    @Subscribe
    public void onStart(ServerStartedEvent event) {
        FileHandler FH = new FileHandler();
        System.out.println("Getting data");
        this.data = FH.getData();
    }

    public Map getDataMap() {
        return this.data;
    }

    public Object getProperty(Location block, String property) {
        String hold = String.valueOf(block.getBlockX()) + ":" + block.getBlockY() + ":" + block.getBlockZ();
        Map blockData = (Map)this.data.get(hold);
        Object prop = blockData.get(property);
        return prop;
    }
}
