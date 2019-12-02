package house;

import Exceptions.NotFoundHouse;
import util.Constants;

public class HouseFactory {
    public static House createHouse (int position) throws NotFoundHouse {
        if (position <=0 && position >=101)
            throw new NotFoundHouse();

        if (position == 27 || position == 40 || position == 43 || position == 54 ||
                position == 66 || position == 76 || position == 89 || position == 99){
            return mappedSnake(position);
        }

        else if (position == 04 || position == 13 || position == 33
                ||position ==  42||
                position ==  50 || position == 62  || position ==  74)
            return mappedLadder(position);

        else if (position == 16 || position == 36 ||
                position == 60 || position ==  77 || position == 98)
            return mappedCardWalkBack(position);

        else if (position == 7 || position == 29 || position ==  45 ||
                position ==  64|| position ==  86 )
            return mappedCardWalkFurther(position);
        else
            return new NormalHouse(position);

    }
    private static House mappedSnake(int position){
        Snake snake  = new Snake();
        if(position == 27){
            snake.setHeadSnakePosition(27);
            snake.setTailSnakePosition(5);
        }
       else if(position == 40){
            snake.setHeadSnakePosition(40);
            snake.setTailSnakePosition(3);
        }
       else if(position == 43){
            snake.setHeadSnakePosition(43);
            snake.setTailSnakePosition(18);
        }
       else if(position == 54){
            snake.setHeadSnakePosition(54);
            snake.setTailSnakePosition(31);
        }
       else if(position == 66){
            snake.setHeadSnakePosition(66);
            snake.setTailSnakePosition(45);
        }
       else if(position == 76){
            snake.setHeadSnakePosition(76);
            snake.setTailSnakePosition(58);
        }
       else if(position == 89){
            snake.setHeadSnakePosition(89);
            snake.setTailSnakePosition(53);
        }
        else if(position == 99){
            snake.setHeadSnakePosition(99);
            snake.setTailSnakePosition(41);
        }
        return snake;
    }

    private static House mappedLadder(int position){
        Ladder ladder = new Ladder();
        if (position == 04){
            ladder.setBottomLadderPosition(04);
            ladder.setTopLadderPosition(25);
        }
        else if (position == 13){
            ladder.setBottomLadderPosition(13);
            ladder.setTopLadderPosition(46);
        }
        else if (position == 33){
            ladder.setBottomLadderPosition(33);
            ladder.setTopLadderPosition(49);
        }
        else if (position == 42){
            ladder.setBottomLadderPosition(42);
            ladder.setTopLadderPosition(63);
        }
        else if (position == 50){
            ladder.setBottomLadderPosition(50);
            ladder.setTopLadderPosition(69);
        }
        else if (position == 62){
            ladder.setBottomLadderPosition(62);
            ladder.setTopLadderPosition(81);
        }
        else if (position == 74){
            ladder.setBottomLadderPosition(74);
            ladder.setTopLadderPosition(92);
        }
        return ladder;
    }

    private static House mappedCardWalkBack (int position){

        return  new CardWalkBack();

    }

    private static House mappedCardWalkFurther (int position){
        return new CardWalkFuther();
    }
}
