package java.example.plginname;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class conversation extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().setPlayerListName(" "); // 플레이어 리스트를 공백으로 설정하여 가림
    }

    @EventHandler
    public void onServerListPing(ServerListPingEvent event) {
        event.setMaxPlayers(0); // 플레이어 인원 수를 숨김
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        event.setCancelled(true); // 채팅 불가능하게 설정
    }
}

