# How to read QR Code or Barcode from Images

<h3>Basic Understanding of QR Code or Barcode</h3>
<p> Curious on knowing how Android Apps scan the Barcodes or QR codes from the camera?

The android apps designed to scan 1D & 2D barcodes on a high level convert the data the camera into image bytes to the below library, which in-turn return the data embedded within the bar codes.

Reading Barcodes / QR codes from images seems to be difficult & using the below open source libraries(ZXing - Zebra Crossing) provided by Google will make it simple for any application to include this functionality.

In real Time, we are using QR code in daily use. Some of famous application are paytm, phonepe, amazon pay, etc.,</p>

<h5> How to valiate QR Code or Barcode from image in android/iOS app.</h5>
Below code are example for unit testing.</h5>

 <h3>Add maven repository to pom.xml file.</h3>
<code>
		<!-- https://mvnrepository.com/artifact/com.google.zxing/core -->
		<dependency3
			<groupId>com.google.zxing</groupId>
			<artifactId>core</artifactId>
			<version>3.4.0</version>
		</dependency>
</code>
<code>
		<!-- https://mvnrepository.com/artifact/com.google.zxing/javase -->
		<dependency>
			<groupId>com.google.zxing</groupId>
			<artifactId>javase</artifactId>
			<version>3.4.0</version>
		</dependency>
</code>

<h3> Unit testing for QR Code write/read operation.</h3>
<pre>
package base;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LearningPath {
    public static void main(String[] args) throws WriterException, IOException, NotFoundException {
        // pass the hiding information
        String qrCodeData = "prabagaran95@upi";
        //sample QR Code
        String filePath = "/Users/prabagaran/Downloads/qacode.png"; 
        String charset = "UTF-8";
        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        //Creating the QR code 
        createQRCode(qrCodeData, filePath, charset, hintMap, 200, 200);
        System.out.println("Reading information from QR Code: " + readQRCode(filePath, charset, hintMap));
    }

    /**
     * Used to hide the information in QR code
     * @throws WriterException
     * @throws IOException
     */
    public static void createQRCode(String qrCodeData, String filePath, String charset, Map hintMap, int qrCodeheight, int qrCodewidth)  throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode( new String(qrCodeData.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);
        MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), new File(filePath));
        System.out.println("Writing information into QR Code ");
    }

    /**
     * Used to read the information in QR code
     * @throws FileNotFoundException
     * @throws IOException
     * @throws NotFoundException
     */
    public static String readQRCode(String filePath, String charset, Map hintMap) throws FileNotFoundException, IOException, NotFoundException {
        BinaryBitmap bitMap = new BinaryBitmap(new HybridBinarizer( new BufferedImageLuminanceSource( ImageIO.read(new FileInputStream(filePath)))));
        Result qrCodeResult = new MultiFormatReader().decode(bitMap, hintMap);
        return qrCodeResult.getText();
    }
}
</pre>


  
