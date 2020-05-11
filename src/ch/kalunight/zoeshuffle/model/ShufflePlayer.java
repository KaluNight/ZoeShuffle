package ch.kalunight.zoeshuffle.model;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class ShufflePlayer {

  private Player player;
  
  private int easyBlockFound = 0;
  private int mediumBlockFound = 0;
  private int hardBlockFound = 0;
  
  private List<ShuffleBlock> blocksFound = new ArrayList<>();
  
  private ShuffleBlock blockToFind;
  
  public ShufflePlayer(Player player) {
    this.player = player;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public int getEasyBlockFound() {
    return easyBlockFound;
  }

  public void setEasyBlockFound(int easyBlockFound) {
    this.easyBlockFound = easyBlockFound;
  }

  public int getMediumBlockFound() {
    return mediumBlockFound;
  }

  public void setMediumBlockFound(int mediumBlockFound) {
    this.mediumBlockFound = mediumBlockFound;
  }

  public int getHardBlockFound() {
    return hardBlockFound;
  }

  public void setHardBlockFound(int hardBlockFound) {
    this.hardBlockFound = hardBlockFound;
  }

  public ShuffleBlock getBlockToFind() {
    return blockToFind;
  }

  public void setBlockToFind(ShuffleBlock blockToFind) {
    this.blockToFind = blockToFind;
  }

  public List<ShuffleBlock> getBlocksFound() {
    return blocksFound;
  }
  
}
