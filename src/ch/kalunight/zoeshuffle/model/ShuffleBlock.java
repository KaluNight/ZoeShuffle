package ch.kalunight.zoeshuffle.model;

import org.bukkit.Material;

public enum ShuffleBlock {
  SAND(BlockLevel.EASY, Material.SAND),
  STONE(BlockLevel.EASY, Material.STONE),
  GRAVEL(BlockLevel.MEDIUM, Material.GRAVEL),
  OBSIDIAN(BlockLevel.HARD, Material.OBSIDIAN);
  
  private BlockLevel level;
  private Material block;
  
  ShuffleBlock(BlockLevel level, Material material) {
    this.level = level;
    this.block = material;
  }

  public BlockLevel getLevel() {
    return level;
  }

  public Material getBlock() {
    return block;
  }

}
