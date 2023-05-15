package fcu.coffeebear.IECS_1112_App;

public class FoodItem {
    private int imageId;
    private String foodName;
    private String foodIntro;
    private int FoodPrice;

    public FoodItem(int imageId, String foodName, String foodIntro, int foodPrice) {
        this.imageId = imageId;
        this.foodName = foodName;
        this.foodIntro = foodIntro;
        FoodPrice = foodPrice;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodIntro() {
        return foodIntro;
    }

    public void setFoodIntro(String foodIntro) {
        this.foodIntro = foodIntro;
    }

    public int getFoodPrice() {
        return FoodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        FoodPrice = foodPrice;
    }
}
