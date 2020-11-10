package hm13;

public class SystemBlock {
    private Processor processor;
    private MotherBoard motherBoard;

    public SystemBlock(Processor processor, MotherBoard motherBoard) {
        this.processor = processor;
        this.motherBoard = motherBoard;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public MotherBoard getMotherBoard() {
        return motherBoard;
    }

    public void setMotherBoard(MotherBoard motherBoard) {
        this.motherBoard = motherBoard;
    }
    public void printInfo(){
        System.out.println("System Block contains " + "Processor: " + getProcessor().getCPUtypes() +", " + getProcessor().getColor() + " and Mother Board: " + getMotherBoard().getType() + ", " + getMotherBoard().getBrand());
    }
}
