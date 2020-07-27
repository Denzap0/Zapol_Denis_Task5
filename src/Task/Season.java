package Task;

public enum Season {
    SUMMER(1),
    AUTUMN(0.7),
    WINTER(0.3);

    public double adhesionCoef;

    Season() {

    }

    Season(double adhesionCoef) {
        this.adhesionCoef = adhesionCoef;
    }

    public double getAdhesionCoef() {
        return adhesionCoef;
    }

    public void setAdhesionCoef(double adhesionCoef) {
        this.adhesionCoef = adhesionCoef;
    }
}
