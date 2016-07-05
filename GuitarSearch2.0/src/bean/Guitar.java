package bean;
public class Guitar {

  private String serialNumber;
  private double price;
  GuitarSpec spec;

  public Guitar(String serialNumber, double price, 
                String builder, String model, String type,
                String backWood, String topWood) {
    this.serialNumber = serialNumber;
    this.price = price;
    this.spec = new GuitarSpec(builder, model, type, backWood, topWood);
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(float newPrice) {
    this.price = newPrice;
  }

  public GuitarSpec getSpec() {
    return spec;
  }
}
