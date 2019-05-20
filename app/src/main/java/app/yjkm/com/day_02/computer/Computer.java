package app.yjkm.com.day_02.computer;

/**
 * 电脑超类
 */
public abstract class Computer {
    protected String mBoard;
    protected String mDisplay;
    protected String mOS;

    protected Computer() {
    }

    /**
     * 设置cpu
     * @param Board
     */
    public void setBoard(String Board) {
        mBoard = Board;
    }

    /**
     * 设置内存
     * @param Display
     */
    public void setDisplay(String Display) {
        mDisplay = Display;
    }

    /**
     * 设置系统
     */
    public abstract void setOS();

    @Override
    public String toString() {
        return "Computer{" +
                "mBoard='" + mBoard + '\'' +
                ", mDisplay='" + mDisplay + '\'' +
                ", mOS='" + mOS + '\'' +
                '}';
    }
}
