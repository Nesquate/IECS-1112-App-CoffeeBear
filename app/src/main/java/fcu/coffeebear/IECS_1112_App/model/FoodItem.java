package fcu.coffeebear.IECS_1112_App.model;

public class FoodItem {
    int imageId;
    String foodName;
    String foodIntro;
    int foodPrice;

    public FoodItem(int imageId, String foodName, String foodIntro, int foodPrice) {
        this.imageId = imageId;
        this.foodName = foodName;
        this.foodIntro = foodIntro;
        this.foodPrice = foodPrice;
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
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

}
