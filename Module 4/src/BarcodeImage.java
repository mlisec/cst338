//Allows the reading and setting of the image
class BarcodeImage implements Cloneable {

   public static final int MAX_HEIGHT = 30;
   public static final int MAX_WIDTH = 65;
   private boolean[][] image_data;

   public BarcodeImage(){
      image_data = new boolean[MAX_WIDTH][MAX_HEIGHT];
      for (int x = 0; x < MAX_WIDTH; x++){
         for (int y = 0; y < MAX_HEIGHT; y++){
            image_data[x][y] = false;
         }
      }
   }

   public BarcodeImage(String[] str_data) {
      // Initiate array
      image_data = new boolean[MAX_HEIGHT][MAX_WIDTH];

      // Convert 1d array to 2d

      // i stand for Row
      for (int i = 0; i < str_data.length; i++) {
         // k stand for column
         for (int k = 0; k < str_data[i].length(); k++) {
            if (str_data[i].charAt(k) == DataMatrix.BLACK_CHAR) {
               image_data[i][k] = true;
            }
            else {
               image_data[i][k] = false;
            }
         }
      }
   }

   public boolean getPixel(int row, int col) {
      return image_data[row][col];
   }
   public boolean setPixel(int row, int col, boolean value) {
      return image_data[row][col] = value;
   }

   //this method creates a deep copy of the object
   public Object clone(){
      try{
         return super.clone();
      }
      catch (CloneNotSupportedException e){
         System.out.println("Cloning not allowed.");
         return this;
      }
   }
}