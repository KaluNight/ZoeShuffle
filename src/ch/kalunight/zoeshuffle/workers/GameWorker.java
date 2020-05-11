package ch.kalunight.zoeshuffle.workers;

import org.bukkit.Location;
import org.bukkit.block.Block;

import ch.kalunight.zoeshuffle.ZoeSchufflePlugin;
import ch.kalunight.zoeshuffle.model.BlockLevel;
import ch.kalunight.zoeshuffle.model.GameStatus;
import ch.kalunight.zoeshuffle.model.ShufflePlayer;
import ch.kalunight.zoeshuffle.util.BlockUtil;

public class GameWorker implements Runnable {

  @Override
  public void run() {
    if(ZoeSchufflePlugin.getGameStatus().equals(GameStatus.IN_GAME)) {
      for(ShufflePlayer player : ZoeSchufflePlugin.getPlayers()) {
        Location playerLocation = player.getPlayer().getLocation();
        playerLocation.setY(playerLocation.getY() - 1);
        Block block = player.getPlayer().getWorld().getBlockAt(playerLocation);

        if(block.getType().equals(player.getBlockToFind().getBlock())) {
          
          player.getPlayer().getServer().broadcastMessage(player.getPlayer().getDisplayName() + " a trouvé son bloc (" + player.getBlockToFind().toString() + ") !");
          
          player.getBlocksFound().add(player.getBlockToFind());
          
          if(player.getBlocksFound().size() == 3) {
            player.getPlayer().getServer().broadcastMessage("Le joueur " + player.getPlayer().getDisplayName() + " a gagné la partie !");
            
            ZoeSchufflePlugin.setGameStatus(GameStatus.ENDED);
          }else {
            if(player.getBlocksFound().size() == 1) {
              player.setBlockToFind(BlockUtil.getRandomBlock(BlockLevel.MEDIUM));
            }else {
              player.setBlockToFind(BlockUtil.getRandomBlock(BlockLevel.HARD));
            }
            
            player.getPlayer().getServer().broadcastMessage("Le prochain bloc à trouver de " + player.getPlayer().getDisplayName() + " est " + player.getBlockToFind().toString() + " !");
          }
        }
      }
    }
  }

}
