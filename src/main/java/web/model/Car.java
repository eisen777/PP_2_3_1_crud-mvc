package web.model;

public class Car {
    private Long id;
    private String model;
    private String series;

    public Car(Long id, String model, String series) {
        this.id = id;
        this.model = model;
        this.series = series;
    }

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getSeries() {
        return series;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
