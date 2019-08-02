class DataMatrix implements BarcodeIO {

   public static final char BLACK_CHAR = '*';
   public static final char WHITE_CHAR = ' ';
   private BarcodeImage image;
   private String text;
   private int actualWidth, actualHeight;

   public DataMatrix() {
      this.text = "";
      this.image = new BarcodeImage();
      this.actualHeight = 0;
      this.actualHeight = 0;

   }

   public DataMatrix(BarcodeImage image) {
      scan(image);
   }

   public DataMatrix(String text) {
      readText(text);
   }

   public boolean scan(BarcodeImage image) {

      this.image = image;
      image.clone();
      cleanImage();
      this.actualHeight = computeSignalHeight();
      this.actualWidth = computeSignalWidth();

      return true;

   }
   public boolean readText(String text) {
      this.text = text;
      return true;
   }
   public boolean generateImageFromText() {

      // i + 1 because we throw away closed limitation line
      for (int i = 0; i < text.length(); i++) {
         // WriteCharToCol(i + 1, (int) text.charAt(i));
      }

      WriteCharToCol(1, 87);
      return true;

   }
   public boolean translateImageToText() {
      String tempString = "";

      // Throw away Closed Limitation Line
      for (int i = 1; i < actualWidth; i++) {
         tempString = tempString + "" + readCharFromCol(i);
      }

      text = tempString;
      return true;
   }
   public void displayTextToConsole() {
      System.out.println(text);
   }
   public void displayImageToConsole() {
      System.out.println("-------------------------------------------");
      for (int i = (BarcodeImage.MAX_HEIGHT - actualHeight - 1); i <
         BarcodeImage.MAX_HEIGHT; i++) {

         System.out.print("|");

         for (int k = 0; k < (actualWidth + 1); k++) {
            if (image.getPixel(i,k)) {
               System.out.print(BLACK_CHAR);
            }
            else {
               System.out.print(WHITE_CHAR);
            }
         }

         System.out.print("|\n");
      }
      System.out.println("-------------------------------------------");
   }

   // Accessors
   public int getActualWidth() {
      return actualWidth;
   }
   public int getActualHeight() {
      return actualHeight;
   }
   private int computeSignalWidth() {
      // Temp holder
      int first_col = BarcodeImage.MAX_WIDTH;
      int last_col = BarcodeImage.MAX_WIDTH;

      // i stand for Row
      for (int i = 0; i < BarcodeImage.MAX_HEIGHT; i++) {
         // k stand for column
         for (int k = 0; k < BarcodeImage.MAX_WIDTH; k++) {

            // Find first * on the left
            if (image.getPixel(i, k)) {

               // Save first * on the left position
               if (first_col == BarcodeImage.MAX_WIDTH) {
                  first_col = k;
               }
               // Save the last * on the right last row
               last_col = k;
            }
         }
      }

      // actual width
      return last_col - first_col;
   }
   private int computeSignalHeight() {

      // Temp holder
      int first_row = BarcodeImage.MAX_HEIGHT;
      int last_row = BarcodeImage.MAX_HEIGHT;

      // i stand for Row
      for (int i = 0; i < BarcodeImage.MAX_HEIGHT; i++) {
         // k stand for column
         for (int k = 0; k < BarcodeImage.MAX_WIDTH; k++) {

            // Find first row with *
            if (image.getPixel(i, k)) {
               // Save first * on the left position
               if (first_row == BarcodeImage.MAX_HEIGHT) {
                  first_row = i;
               }
               // Save the last row
               last_row = i;
            }
         }
      }

      // actual width
      return last_row - first_row;
   }

   private void cleanImage() {

      // find the x,y position on the first and last * on the image
      // (Closed Limitation Line)

      int first_row = 0;
      int last_row = 0;
      int first_col = 0;
      int last_col = 0;

      // i stand for Row
      for (int i = 0; i < BarcodeImage.MAX_HEIGHT; i++) {
         // k stand for column
         for (int k = 0; k < BarcodeImage.MAX_WIDTH; k++) {

            // Find first row with *
            if (image.getPixel(i, k)) {
               // Save first * on the left position
               if (first_row == 0) {
                  first_row = i;
                  first_col = k;
               }
               // Save the last row
               last_row = i;
               last_col = k;
            }
         }
      }

      // Get the different between MAX_HEIGHT vs Last height * found
      // MAX_HEIGHT - 1 because array start at 0 so 0~29 = 30
      int differenceHeight = (BarcodeImage.MAX_HEIGHT - 1) - last_row;
      int differenceWidth = 0 - first_col;

      // Align left bottom
      for (int i = first_row; i < last_row + 1; i++) {
         // k stand for column
         for (int k = first_col; k < last_col + 1; k++) {
            if (image.getPixel(i, k)) {

               // Delete old pixel
               image.setPixel(i, k, false);

               // Update new pixel
               image.setPixel(i + differenceHeight, k + differenceWidth, true);
            }
            else {

               // Update new Pixel
               image.setPixel(i + differenceHeight, k + differenceWidth,
                  false);
            }
         }
      }
   }

   private char readCharFromCol(int col) {
      int tempCount = 0;
      int tempTotal = 0;

      // Throw away top and bottom row
      for (int i = (BarcodeImage.MAX_HEIGHT - actualHeight); i <
         BarcodeImage.MAX_HEIGHT - 1; i++) {

         if (image.getPixel(i,col)) {
            // Calculate total

            if (tempCount == 0) {
               tempTotal += 128;
            }
            else if (tempCount == 1) {
               tempTotal += 64;
            }
            else if (tempCount == 2) {
               tempTotal += 32;
            }
            else if (tempCount == 3) {
               tempTotal += 16;
            }
            else if (tempCount == 4) {
               tempTotal += 8;
            }
            else if (tempCount == 5) {
               tempTotal += 4;
            }
            else if (tempCount == 6) {
               tempTotal += 2;
            }
            else if (tempCount == 7) {
               tempTotal += 1;
            }
         }
         tempCount++;
      }

      return (char) tempTotal;

   }

   private boolean WriteCharToCol(int col, int code) {

      return true;
   }
}