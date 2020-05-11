package ch.kalunight.zoeshuffle.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.kalunight.zoeshuffle.ZoeSchufflePlugin;
import ch.kalunight.zoeshuffle.model.BlockLevel;
import ch.kalunight.zoeshuffle.model.GameStatus;
import ch.kalunight.zoeshuffle.model.ShufflePlayer;
import ch.kalunight.zoeshuffle.util.BlockUtil;

public class ShuffleStart implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    sender.getServer().broadcastMessage("La partie démarre !");
    
    for(Player playerToAdd : sender.getServer().getOnlinePlayers()) {
      ShufflePlayer player = new ShufflePlayer(playerToAdd);
      
      player.setBlockToFind(BlockUtil.getRandomBlock(BlockLevel.EASY));
      
      player.getPlayer().getServer().broadcastMessage("Le premier bloc de " + player.getPlayer().getDisplayName() + " est " + player.getBlockToFind().toString());
      
      ZoeSchufflePlugin.getPlayers().add(player);
    }
    
    ZoeSchufflePlugin.setGameStatus(GameStatus.IN_GAME);
    return false;
  }

}
