public enum ProductType {
    ELECTRONICS, COSMETICS, GROCERIES, FURNITURE;

    public String toString() {
        String result;
        switch(this) {
            case ELECTRONICS:
                result = "Electronics";
                break;
            case COSMETICS:
                result = "Cosmetics";
                break;
            case GROCERIES:
                result = "Groceries";
                break;
            case FURNITURE:
                result = "Furniture";
                break;
            default:
                result = "Unknown";
        }
        return result;

    }
}
