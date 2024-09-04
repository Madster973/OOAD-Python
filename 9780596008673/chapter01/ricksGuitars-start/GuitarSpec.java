public class GuitarSpec {

    private Builder builder;
    private String model;
    private Type type;
    private int numString;
    private Wood backWood, topWood;
  
    public GuitarSpec(Builder builder, String model, Type type,
                  int numString, Wood backWood, Wood topWood) {
      this.builder = builder;
      this.model = model;
      this.type = type;
      this.numString = numString;
      this.backWood = backWood;
      this.topWood = topWood;
    }
  
    public Builder getBuilder() {
      return builder;
    }
    public String getModel() {
      return model;
    }
    public Type getType() {
      return type;
    }
    public Integer getnumString() {
        return numString;
      }
    public Wood getBackWood() {
      return backWood;
    }
    public Wood getTopWood() {
      return topWood;
    }

    public boolean matches(GuitarSpec otherGuitar) {
      if (builder != otherGuitar.getBuilder())
        return false;
      String model = otherGuitar.getModel().toLowerCase();
      if ((model != null) && (!model.equals("")) &&
          (!model.equals(otherGuitar.getModel().toLowerCase())))
        return false;
      if (type != otherGuitar.getType())
        return false;
      if (backWood != otherGuitar.getBackWood())
        return false;
      if (topWood != otherGuitar.getTopWood())
        return false;
      return true;
    }

  }
  