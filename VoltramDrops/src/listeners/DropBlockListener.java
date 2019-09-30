package listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class DropBlockListener implements Listener{
	List<String> entityList = new ArrayList<String>();
	
	@SuppressWarnings("unlikely-arg-type")
	@EventHandler
    public void onEntityChangeBlock(EntityChangeBlockEvent e)
    {
        if (e.getEntity() instanceof FallingBlock)
        {
            if (this.containsBlock(e.getEntity().getUniqueId()))
            {
                e.getBlock().setType(Material.DIAMOND_BLOCK);
                this.removeEntityBlock(e.getEntity().getUniqueId());
            }
            else
            {
            	this.addEntityUUID(e.getEntity().getUniqueId());
            }
        }
    }
 
    public void addEntityUUID(UUID id)
    {
        String uuid = id.toString();
        this.entityList.add(uuid);
    }
 
    public void removeEntityBlock(UUID id)
    {
        String uuid = id.toString();
        if (this.entityList.contains(uuid)) this.entityList.remove(uuid);
    }
 
    public boolean containsBlock(UUID id)
    {
        String uuid = id.toString();
        if (this.entityList.contains(uuid))
        {
            return true;
        }
        return false;
    }


}
