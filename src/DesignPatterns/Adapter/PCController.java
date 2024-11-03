package DesignPatterns.Adapter;

public interface PCController {
    void pressButtonA();
    void pressButtonB();
}

class VRController {
    void detectMotionLeft() {
        System.out.println("Detect Motion Left");
    }

    void detectMotionRight() {
        System.out.println("Detect Motion Right");
    }
}

class VRControllerAdapter implements PCController {
    private VRController vr;

    public VRControllerAdapter(VRController vr) {
        this.vr = vr;
    }

    @Override
    public void pressButtonA() {
        vr.detectMotionLeft();
    }

    @Override
    public void pressButtonB() {
        vr.detectMotionRight();
    }
}

class GamePlatform {
    public static void main(String[] args) {
        PCController vrControllerAdapter = new VRControllerAdapter(new VRController());
        vrControllerAdapter.pressButtonA();
        vrControllerAdapter.pressButtonB();
    }
}

