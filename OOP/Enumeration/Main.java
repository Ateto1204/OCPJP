package build;

interface AlertAble {
    void alert();
}

enum AlertAblePowerState implements AlertAble {
    OFF("The power if off") {
        @Override
        public void alert() {
            System.out.println("OFF alert");
        }
    }, 
    ON("The power is high"), 
    SUSPEND("The power is low");

    @Override
    public void alert() {
        System.out.println("default alert");
    }

    private String description;

    private AlertAblePowerState(String d) {
        description = d;
    }

    public String getDescription() {
        return description;
    }

    public void changeDescription(String d) {
        description = d;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(AlertAblePowerState.OFF.ordinal());
        System.out.println(AlertAblePowerState.ON.ordinal());
        System.out.println(AlertAblePowerState.SUSPEND.ordinal());

        System.out.println(AlertAblePowerState.OFF.getDescription());
        System.out.println(AlertAblePowerState.ON.getDescription());
        System.out.println(AlertAblePowerState.SUSPEND.getDescription());

        AlertAblePowerState.OFF.changeDescription("the power is shutdown");
        System.out.println(AlertAblePowerState.OFF.getDescription());

        AlertAblePowerState.OFF.alert();
        AlertAblePowerState.ON.alert();
        AlertAblePowerState.SUSPEND.alert();
    }
}
