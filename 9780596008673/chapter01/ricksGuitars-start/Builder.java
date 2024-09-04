public enum Builder {
    FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS, ANY;

    public String toString() {
        switch (this) {
            case FENDER: return "FENDER";
            case MARTIN: return "MARTIN";
            case GIBSON: return "GIBSON";
            case COLLINGS: return "COLLINGS";
            case OLSON:    return "Olson";
            case RYAN:     return "Ryan";
            case PRS :     return "PRS";
            default:       return "Unspecified";
        }
    }
    
}
