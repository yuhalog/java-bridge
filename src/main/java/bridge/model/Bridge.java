package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.exception.BridgeSizeException;
import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private List<String> bridge;

    public Bridge() {
        this.bridge = new ArrayList<>();
    }

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public void make(String size) {
        int validatedSize = validateSize(size);
        this.bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(validatedSize);
    }

    private int validateSize(String size) {
        BridgeSizeException.validate(size);
        return Integer.parseInt(size);
    }

    public boolean isRightMoving(int index, String moving) {
        return moving.equals(bridge.get(index));
    }
}
