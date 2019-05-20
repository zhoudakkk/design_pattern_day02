package app.yjkm.com.day_02.computer;


public class MacBookBuilder extends ComputerBuilder {

    private Computer mComputer = new MacBook();

    @Override
    public void builderBoard(String board) {
        mComputer.setBoard(board);
    }

    @Override
    public void builderDisplay(String display) {
        mComputer.setDisplay(display);
    }

    @Override
    public void builderOS() {
        mComputer.setOS();
    }

    @Override
    public Computer create() {
        //在这里总的用什么东西
        return mComputer;
    }
}
