package parking;

public class Slot {

    private final String slotName;
    private final int slotWidth;
    private final int slotDepth;
    private final int slotCost;
    private boolean available = true;
    private Vehicle currentVehicle;
    private Duration duration;


    public Slot(SlotBuilder slotBuilder) {
        this.slotName = slotBuilder.slotName;
        this.slotWidth = slotBuilder.slotWidth;
        this.slotDepth = slotBuilder.slotDepth;
        this.slotCost = slotBuilder.slotCost;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setCurrentVehicle(Vehicle currentVehicle) {
        this.currentVehicle = currentVehicle;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public int getSlotCost() {
        return slotCost;
    }

    public String getSlotName() {
        return slotName;
    }

    public int getSlotWidth() {
        return slotWidth;
    }

    public int getSlotDepth() {
        return slotDepth;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    public Duration getDuration() {
        return duration;
    }

    public boolean isAvailable() {
        return available;
    }

    public static class SlotBuilder {
        private String slotName;
        private int slotWidth;
        private int slotDepth;
        private int slotCost;

        void SlotBuilder() {
        }

        public SlotBuilder setSlotCost(int slotCost) {
            this.slotCost = slotCost;
            return this;
        }

        public SlotBuilder setSlotName(String slotName) {
            this.slotName = slotName;
            return this;
        }

        public SlotBuilder setSlotWidth(int slotWidth) {
            this.slotWidth = slotWidth;
            return this;
        }

        public SlotBuilder setSlotDepth(int slotDepth) {
            this.slotDepth = slotDepth;
            return this;
        }

        public Slot build() {
            return new Slot(this);
        }
    }

    void print() {
        System.out.println(slotName + " { " + "Width: " + slotWidth + "  Depth: " + slotDepth + " Available : " + isAvailable() + " }");
    }
}
