package ch.kalunight.zoeshuffle;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

import ch.kalunight.zoeshuffle.commands.ShuffleStart;
import ch.kalunight.zoeshuffle.model.GameStatus;
import ch.kalunight.zoeshuffle.model.ShufflePlayer;
import ch.kalunight.zoeshuffle.workers.GameWorker;

public class ZoeSchufflePlugin extends JavaPlugin {

  private static GameStatus gameStatus;
  
  private static List<ShufflePlayer> players = new ArrayList<>();
  
  private static Server server;
  
  private static ZoeSchufflePlugin plugin;
  
  @Override
  public void onEnable() {
    setPlugin(this);

    setMinecraftServer(getServer());
    
    this.getCommand("shuffleStart").setExecutor(new ShuffleStart());
    
    getServer().getScheduler().runTaskTimer(this, new GameWorker(), 20, 20);
  }
  
  @Override
  public void onDisable() {
    
  }
  
  public static void main(String[] args) {
  }
  
  public static void setPlugin(ZoeSchufflePlugin plugin) {
    ZoeSchufflePlugin.plugin = plugin;
  }
  
  private static void setMinecraftServer(Server server) {
    ZoeSchufflePlugin.server = server;
  }

  public static GameStatus getGameStatus() {
    return gameStatus;
  }

  public static void setGameStatus(GameStatus gameStatus) {
    ZoeSchufflePlugin.gameStatus = gameStatus;
  }

  public static List<ShufflePlayer> getPlayers() {
    return players;
  }
  
}
