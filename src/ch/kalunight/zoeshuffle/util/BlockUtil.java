package ch.kalunight.zoeshuffle.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ch.kalunight.zoeshuffle.model.BlockLevel;
import ch.kalunight.zoeshuffle.model.ShuffleBlock;

public class BlockUtil {

  private static final Random random = new Random();
  
  private BlockUtil() {
  }
  
  public static ShuffleBlock getRandomBlock(BlockLevel level) {
    
    List<ShuffleBlock> pickableBlock = new ArrayList<>();
    
    for(ShuffleBlock maybeGoodDifficultyBlock : ShuffleBlock.values()) {
      if(maybeGoodDifficultyBlock.getLevel() == level) {
        pickableBlock.add(maybeGoodDifficultyBlock);
      }
    }
    
    return pickableBlock.get(random.nextInt(pickableBlock.size()));
  }
}
