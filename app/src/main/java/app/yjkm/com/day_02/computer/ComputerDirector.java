package app.yjkm.com.day_02.computer;

/**
 * 负责构建computer
 */
public class ComputerDirector {

    ComputerBuilder mBuilder = null;

    public ComputerDirector(ComputerBuilder builder) {
        this.mBuilder = builder;
    }

    public void construct(String board, String display) {
        mBuilder.builderBoard(board);
        mBuilder.builderDisplay(display);
        mBuilder.builderOS();
    }

}
