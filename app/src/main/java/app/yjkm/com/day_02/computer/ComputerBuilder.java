package app.yjkm.com.day_02.computer;

/**
 * 电脑Builder
 */
public abstract class ComputerBuilder {

    public abstract void builderBoard(String board);

    public abstract void builderDisplay(String display);

    public abstract void builderOS();

    public abstract Computer create();
}
