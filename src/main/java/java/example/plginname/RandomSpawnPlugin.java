package java.example.plginname;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class RandomSpawnPlugin extends JavaPlugin {

    private World world;
    private int minX;
    private int minZ;
    private int maxX;
    private int maxZ;
    private int minY;
    private int maxY;

    @Override
    public void onEnable() {
        // 예제를 위해 기본값으로 세팅
        world = Bukkit.getWorld("world"); // 기본 월드
        minX = -100;
        minZ = -100;
        maxX = 100;
        maxZ = 100;
        minY = 10;
        maxY = 100;

        // 플레이어가 서버에 접속할 때마다 무작위 위치로 스폰
        getServer().getPluginManager().registerEvents(new PlayerSpawnListener(), this);
    }

    private class PlayerSpawnListener implements org.bukkit.event.Listener {
        @org.bukkit.event.EventHandler
        public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
            Player player = event.getPlayer();
            spawnRandomly(player);
        }
    }

    private void spawnRandomly(Player player) {
        int randomX = minX + (int)(Math.random() * ((maxX - minX) + 1));
        int randomZ = minZ + (int)(Math.random() * ((maxZ - minZ) + 1));
        int randomY = minY + (int)(Math.random() * ((maxY - minY) + 1));

        Location spawnLocation = new Location(world, randomX, randomY, randomZ);
        player.teleport(spawnLocation);
    }
}
