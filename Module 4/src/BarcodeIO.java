
public interface BarcodeIO {
    
    //accepts an image and stores a copy
    public boolean scan(BarcodeImage bc);
    //accepts a string
    public boolean readText(String text);
    //takes an image and associates it with a text
    public boolean generateImageFromText();
    //takes a text and associates it with an image
    public boolean translateImageToText();
    //displays the text
    public void displayTextToConsole();
    //displays the image
    public void displayImageToConsole();
}
