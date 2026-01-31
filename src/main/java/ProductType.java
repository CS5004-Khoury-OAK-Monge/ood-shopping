public enum ProductType {
    ELECTRONICS, TOYS, GROCERIES, FURNITURE;

    public String toString() {
        String result;
        switch(this) {
            case ELECTRONICS:
                result = "Electronics";
                break;
            case TOYS:
                result = "Toys";
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
