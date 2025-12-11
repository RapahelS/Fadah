package info.preva1l.fadah.utils.serialization;

import lombok.experimental.UtilityClass;
import org.bukkit.inventory.ItemStack;

import java.util.Base64;

@UtilityClass
public class ItemSerializer {
    public static String serialize(ItemStack item) {
        return Base64.getEncoder().encodeToString(item.serializeAsBytes());
    }

    public static ItemStack deserialize(String source) {
        try {
            return ItemStack.deserializeBytes(Base64.getDecoder().decode(source));
        } catch (IllegalArgumentException e) {
            return new ItemStack(org.bukkit.Material.AIR);
        }
    }
}
