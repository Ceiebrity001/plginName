package java.example.plginname;

import org.bukkit.plugin.java.JavaPlugin;

public class plugin extends JavaPlugin {
    @Override
    public void onEnable() {
        //플러그인 활성화
        getLogger().info("Jong Plugin 활성화");
    }

    @Override
    public void onDisable() {
        //플러그인 비활성화
        getLogger().info("Jong Plugin 종료");
    }}
